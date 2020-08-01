package com.example.navigationcomponentplayground.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentplayground.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            /*val bundle = Bundle().apply {
                putSerializable("yourSerializableClass", yourSerializableClass)
            }*/
            findNavController().navigate(
                R.id.action_firstFragment_to_forthFragment /*,
                bundle*/
            )
        }

    }
}