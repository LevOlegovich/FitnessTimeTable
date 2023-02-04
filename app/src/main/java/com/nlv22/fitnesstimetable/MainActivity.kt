package com.nlv22.fitnesstimetable

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nlv22.fitnesstimetable.databinding.ActivityMainBinding
import com.nlv22.fitnesstimetable.domain.usecase.LoadTrainingInfoFromServerUseCase
import com.nlv22.fitnesstimetable.presentation.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loadTrainingInfo: LoadTrainingInfoFromServerUseCase
    private lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding is null")

    private val viewModel by viewModels<MainFragmentViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_graph) as NavHostFragment
        navController = navHost.navController

        bottom_nav_menu.setupWithNavController(
            navController = navController
        )
    }
}
