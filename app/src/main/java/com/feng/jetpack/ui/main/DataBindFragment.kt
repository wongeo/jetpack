package com.feng.jetpack.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feng.jetpack.databinding.FragmentDataBindBinding

class DataBindFragment : Fragment() {

    companion object {
        fun newInstance() = DataBindFragment()
    }

    private lateinit var viewModel: DataBindViewModel
    private lateinit var binding: FragmentDataBindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DataBindViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBindBinding.inflate(this.layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this//观察数据变化
        binding.button.setOnClickListener {
            viewModel.update()
        }
        return binding.root
    }
}