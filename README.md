[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Generic badge](https://img.shields.io/badge/Version-0.0.1-brightgreen.svg)](https://shields.io/)

# Pixl

Pixl is a library for image manipulation with power of renderScript which is faster than other ordinary solutions, currently it includes three basic scripts, brightness, contrast, saturation.

## Screenshots

<img src="https://user-images.githubusercontent.com/30576574/82128746-d4f76500-97d6-11ea-98f8-6f558d5c5a08.png" width=300  />

## Installation

Add Jitpack to your project build.gradle file
      
      allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
			jcenter()
		}
	}
}

Then add this dependency to your app build.gradle file.

      dependencies {
	        implementation 'com.jibraniqbal.pixl:pixl:0.0.1'
	}

## Usage
      
You can see the example with brightness, contrast, saturation with seekbar, given the value 0-100%
   
   Add support for API-19 add this to you build.gradle
   
	android {
		defaultConfig {
			...
			renderscriptTargetApi 19
        		renderscriptSupportModeEnabled true
		}
	}
   Intialization
   
	  val pixl = Pixl(context)
        
   Brightness
   
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

   
   Contrast
   
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

   Saturation
   
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

## License

Copyright 2020 Jibran Iqbal 

   Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

