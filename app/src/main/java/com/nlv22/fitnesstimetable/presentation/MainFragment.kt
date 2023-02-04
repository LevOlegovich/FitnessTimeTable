package com.nlv22.fitnesstimetable.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nlv22.fitnesstimetable.databinding.FragmentMainBinding
import com.nlv22.fitnesstimetable.presentation.adapter.LessonAdapter
import com.nlv22.fitnesstimetable.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding is null")

    lateinit var lessonAdapter: LessonAdapter
    val viewModel by viewModels<MainFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        binding.refreshLayout.setOnRefreshListener {
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.loadTrainingInfo()
            }
            refreshLayout.isRefreshing = false
        }

        viewModel.trainingInfoLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    progressBar.visibility = View.INVISIBLE
                    it.data?.let { list ->
                        lessonAdapter.submitList(list)
                    }

                }
                is Resource.Error -> {
                    progressBar.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                        .show()

                }
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE

                }
            }
        }
    }

    private fun initAdapter() {
        lessonAdapter = LessonAdapter()
        binding.rvLessonAdapter.apply {
            adapter = lessonAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}
