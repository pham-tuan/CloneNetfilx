package com.tuan.baitap_recycleview.Home3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuan.baitap_recycleview.databinding.TitleFilmBinding

class mHome_Adapter(private val list: List<mHome>) :
    RecyclerView.Adapter<mHome_Adapter.mHomeViewHolder>() {

    inner class mHomeViewHolder(private val binding: TitleFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mhome: mHome) {
            binding.title.text = mhome.title

            binding.banner.layoutManager = LinearLayoutManager(
                binding.root.context,
                LinearLayoutManager.HORIZONTAL, false
            )

            binding.banner.adapter = BannerAdapter(mhome.banner)

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): mHomeViewHolder = mHomeViewHolder(
        TitleFilmBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: mHomeViewHolder, position: Int) =
        holder.bind(list[position])

}