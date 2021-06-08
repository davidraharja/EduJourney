package com.dicoding.edujourney.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.source.Resource
import com.dicoding.edujourney.core.ui.CourseAdapter
import com.dicoding.edujourney.core.ui.SkillAdapter
import com.dicoding.edujourney.databinding.FragmentHomeBinding
import com.dicoding.edujourney.ui.detail.DetailCourseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val binding get() = _fragmentHomeBinding
    private lateinit var adapterFree: CourseAdapter
    private lateinit var adapterPay: CourseAdapter
    private lateinit var adapterSoft: SkillAdapter
    private lateinit var adapterHard: SkillAdapter
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            setupRecycler()
            setupViewModel()
        }
    }

    private fun setupViewModel() {
        homeViewModel.course.observe(viewLifecycleOwner, { course ->
            if (course != null) {
                when (course) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        adapterFree.setCoursesFree(course.data)
                        adapterPay.setCoursesPaid(course.data)
                        adapterSoft.setSoftSkill(course.data)
                        adapterHard.setHardSkill(course.data)
                    }
                    is Resource.Error -> {

                    }
                }
            }
        })
    }

    private fun setupRecycler() {
        adapterFree = CourseAdapter()
        adapterPay = CourseAdapter()
        adapterSoft = SkillAdapter()
        adapterHard = SkillAdapter()
        adapterFree.onItemClick = {
                selectedData -> startIntent(selectedData)
        }
        adapterPay.onItemClick = {
                selectedData -> startIntent(selectedData)
        }
        adapterSoft.onItemClick = {
                selectedData -> startIntent(selectedData)
        }
        adapterHard.onItemClick = {
                selectedData -> startIntent(selectedData)
        }
        with(binding?.rvSoft) {
            this?.setHasFixedSize(true)
            this?.adapter = adapterSoft
        }
        with(binding?.rvHard) {
            this?.setHasFixedSize(true)
            this?.adapter = adapterHard
        }
        with(binding?.rvFree) {
            this?.setHasFixedSize(true)
            this?.adapter = adapterFree
        }
        with(binding?.rvPay) {
            this?.setHasFixedSize(true)
            this?.adapter = adapterPay
        }

    }
    private fun startIntent(selectedData: Course){
        val intent = Intent(activity, DetailCourseActivity::class.java)
        intent.putExtra(DetailCourseActivity.EXTRA_COURSE,selectedData)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentHomeBinding = null
    }
}