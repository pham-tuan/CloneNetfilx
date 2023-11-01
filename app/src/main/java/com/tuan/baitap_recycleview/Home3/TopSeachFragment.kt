package com.tuan.baitap_recycleview.Home3

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.tuan.baitap_recycleview.PlayVideo
import com.tuan.baitap_recycleview.R
import com.tuan.baitap_recycleview.databinding.ActivityPlayVideoBinding
import com.tuan.baitap_recycleview.databinding.FragmentTopSeachBinding


class TopSeachFragment : Fragment() {


    lateinit var binding: FragmentTopSeachBinding
    private var listFilm: List<Top_Film>? = null
    private var filmAdapter: TopFilmAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopSeachBinding.inflate(layoutInflater)
        handleDataFilm()

        return binding.root
    }


    private fun handleDataFilm() {
        listFilm = listOf(
            Top_Film(R.drawable.rectanglemot, "Citation", R.raw.daydiongchauoi),
            Top_Film(R.drawable.rectanglehai, "Oloture", R.raw.daydiongchauoi),
            Top_Film(R.drawable.rectanglebon, "The Setup"),
            Top_Film(R.drawable.rectanglenam, "Breaking Bad"),
            Top_Film(R.drawable.rectanglesau, "Ozark"),
            Top_Film(R.drawable.rectanglebay, "The Governor"),
            Top_Film(R.drawable.rectanglesau, "Ozark"),
            Top_Film(R.drawable.rectanglebon, "The Setup"),
        )


        binding.rcFilm.apply {
            var layoutParams =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            layoutManager = layoutParams
            filmAdapter = TopFilmAdapter()
            filmAdapter?.setupData(listFilm ?: listOf())
            adapter = filmAdapter

            binding.edtseach.doOnTextChanged { text, start, before, count ->
                filmAdapter?.filter?.filter(text.toString())
            }

        }

        filmAdapter?.onClickItem = {
            // Toast.makeText(requireContext(), it.filmName,Toast.LENGTH_SHORT).show()
           // Snackbar.make(binding.root, it.filmName, 1000).show()
           // Log.d("tuan ",it.filmName)
            // Log.d(TAG,"${it.filmName}")
            var intent = Intent(requireActivity(),PlayVideo::class.java)
            intent.putExtra("key", it )
            startActivity(intent)
        }


    }


}
