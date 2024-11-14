package com.example.androidwithkotlin.AndroidWithKotlin.TextureView

import android.Manifest.permission.CAMERA
import android.content.pm.PackageManager
import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.TextureView
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivityTextureViewBinding
import java.io.IOException

@Suppress("DEPRECATION")
class TextureView : AppCompatActivity(), TextureView.SurfaceTextureListener {

    private var mTextureView: TextureView? = null
    private var mCamera: Camera? = null

    private lateinit var binding: ActivityTextureViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextureViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val result = checkPermision()
        if (result) {
            setupTextureView()
        }

    }

    private fun setupTextureView() {
        mTextureView = TextureView(this)
        mTextureView!!.surfaceTextureListener = this
        setContentView(mTextureView)

    }

    private fun setMessageView() {
        setContentView(R.layout.activity_texture_view)
        binding.info.setText(R.string.permission_required)
    }

    private fun checkPermision(): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, CAMERA) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, CAMERA)) {
                    showPermissionAlert()
                } else {
                    ActivityCompat.requestPermissions(this, arrayOf(CAMERA), CAMERA_REQUEST_CODE)
                }
                return false
            } else {
                return true
            }
        } else {
            return true
        }
    }

    private fun showPermissionAlert() {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setCancelable(true)
        alertBuilder.setTitle("Permission Required")
        alertBuilder.setMessage("Permission to access camera is needed to run this application")
        alertBuilder.setPositiveButton(android.R.string.yes) { _, _ ->
            ActivityCompat.requestPermissions(
                this,
                arrayOf(CAMERA), CAMERA_REQUEST_CODE
            )
        }
        val alert = alertBuilder.create()
        alert.show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupTextureView()

            } else if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                setMessageView()

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {

        val CAMERA_REQUEST_CODE = 100
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        mCamera = Camera.open()

        val previewSize = mCamera!!.parameters.previewSize
        mTextureView!!.layoutParams =
            FrameLayout.LayoutParams(
                previewSize.width, previewSize.height, Gravity.CENTER
            )

        try {
            mCamera!!.setPreviewTexture(surface)
            mCamera!!.startPreview()

        } catch (ioe: IOException) {
            ioe.message.toString()
        }
        mTextureView!!.alpha = 1.0f
        mTextureView!!.rotation = 90.0f
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {

    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        mCamera!!.stopPreview()
        mCamera!!.release()
        return true
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {

    }

}