package com.dicoding.edujourney.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.edujourney.core.ui.ListCourseAdapter
import com.dicoding.edujourney.databinding.FragmentDashboardBinding
import com.dicoding.edujourney.ui.detail.DetailCourseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {
    private var _fragmentDashboardBinding: FragmentDashboardBinding? = null
    private val binding get() = _fragmentDashboardBinding

    private val viewModel: DashboardViewModel by viewModel()
    private lateinit var ownCourseAdapter: ListCourseAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentDashboardBinding =
            FragmentDashboardBinding.inflate(layoutInflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            setupRecycler()
            setupViewModel()
        }
    }

    private fun setupRecycler() {
        ownCourseAdapter = ListCourseAdapter()
        ownCourseAdapter.onItemClick = {
            selectedData ->
            val intent = Intent(activity, DetailCourseActivity::class.java)
            intent.putExtra(DetailCourseActivity.EXTRA_COURSE,selectedData)
            startActivity(intent)
        }
        with(binding?.rvOwn){
            this?.setHasFixedSize(true)
            this?.adapter = ownCourseAdapter
        }
    }

    private fun setupViewModel() {
        viewModel.enrolled.observe(viewLifecycleOwner,{
            course ->
            if(course != null){
                ownCourseAdapter.setOwnedCourse(course)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentDashboardBinding = null
    }
}