package com.example.premiumlegue.utils

import android.content.Context
import android.graphics.Paint
import android.view.View
import android.widget.TextView
import com.example.premiumlegue.R
import java.text.SimpleDateFormat
import java.util.*
fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun TextView.setUnderLine() {
    this.paintFlags = this.paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

fun TextView.removeUnderLine() {
    paintFlags = 0
}

fun String.getDayOfWeek(context: Context, format: String): String {
    val date = SimpleDateFormat(format, Locale.getDefault()).parse(this)
    return date?.getDayOfWeek(context) ?: "unknown"
}

fun Date.getDayOfWeek(context: Context): String {
    val c = Calendar.getInstance().apply { time = this@getDayOfWeek }
    return context.resources.getStringArray(R.array.title_day_of_week)[c[Calendar.DAY_OF_WEEK] - 1]
}