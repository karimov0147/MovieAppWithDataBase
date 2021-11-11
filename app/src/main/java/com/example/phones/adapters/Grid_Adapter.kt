package com.example.phones.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phones.R
import com.example.phones.databinding.GridItemBinding
import com.example.phones.interfaces.OnGridClick

class Grid_Adapter(var list : Array<String> ,var onclick : OnGridClick  ): RecyclerView.Adapter<Grid_Adapter.ViewHolder>(){

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var binding =  GridItemBinding.bind(view)
        fun onBind(model: String) {
            binding.modelType.text = model
            binding.root.setOnClickListener{
                onclick.onClic(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}