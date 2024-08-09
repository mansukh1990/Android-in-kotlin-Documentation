package com.example.androidwithkotlin.VideoView

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityVideoViewBinding

class VideoView : AppCompatActivity() {

    private lateinit var binding: ActivityVideoViewBinding

    var videoView: VideoView? = null
    var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityVideoViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupVideoView()
    }

    private fun setupVideoView() {
        if (mediaController == null) {
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this@VideoView.binding.videoView)
        }
        binding.videoView.setMediaController(mediaController)
        val path = "android.resource://" + packageName + "/" + R.raw.sample_video
        binding.videoView.setVideoURI(Uri.parse(path))
        binding.videoView.requestFocus()

        binding.btnPlay.setOnClickListener {
            val isPlaying = binding.videoView.isPlaying
            binding.btnPlay.setText(if (isPlaying) R.string.play else R.string.pause)

            val msg = getString(if (isPlaying) R.string.paused else R.string.playing)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

            if (isPlaying) {
                binding.videoView.pause()
            } else {
                binding.videoView.start()
            }
        }
        binding.videoView.setOnCompletionListener {
            binding.btnPlay.text = getString(R.string.play)

        }
    }
}