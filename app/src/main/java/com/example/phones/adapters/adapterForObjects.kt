package com.example.phones.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phones.R
import com.example.phones.databinding.GridItemBinding
import com.example.phones.databinding.LinearItemBinding
import com.example.phones.interfaces.OnClick
import com.example.phones.models.Phone

class adapterForObjects(var list :ArrayList<Phone> ,var onClick : OnClick ): RecyclerView.Adapter<adapterForObjects.ViewHolder>() {
     inner class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
          var binding = LinearItemBinding.bind(view)

          fun onBind(phone: Phone) {
              binding.textView.text = phone.name
               binding.root.setOnClickListener {
                    onClick.OnItemClick(phone)
               }
          }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          var view = LayoutInflater.from(parent.context).inflate(R.layout.linear_item , parent , false)
          return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.onBind(list[position])
     }

     override fun getItemCount(): Int {
          return list.size
     }
}