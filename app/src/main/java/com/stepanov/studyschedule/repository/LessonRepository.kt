package com.stepanov.studyschedule.repository

import com.stepanov.studyschedule.domain.Lesson

interface LessonRepository {
    fun getLessons():List<Lesson>
}