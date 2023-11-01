package com.tuan.baitap_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.view.WindowManager
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuan.baitap_recycleview.Home3.TopFilmAdapter
import com.tuan.baitap_recycleview.Home3.Top_Film
import com.tuan.baitap_recycleview.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var listFilm: List<Top_Film>? = null
    private var filmAdapter: TopFilmAdapter? = null
    private var textmic : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding?.root)

        handleDataFilm()
        setonclick()

    }

    private fun setonclick() {
        textmic = TextToSpeech(applicationContext){
            status -> if (status!= TextToSpeech.ERROR){
            textmic?.setLanguage(Locale.UK)
            //Locale.forLanguageTag("vi-VN")
        }
        }

        binding.tvmic.setOnClickListener(View.OnClickListener {
            val toSpeak : String = binding.edtseach.getText().toString()
            binding.edtseach.setText(toSpeak)
            textmic?.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null)
        })

    }

    private fun handleDataFilm() {
        listFilm = listOf(
            Top_Film(R.drawable.rectanglemot, "Citation"),
            Top_Film(R.drawable.rectanglehai, "Oloture"),
            Top_Film(R.drawable.rectanglebon, "The Setup"),
            Top_Film(R.drawable.rectanglenam, "Breaking Bad"),
            Top_Film(R.drawable.rectanglesau, "Ozark"),
            Top_Film(R.drawable.rectanglebay, "The Governor"),
            Top_Film(R.drawable.rectanglesau, "Ozark"),
            Top_Film(R.drawable.rectanglebon, "The Setup"),
        )


        binding.rcFilm.apply {
            var layoutParams =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            layoutManager = layoutParams
            filmAdapter = TopFilmAdapter()
            filmAdapter?.setupData(listFilm ?: listOf())
            adapter = filmAdapter


            binding.edtseach.doOnTextChanged { text, start, before, count ->
                filmAdapter?.filter?.filter(text.toString())
            }

        }

    }

}