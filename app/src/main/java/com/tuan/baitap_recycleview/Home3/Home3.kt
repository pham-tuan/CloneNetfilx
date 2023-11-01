package com.tuan.baitap_recycleview.Home3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.ActivityHome3Binding


class Home3 : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityHome3Binding
    private var  fragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityHome3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)

        fragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment as HomeFragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.home -> {
                fragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment as HomeFragment).commit()
            }

            R.id.seach ->{
                fragment = TopSeachFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment as TopSeachFragment).commit()
            }

            R.id.comming ->{
                fragment = CommingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment as CommingFragment).commit()
            }
            R.id.down ->{
                fragment = DownLoadFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment as DownLoadFragment).commit()
            }
            R.id.menu ->{
                fragment = MenuFragment()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment as MenuFragment).commit()
            }

        }
        return true
    }


}