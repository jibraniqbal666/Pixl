package com.jibraniqbal.pixl

import android.content.Context
import android.graphics.Bitmap
import androidx.renderscript.Allocation
import androidx.renderscript.RenderScript
import com.example.android.basicrenderscript.ScriptC_brightness
import com.example.android.basicrenderscript.ScriptC_contrast
import com.example.android.basicrenderscript.ScriptC_saturation
import com.jibraniqbal.pixl.utils.Calc


class Pixl(context: Context?) {
    private val rs: RenderScript = RenderScript.create(context)
    private val mScript = ScriptC_brightness(rs)
    private val mScriptSaturation = ScriptC_saturation(rs)
    private val mScriptContrast = ScriptC_contrast(rs)


    fun setBrightness(mBitmapIn: Bitmap, mBitmapOut: Bitmap, bright: Float): Bitmap {
        // Allocate buffers
        val mInAllocation = Allocation.createFromBitmap(rs, mBitmapIn)
        val mOutAllocations = Allocation.createFromBitmap(rs, mBitmapOut)


        mScript._bright = Calc.normalize(bright, -1f, 1f)
        mScript.forEach_brightness(mInAllocation, mOutAllocations)
        mOutAllocations.copyTo(mBitmapOut)

        return mBitmapOut
    }

    fun setSaturation(mBitmapIn: Bitmap, mBitmapOut: Bitmap, saturation: Float) {
        // Allocate buffers
        val mInAllocation = Allocation.createFromBitmap(rs, mBitmapIn)
        val mOutAllocations = Allocation.createFromBitmap(rs, mBitmapOut)

        // Set global variable in RS
        mScriptSaturation._saturationValue = Calc.normalize(saturation, 0f, 2f)

        // Invoke saturation filter kernel
        mScriptSaturation.forEach_saturation(mInAllocation, mOutAllocations)

        mOutAllocations.copyTo(mBitmapOut)
    }

    fun setContrast(mBitmapIn: Bitmap, mBitmapOut: Bitmap, contrast: Float) {
        // Allocate buffers
        val mInAllocation = Allocation.createFromBitmap(rs, mBitmapIn)
        val mOutAllocations = Allocation.createFromBitmap(rs, mBitmapOut)

        // Set global variable in RS
        mScriptContrast._contrast = Calc.normalize(contrast, 0f, 2f)

        // Invoke saturation filter kernel
        mScriptContrast.forEach_contrastness(mInAllocation, mOutAllocations)

        mOutAllocations.copyTo(mBitmapOut)
    }
}