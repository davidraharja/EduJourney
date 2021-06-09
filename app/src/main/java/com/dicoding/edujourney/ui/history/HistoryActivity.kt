package com.dicoding.edujourney.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.edujourney.core.ui.ListCourseAdapter
import com.dicoding.edujourney.databinding.ActivityHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel: HistoryViewModel by viewModel()
    private lateinit var ownCourseAdapter: ListCourseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler()
        setupViewModel()
    }

    private fun setupRecycler() {
        ownCourseAdapter = ListCourseAdapter()
        with(binding.rvHistory) {
            this.setHasFixedSize(true)
            this.adapter = ownCourseAdapter
        }
    }

    private fun setupViewModel() {
        viewModel.history.observe(this, { history ->
            if (history != null) {
                ownCourseAdapter.setOwnedCourse(history)
            }
        })
    }
}