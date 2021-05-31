package com.dicoding.edujourney.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dicoding.edujourney.R
import com.dicoding.edujourney.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _fragmentSearchBinding: FragmentHomeBinding? = null
    private val binding get() = _fragmentSearchBinding!!
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentSearchBinding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            homeViewModel.text.observe(viewLifecycleOwner, Observer {
                binding.tvSoftSkills.text = it
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentSearchBinding = null
    }
}