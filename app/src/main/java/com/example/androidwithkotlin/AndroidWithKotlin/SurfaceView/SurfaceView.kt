package com.example.androidwithkotlin.AndroidWithKotlin.SurfaceView

import android.Manifest.permission.CAMERA
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.SurfaceHolder
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidwithkotlin.R
import com.example.androidwithkotlin.databinding.ActivitySurfaceViewBinding
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

@Suppress("DEPRECATION")
class SurfaceView : AppCompatActivity(), SurfaceHolder.Callback, Camera.PictureCallback {

    private lateinit var binding: ActivitySurfaceViewBinding

    private var surfaceHolder: SurfaceHolder? = null
    private var camera: Camera? = null

    private val neededPermissions = arrayOf(CAMERA, WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurfaceViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val result = checkPermission()
        if (result) {
            setupSurfaceHolder()
        }
    }

    private fun setupSurfaceHolder() {
        binding.startBtn.visibility = View.VISIBLE
        binding.surfaceView.visibility = View.VISIBLE

        surfaceHolder = binding.surfaceView.holder
        binding.surfaceView.holder.addCallback(this)
        setBtnClick()
    }

    private fun setBtnClick() {
        binding.startBtn.setOnClickListener {
            captureImage()
        }
    }

    private fun captureImage() {
        if (camera != null) {
            camera!!.takePicture(null, null, this)
        }
    }

    private fun checkPermission(): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            val permissionNotGrated = ArrayList<String>()
            for (permission in neededPermissions) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    permissionNotGrated.add(permission)
                }
            }
            if (permissionNotGrated.size > 0) {
                var shoulShowAlert = false
                for (permission in permissionNotGrated) {
                    shoulShowAlert =
                        ActivityCompat.shouldShowRequestPermissionRationale(this, permission)
                }
                var arr = arrayOfNulls<String>(permissionNotGrated.size)
                val permissions = permissionNotGrated.toArray(arr)
                if (shoulShowAlert) {
                    showPermissionAlert(permissions)
                } else {
                    requestsPermissions(permissions)
                }
                return false

            }
        }
        return true

    }

    private fun showPermissionAlert(permissions: Array<String?>) {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setCancelable(true)
        alertBuilder.setTitle(R.string.permission_required)
        alertBuilder.setMessage(R.string.permission_message)
        alertBuilder.setPositiveButton(android.R.string.yes) { _, _ ->
            requestsPermissions(
                permissions
            )
        }
        val alert = alertBuilder.create()
        alert.show()
    }

    private fun requestsPermissions(permissions: Array<String?>) {
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE -> {
                for (result in grantResults) {
                    if (result == PackageManager.PERMISSION_DENIED) {
                        Toast.makeText(this, R.string.permission_warning, Toast.LENGTH_SHORT).show()
                        binding.showPermissionMsg.visibility = View.VISIBLE
                        return
                    }
                }
                setupSurfaceHolder()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {
        const val REQUEST_CODE = 100
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        startCamera()
    }

    private fun startCamera() {
        camera = Camera.open()
        camera!!.setDisplayOrientation(90)
        try {
            camera!!.setPreviewDisplay(surfaceHolder)
            camera!!.startPreview()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        resetCamera()
    }

    private fun resetCamera() {
        if (surfaceHolder!!.surface == null) {
            return
        }
        camera!!.stopPreview()
        try {
            camera!!.setPreviewDisplay(surfaceHolder)

        } catch (e: IOException) {
            e.printStackTrace()
        }
        camera!!.startPreview()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        releaseCamera()
    }

    private fun releaseCamera() {
        camera!!.stopPreview()
        camera!!.release()
        camera = null
    }

    @Deprecated("Deprecated in Java")
    override fun onPictureTaken(bytes: ByteArray, camera: Camera) {
        saveImages(bytes)
        resetCamera()

    }

    private fun saveImages(bytes: ByteArray) {
        val outStream: FileOutputStream
        try {
            val fileName = "MANSUKHTUTORIAL_" + System.currentTimeMillis() + ".jpg"
            val file = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                fileName
            )
            outStream = FileOutputStream(file)
            outStream.write(bytes)
            outStream.close()
            Toast.makeText(this, "Pictured Saved : $fileName", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}