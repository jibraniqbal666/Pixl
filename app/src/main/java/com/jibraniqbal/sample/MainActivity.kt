package com.jibraniqbal.sample

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.jibraniqbal.pixl.Pixl

class MainActivity : AppCompatActivity() {
    lateinit var pixl : Pixl

    lateinit var originalBrightnessImage: Bitmap
    lateinit var originalContrastImage: Bitmap
    lateinit var originalSaturationImage: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pixl = Pixl(this)

        val brightnessSeek = findViewById<SeekBar>(R.id.brightnessSeek)
        val contrastSeek = findViewById<SeekBar>(R.id.contrastSeek)
        val saturationSeek = findViewById<SeekBar>(R.id.saturationSeek)


        val brightnessImage = findViewById<ImageView>(R.id.brightnessImage)
        val contrastImage = findViewById<ImageView>(R.id.contrastImage)
        val saturationImage = findViewById<ImageView>(R.id.saturationImage)

        originalBrightnessImage = (brightnessImage.drawable as BitmapDrawable).bitmap
        originalContrastImage = (contrastImage.drawable as BitmapDrawable).bitmap
        originalSaturationImage = (saturationImage.drawable as BitmapDrawable).bitmap

        brightnessSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val input = originalBrightnessImage
                val output = Bitmap.createBitmap(input.width, input.height, input.config)
                pixl.setBrightness(input, output, p0?.progress?.toFloat() ?: 0f)
                postImage(brightnessImage, output)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        contrastSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val input = originalContrastImage
                val output = Bitmap.createBitmap(input.width, input.height, input.config)
                pixl.setContrast(input, output, p0?.progress?.toFloat() ?: 0f)
                postImage(contrastImage, output)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        saturationSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val input = originalSaturationImage
                val output = Bitmap.createBitmap(input.width, input.height, input.config)
                pixl.setSaturation(input, output, p0?.progress?.toFloat() ?: 0f)
                postImage(saturationImage, output)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

    }

    private fun postImage(view: ImageView, bitmap: Bitmap){
        runOnUiThread {
            view.setImageBitmap(bitmap)
        }
    }
}