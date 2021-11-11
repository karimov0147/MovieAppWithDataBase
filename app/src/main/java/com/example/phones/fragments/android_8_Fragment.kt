package com.example.phones.fragments

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.phones.R
import com.example.phones.adapters.Grid_Adapter
import com.example.phones.adapters.Linear_adapter
import com.example.phones.databinding.FragmentAndroid8Binding
import com.example.phones.interfaces.OnClick
import com.example.phones.interfaces.OnCliclinear
import com.example.phones.interfaces.OnGridClick
import com.example.phones.utils.Constants
import com.example.phones.utils.List
import java.util.*

class android_8_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android_8_, container, false)
        var binding = FragmentAndroid8Binding.bind(view)
        var adapter = Grid_Adapter(List.PhoneList , object : OnGridClick {
            override fun onClic(item: String) {
                var bundle = Bundle()
                bundle.putString("model" , item)
                findNavController().navigate(R.id.action_android_8_Fragment_to_android_9_Fragment , bundle)
            }


        } )

        binding.RvGrid.adapter = adapter




        return view
    }


}