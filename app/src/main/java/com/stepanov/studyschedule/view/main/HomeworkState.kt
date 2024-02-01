package com.stepanov.studyschedule.view.main

import com.stepanov.studyschedule.domain.Homework

sealed class HomeworkState {
    data object Loading : HomeworkState()
    data class Success(val homeworkList: List<Homework>) : HomeworkState()
    data class Error(val error: Throwable) : HomeworkState()
}
