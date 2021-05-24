package com.dicoding.edujourney.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dicoding.edujourney.R

class DashboardFragment : Fragment() {
    private var _fragmentDashboardBinding: FragmentDashboardBinding? = null
    private val binding get() = _fragmentDashboardBinding!!

    private val dashboardViewModel: DashboardViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentDashboardBinding =
            FragmentDashboardBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            dashboardViewModel.text.observe(viewLifecycleOwner {
                binding.textDashboard.text = it
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentDashboardBinding = null
    }
}