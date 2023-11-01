package com.tuan.baitap_recycleview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.tuan.baitap_recycleview.Home3.Top_Film
import com.tuan.baitap_recycleview.databinding.ActivityPlayVideoBinding

@Suppress("DEPRECATION")
class PlayVideo : AppCompatActivity() {

    lateinit var binding: ActivityPlayVideoBinding
    private var film: Top_Film? = null
    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityPlayVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    private fun initView() {
        film = intent.getSerializableExtra("key") as? Top_Film
        playVideo(film?.fileFilm)
    }

    private fun playVideo(fileFilm: Int?) {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer?.playWhenReady = true
        binding.playerView.player = exoPlayer
        val mediaItem = MediaItem.fromUri(Uri.parse("android.resource://$packageName/" + fileFilm))
        exoPlayer?.apply {
            addMediaItem(mediaItem)
            seekTo(playbackPosition)
            playWhenReady = playWhenReady
            prepare() //chuan bi
        }
    }

    private fun releasePlayer(){
        exoPlayer?.let { player ->
            playbackPosition = player.currentPosition
            playWhenReady = player.playWhenReady
            player.release()
            exoPlayer = null
        }
    }


}
