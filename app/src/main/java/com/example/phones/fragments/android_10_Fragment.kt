package com.example.phones.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phones.R
import com.example.phones.databinding.FragmentAndroid10Binding
import com.example.phones.models.Phone


class android_10_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android_10_, container, false)
        var binding = FragmentAndroid10Binding.bind(view)
        var phone = arguments?.getSerializable("phone") as Phone
        binding.infoView.text = phone.comment
        binding.name.text = phone.name
        return view
    }

}