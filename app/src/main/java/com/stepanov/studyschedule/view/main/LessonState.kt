package com.stepanov.studyschedule.view.main

import com.stepanov.studyschedule.domain.Lesson

sealed class LessonState {
    data object Loading : LessonState()
    data class Success(val lessonList: List<Lesson>) : LessonState()
    data class Error(val error: Throwable) : LessonState()
}