package com.dicoding.edujourney.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.edujourney.core.source.Resource
import com.dicoding.edujourney.core.ui.CourseAdapter
import com.dicoding.edujourney.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _fragmentSearchBinding: FragmentHomeBinding? = null
    private val binding get() = _fragmentSearchBinding
    private lateinit var adapter: CourseAdapter
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentSearchBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
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

                    }
                    is Resource.Error -> {

                    }
                }
            }
        })
    }

    private fun setupRecycler() {
        adapter = CourseAdapter()


    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentSearchBinding = null
    }
}