package com.stepanov.studyschedule.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stepanov.studyschedule.view.main.MainFragment
import com.stepanov.studyschedule.view.schedule.ScheduleFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :

    FragmentStateAdapter(fragmentActivity) {
    private val fragments = arrayOf(
        MainFragment(), ScheduleFragment()
    )

    companion object {
        private const val MAIN = 0
        private const val SCHEDULE = 1

    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragments[MAIN]
            1 -> fragments[SCHEDULE]
            else -> fragments[MAIN]
        }
    }
}