package com.stepanov.studyschedule.repository

import com.stepanov.studyschedule.domain.Homework

class FakeHomeworkRepository: HomeworkRepository {
    override fun getHomework(): List<Homework> {
        return arrayListOf()
    }

    fun getFakeHomework(): List<Homework>{
        return listOf(
            Homework(
                id = 0,
                name = "Literature",
                timeOut = "2 days left",
                description = "Read scenes 1.1-1,12 of The Master and Margarita"
            ),
            Homework(
                id = 1,
                name = "Physics",
                timeOut = "3 days left",
                description = "Read scenes 1.1-1,12 of The Master and Margarita"
            ),
            Homework(
                id = 2,
                name = "Literature",
                timeOut = "2 days left",
                description = "Read scenes 1.1-1,12 of The Master and Margarita"
            ),
            Homework(
                id = 3,
                name = "Literature",
                timeOut = "2 days left",
                description = "Read scenes 1.1-1,12 of The Master and Margarita"
            ),
        )
    }

}