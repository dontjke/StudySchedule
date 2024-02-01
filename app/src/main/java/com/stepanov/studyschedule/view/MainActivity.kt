package com.stepanov.studyschedule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.stepanov.studyschedule.R
import com.stepanov.studyschedule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*if (savedInstanceState == null){
            supportFragmentManager
            .beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit()
        }*/
        binding.viewPager.adapter = ViewPagerAdapter(this)
        setTabs()
    }

    private fun setTabs() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                MAIN -> {
                    getString(R.string.main)
                }
                SCHEDULE -> {
                    getString(R.string.schedule)
                }

                else -> {
                    getString(R.string.main)
                }
            }
            tab.icon = when (position) {
                MAIN -> {
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.baseline_bookmark_24)
                }
                SCHEDULE -> {
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.baseline_bug_report_24)
                }
                else -> {
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.baseline_bookmark_24)
                }
            }
        }.attach()
    }
    companion object {
        private const val MAIN = 0
        private const val SCHEDULE = 1
    }
}