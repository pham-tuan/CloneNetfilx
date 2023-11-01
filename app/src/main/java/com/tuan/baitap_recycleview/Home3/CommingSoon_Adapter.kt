package com.tuan.baitap_recycleview.Home3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuan.baitap_recycleview.databinding.ItemCommingBinding


class CommingSoon_Adapter(private val list: List<CommingSoon>) :
    RecyclerView.Adapter<CommingSoon_Adapter.CommingViewHolder>() {

    inner class CommingViewHolder(private val binding: ItemCommingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comming: CommingSoon) {

            binding.cmtitle.text = comming.title

            binding.cmcontent.text = comming.content

            binding.cmimg.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.cmimg.context,
                    comming.img
                )
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommingViewHolder {
        return CommingViewHolder(
            ItemCommingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CommingViewHolder, position: Int) {
        holder.bind(list[position])
    }
}