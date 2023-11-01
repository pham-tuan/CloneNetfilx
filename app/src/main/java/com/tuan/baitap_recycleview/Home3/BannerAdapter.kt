package com.tuan.baitap_recycleview.Home3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tuan.baitap_recycleview.databinding.ItemBannerBinding

class BannerAdapter (private val list: List<Banner>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    inner class BannerViewHolder(val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(banner: Banner) {
            binding.ivFilm.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.ivFilm.context,
                    banner.image
                )
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
