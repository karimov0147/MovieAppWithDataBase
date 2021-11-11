package com.example.phones.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.phones.R
import com.example.phones.databinding.FragmentAndroid5Binding


class android_5_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_android_5_, container, false)
        var binding = FragmentAndroid5Binding.bind(view)

        binding.apply {
            appCompatButton2.setOnClickListener{
                findNavController().navigate(R.id.action_android_5_Fragment_to_android_8_Fragment)
            }
            appCompatButton.setOnClickListener{
                findNavController().navigate(R.id.action_android_5_Fragment_to_android_6_Fragment)
            }
        }


        return view
    }

}