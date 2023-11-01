package com.tuan.baitap_recycleview.Home3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {


    lateinit var binding : FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root

    }


}