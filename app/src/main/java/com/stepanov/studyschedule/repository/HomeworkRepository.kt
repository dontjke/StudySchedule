package com.stepanov.studyschedule.repository

import com.stepanov.studyschedule.domain.Homework

interface HomeworkRepository {
    fun getHomework():List<Homework>
}