package com.nlv22.fitnesstimetable.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nlv22.fitnesstimetable.domain.entity.TrainingInfo
import com.nlv22.fitnesstimetable.domain.usecase.LoadTrainingInfoFromServerUseCase
import com.nlv22.fitnesstimetable.presentation.adapter.DataModelByHolder
import com.nlv22.fitnesstimetable.utils.DateTimeManager
import com.nlv22.fitnesstimetable.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(

    private val loadTrainingInfoFromServerUseCase: LoadTrainingInfoFromServerUseCase
) : ViewModel() {

    private var _trainingInfoLiveData: MutableLiveData<Resource<List<DataModelByHolder>>> =
        MutableLiveData<Resource<List<DataModelByHolder>>>()

    val trainingInfoLiveData: LiveData<Resource<List<DataModelByHolder>>>
        get() = _trainingInfoLiveData

    private val exeptionHandler = CoroutineExceptionHandler { _, exeption ->
        _trainingInfoLiveData.postValue(Resource.Error(exeption.message))
    }


    init {
        viewModelScope.launch() {
            loadTrainingInfo()
        }

    }

    suspend fun loadTrainingInfo() {
        _trainingInfoLiveData.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO + exeptionHandler) {
            val dataFromServer = loadTrainingInfoFromServerUseCase.invoke()
            val dataByPresentation = mapToPresentation(dataFromServer)
            _trainingInfoLiveData.postValue(Resource.Success(dataByPresentation))

        }
    }

    /** Группировка занятий для RecyclerView  с заголовками по дате **/
    private fun mapToPresentation(dataFromServer: TrainingInfo): List<DataModelByHolder> {
        val listWithHeaderAndLessons = mutableSetOf<DataModelByHolder>()

        dataFromServer.lessons.forEach { lesson ->

            val headerDate = DataModelByHolder.HeaderDate()
            val itemTraining = DataModelByHolder.ItemTraining()

            headerDate.title = DateTimeManager.mapperStringDateToString(lesson.date)
            itemTraining.lesson = lesson
            itemTraining.trainer = dataFromServer.trainers.findLast { trainer ->
                lesson.coach_id.equals(trainer.id)
            }

            listWithHeaderAndLessons.add(headerDate)
            listWithHeaderAndLessons.add(itemTraining)

        }
        return listWithHeaderAndLessons.toList()
    }
}
