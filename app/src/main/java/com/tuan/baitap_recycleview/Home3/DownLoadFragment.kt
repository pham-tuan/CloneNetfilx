package com.tuan.baitap_recycleview.Home3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.FragmentDownLoadBinding

class DownLoadFragment : Fragment() {


    lateinit var binding : FragmentDownLoadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDownLoadBinding.inflate(layoutInflater)


        return binding.root

    }


}