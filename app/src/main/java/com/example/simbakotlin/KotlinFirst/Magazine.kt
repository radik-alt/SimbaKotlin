package com.example.simbakotlin.KotlinFirst

import android.util.Log

class Magazine(override var price: Int, override var wordCount: Int) : Publication {

    override fun getType(): String {
        return "Magazine"
    }

}