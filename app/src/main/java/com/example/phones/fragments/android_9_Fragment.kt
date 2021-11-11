package com.example.phones.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.phones.DBhelper.MyDBhelper
import com.example.phones.R
import com.example.phones.adapters.Linear_adapter
import com.example.phones.adapters.adapterForObjects
import com.example.phones.databinding.FragmentAndroid9Binding
import com.example.phones.interfaces.OnClick
import com.example.phones.interfaces.OnCliclinear
import com.example.phones.models.Phone

class android_9_Fragment : Fragment() {

    lateinit var mContext : Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android_9_, container, false)
        var binding = FragmentAndroid9Binding.bind(view)
        var model = arguments?.get("model")
        var modelList = ArrayList<Phone>()
        var database = MyDBhelper(mContext)
        var phoneList = database.getPhonesByModel()


        phoneList.forEach{
            if (it.model == model){
                modelList.add(it)
            }
        }

        var adapter = adapterForObjects(modelList , object : OnClick {
            override fun OnItemClick(phone: Phone) {
                var bundle = Bundle()
                bundle.putSerializable("phone" , phone)
                findNavController().navigate(R.id.action_android_9_Fragment_to_android_10_Fragment , bundle)           }

        })

        binding.phonesRv.adapter = adapter







        return view
    }


}