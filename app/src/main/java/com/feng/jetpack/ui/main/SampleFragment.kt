package com.feng.jetpack.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.feng.jetpack.R

/**
 * 简单的mvvm绑定数据
 */
class SampleFragment : Fragment() {

    companion object {
        fun newInstance() = SampleFragment()
    }

    private lateinit var viewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SampleViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sample, container, false)
        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            viewModel.update()
        }
        val textView:TextView = view.findViewById<TextView?>(R.id.textView).apply {
            text = viewModel.user.value?.age.toString()
        }

        viewModel.user.observe(viewLifecycleOwner) {
            textView.text = it.age.toString()
        }
        return view
    }
}