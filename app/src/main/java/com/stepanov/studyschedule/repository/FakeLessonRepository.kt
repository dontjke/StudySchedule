package com.stepanov.studyschedule.repository

import com.stepanov.studyschedule.domain.Lesson

class FakeLessonRepository: LessonRepository {
    override fun getLessons(): List<Lesson> {
        return arrayListOf()
    }

    fun getFakeLessons(): List<Lesson>{
        return listOf(
            Lesson(
                id = 0,
                imageView = "/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg",
                name = "History",
                time = "8:00 - 8:45"
            ),
            Lesson(
                id = 1,
                imageView = "/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg",
                name = "Physics",
                time = "10:00 - 10:45"
            ),
            Lesson(
                id = 2,
                imageView = "/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg",
                name = "History",
                time = "8:00 - 8:45"
            ),
            Lesson(
                id = 3,
                imageView = "/9GBhzXMFjgcZ3FdR9w3bUMMTps5.jpg",
                name = "History",
                time = "8:00 - 8:45"
            ),
        )
    }
}