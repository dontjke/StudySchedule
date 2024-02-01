package com.stepanov.studyschedule.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.stepanov.studyschedule.R
import com.stepanov.studyschedule.databinding.FragmentMainBinding
import com.stepanov.studyschedule.view.ViewPagerAdapter
import com.stepanov.studyschedule.view.adapter.HomeworkRecyclerAdapter
import com.stepanov.studyschedule.view.adapter.LessonsForTheDayRecyclerAdapter


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    private val lessonsAdapter = LessonsForTheDayRecyclerAdapter()
    private val homeworkAdapter = HomeworkRecyclerAdapter()
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindRecyclers()
        val lessonObserver = {data: LessonState -> renderLessonData(data)}
        val homeworkObserver = {data: HomeworkState -> renderHomeworkData(data)}
        mainViewModel.getLessonData().observe(viewLifecycleOwner,lessonObserver)
        mainViewModel.getLesson()
        mainViewModel.getHomeworkData().observe(viewLifecycleOwner,homeworkObserver)
        mainViewModel.getHomework()
    }

    private fun bindRecyclers(){
        with(binding){
            lessonsForTheDayRecycler.also {
                it.adapter = lessonsAdapter
                it.layoutManager =
                    LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            }
            homeWorkRecycler.also {
                it.adapter = homeworkAdapter
                it.layoutManager =
                    LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            }
        }
    }

    private fun renderLessonData(data: LessonState) {
        when (data) {
            is LessonState.Error -> {}
            is LessonState.Loading -> {}
            is LessonState.Success -> {
               lessonsAdapter.setData(data.lessonList)
            }
        }
    }

    private fun renderHomeworkData(data: HomeworkState) {
        when (data) {
            is HomeworkState.Error -> {}
            is HomeworkState.Loading -> {}
            is HomeworkState.Success -> {
                homeworkAdapter.setData(data.homeworkList)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
