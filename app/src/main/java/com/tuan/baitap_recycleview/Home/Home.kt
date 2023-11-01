package com.tuan.baitap_recycleview.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.tuan.baitap_recycleview.Home2
import com.tuan.baitap_recycleview.MainActivity
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.ActivityHomeBinding
import com.tuan.baitap_recycleview.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        Glide.with(this).load(R.drawable.logonetflix).into(binding.imglogo);

        Handler(Looper.getMainLooper()).postDelayed({
        startActivity(Intent(this,Home2::class.java))
            startService(intent)
        },6700)


    }

}