package com.booknara.githubrepo.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booknara.githubrepo.data.model.MyData
import com.booknara.githubrepo.databinding.RecyclerLayoutBinding

class DataAdapter: RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    var items = ArrayList<MyData>()

    fun setData(data : ArrayList<MyData>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  RecyclerLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(val binding: RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data: MyData){

            binding.gitHubData = data
            binding.executePendingBindings()
        }

    }

}
