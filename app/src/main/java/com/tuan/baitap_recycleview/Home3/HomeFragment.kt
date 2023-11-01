package com.tuan.baitap_recycleview.Home3

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private var mHome: List<mHome>? = null
    private var mHomeAdapter: mHome_Adapter? = null
    private var dialog : AlertDialog? = null

    private var listPreviewsBanner: List<Banner>? = null
    private var listPopularBanner: List<Banner>? = null
    private var listTrendingBanner: List<Banner>? = null
    private var listMyListBanner: List<Banner>? = null
    private var listAfricanBanner: List<Banner>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        handleDataFilm()

        return binding.root
    }

    private fun handleDataFilm() {
        listPreviewsBanner = listOf(
            Banner(R.drawable.ellipsemot),
            Banner(R.drawable.ellipsehai),
            Banner(R.drawable.ellipseba),
            Banner(R.drawable.ellipsebon),
            Banner(R.drawable.ellipsehai)
        )
        listPopularBanner = listOf(
            Banner(R.drawable.hinhnam),
            Banner(R.drawable.hinhsau),
            Banner(R.drawable.hinhbay),
            Banner(R.drawable.hinhtam),
            Banner(R.drawable.hinhbay)
        )
        listTrendingBanner = listOf(
            Banner(R.drawable.hinhchin),
            Banner(R.drawable.hinhmuoi),
            Banner(R.drawable.hinhmuoimot),
            Banner(R.drawable.hinhmuoihai),
            Banner(R.drawable.hinhmuoi)
        )
        listMyListBanner = listOf(
            Banner(R.drawable.hinhmot),
            Banner(R.drawable.hinhhai),
            Banner(R.drawable.hinhba),
            Banner(R.drawable.hinhbon),
            Banner(R.drawable.hinhmot)
        )
        listAfricanBanner = listOf(
            Banner(R.drawable.hinhnam),
            Banner(R.drawable.hinhsau),
            Banner(R.drawable.hinhbay),
            Banner(R.drawable.hinhtam),
            Banner(R.drawable.hinhsau)
        )

        mHome = listOf(
            mHome("Previews", listPreviewsBanner ?: listOf()),
            mHome("Popular", listPopularBanner ?: listOf()),
            mHome("Trending", listTrendingBanner ?: listOf()),
            mHome("My list", listMyListBanner ?: listOf()),
            mHome("African Movies", listAfricanBanner ?: listOf()),

            )

        binding.rcFilmHome.apply {
            layoutManager = GridLayoutManager(activity, 1)
            mHomeAdapter = mHome_Adapter(mHome ?: listOf())
            adapter = mHomeAdapter
        }

        binding.play.setOnClickListener {
            var alertDialogBuilder = AlertDialog.Builder(activity,R.style.Themecustom)

//            dialog.apply {
//                setTitle("Error!!!")
//                setMessage("t có đẹp trai không??")
//                setCancelable(false)  // khi click ra ngoài có cho phép tắt hay không .false : không tắt
//                setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
//                setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
//                    Toast.makeText(context, "ố kề ", Toast.LENGTH_SHORT).show()
//                    dialogInterface.dismiss()  // đóng
//                }
//            }


            var view = layoutInflater.inflate(R.layout.custom_dialog, null)

            alertDialogBuilder.setView(view)

            var btnClose = view.findViewById<ImageView>(R.id.imgClose)
            //var btnShip = view.findViewById<TextView>(R.id.skip)
            btnClose.setOnClickListener{
                dialog?.dismiss()
            }

            dialog= alertDialogBuilder.create()
            dialog?.show()

        }


    }

}