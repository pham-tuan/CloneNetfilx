package com.tuan.baitap_recycleview.Home3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.FragmentCommingBinding


class CommingFragment : Fragment() {

    lateinit var binding: FragmentCommingBinding
    private var list : List<CommingSoon>? = null
    private var commingadapter : CommingSoon_Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommingBinding.inflate(layoutInflater)
        handler()
        return binding.root

    }

    private fun handler() {

        list = listOf(
            CommingSoon("Castle & Castle" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sit quam dui, vivamus\n" +
                    "bibendum ut. A morbi mi tortor ut felis non accumsan accumsan quis. Massa,\n" +
                    " id ut ipsum aliquam  enim non posuere pulvinar diam." , R.drawable.rectanglehaihai),

            CommingSoon("Tiny Pretty Things" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sit quam dui, vivamus\n" +
                    "bibendum ut. A morbi mi tortor ut felis non accumsan accumsan quis. Massa,\n" +
                    " id ut ipsum aliquam  enim non posuere pulvinar diam." , R.drawable.rectanglehaiba),

            CommingSoon("Tuan Dep Trai" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sit quam dui, vivamus\n" +
                    "bibendum ut. A morbi mi tortor ut felis non accumsan accumsan quis. Massa,\n" +
                    " id ut ipsum aliquam  enim non posuere pulvinar diam." , R.drawable.rectanglehaitu)
        )

        binding.rvcomming.apply {
            var layoutParams =  LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            layoutManager = layoutParams
            commingadapter = CommingSoon_Adapter(list?: listOf())
            adapter = commingadapter
        }
    }


}
