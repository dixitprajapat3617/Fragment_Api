package com.app.tupplecompany.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.tupplecompany.databinding.ItemUiDesignBinding
import com.app.tupplecompany.model.UserData
import com.bumptech.glide.Glide

class UserDataAdapter(var context: Context,var userlist:MutableList<UserData>):RecyclerView.Adapter<UserDataAdapter.MyViewHolder>() {
    lateinit var binding: ItemUiDesignBinding
    class MyViewHolder(var binding: ItemUiDesignBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding= ItemUiDesignBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var name=userlist[position]
        holder.binding.tvCategory.text="${name.category}"
        holder.binding.tvMoviename.text="${name.name}"
        holder.binding.tvDesc.text="${name.desc}"
        var intent=Intent()
       var names= intent.getStringExtra("NAME")

        Glide
            .with(context)
            .load(name.imageUrl)
            .into(holder.binding.image)


    }

    override fun getItemCount(): Int {
       return userlist.size
    }

    fun setitem(userlist: MutableList<UserData>){
        this.userlist=userlist
        notifyDataSetChanged()
    }

}