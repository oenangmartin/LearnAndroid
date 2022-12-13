package com.indodana.learnandroid.helper

import java.text.SimpleDateFormat
import java.util.*

interface Helper {
    fun getSomeString(): String

    fun getCurrentTime(): String
}

class HelperImpl : Helper {
    override fun getSomeString(): String {
        TODO("Not yet implemented")
    }

    override fun getCurrentTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return formatter.format(time)
    }
}