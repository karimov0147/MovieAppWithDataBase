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
import com.example.phones.databinding.FragmentAndroid7Binding
import com.example.phones.models.Phone


class android_7_Fragment : Fragment() {


    lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_android_7_, container, false)
        var binding = FragmentAndroid7Binding.bind(view)
        var bundle = Bundle()

        var model  = arguments?.get("data").toString()


        binding.apply {
            appCompatButton.setOnClickListener{
                var name = this.editText2.text.toString().trim()
                var comment = this.editText.text.toString().trim()
                var one = true
                var two = true
                if (name.isEmpty()){
                    binding.editText2.error = "name shut be entered"
                    binding.editText2.requestFocus()
                    one = false
                    return@setOnClickListener
                }
                if (comment.isEmpty()){
                    binding.apply {
                        editText.error = "features shut be entetred"
                        editText.requestFocus()
                        two = false
                        return@setOnClickListener
                    }
                }
                if (one && two){
                    var phone = Phone(name,model.toString(),comment)
                    var dataBase = MyDBhelper(mContext)
                    dataBase.addPhone(phone)
                    binding.editText2.text.delete(0,name.length)
                    binding.editText.text.delete(0,comment.length)
                    activity?.onBackPressed()
                    Toast.makeText(mContext, "phone is added", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                    //findNavController().navigate(R.id.action_android_7_Fragment_to_android_5_Fragment)


                }
                else{
                    Toast.makeText(mContext, "name and comment shut be entered", Toast.LENGTH_SHORT).show()
                }
            }
        }



        return view
    }

}