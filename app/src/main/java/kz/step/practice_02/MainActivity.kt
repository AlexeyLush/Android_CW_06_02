package kz.step.practice_02

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Camera
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File

import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var btnCapture: Button? = null
    var imageViewCamera: ImageView? = null
    lateinit var currentPhotoPath: String
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews(){
        btnCapture = findViewById(R.id.btn_capture)
        imageViewCamera = findViewById(R.id.imageview_camera)

    }

    fun initializeListeners(){
        btnCapture?.setOnClickListener{


            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            val imageBitmap = takePictureIntent.extras?.get("data") as Bitmap
            imageViewCamera?.setImageBitmap(imageBitmap)


        }
    }

}