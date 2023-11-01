package com.tuan.baitap_recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import com.tuan.baitap_recycleview.Home3.Home3
import com.tuan.baitap_recycleview.Home3.HomeFragment
import com.tuan.baitap_recycleview.databinding.ActivityHome2Binding
import com.tuan.baitap_recycleview.databinding.FragmentTopSeachBinding

class Home2 : AppCompatActivity() {
    lateinit var binding: ActivityHome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClicck()
    }

    private fun setOnClicck() {
        binding.mot.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                startService(intent)
            },50)
        }

        binding.ba.setOnClickListener{
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, Home3::class.java))
                startService(intent)
            },50)
        }
    }
}