package com.stepanov.studyschedule.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stepanov.studyschedule.repository.FakeHomeworkRepository
import com.stepanov.studyschedule.repository.FakeLessonRepository

class MainViewModel(
    private val lessonData: MutableLiveData<LessonState> = MutableLiveData(),
    private val homeworkData: MutableLiveData<HomeworkState> = MutableLiveData(),
    private val fakeLessonRepository: FakeLessonRepository = FakeLessonRepository(),
    private val fakeHomeworkRepository: FakeHomeworkRepository = FakeHomeworkRepository()
): ViewModel() {

    fun getLessonData(): LiveData<LessonState>{
        return lessonData
    }
    fun getHomeworkData(): LiveData<HomeworkState>{
        return homeworkData
    }

    fun getLesson() {
        Thread{
            val answer = fakeLessonRepository.getFakeLessons()
            lessonData.postValue(LessonState.Success(answer))
        }.start()
    }

    fun getHomework(){
        Thread{
            val answer = fakeHomeworkRepository.getFakeHomework()
            homeworkData.postValue(HomeworkState.Success(answer))
        }.start()
    }




}