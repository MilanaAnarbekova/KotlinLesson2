package kg.geektech.kotlinlesson2.extension

import android.content.Context
import android.net.Uri
import android.util.Patterns
import android.webkit.ConsoleMessage

import android.webkit.URLUtil
import android.widget.Toast
import java.net.URL

fun Context.isValidUrlImage(url: String): Boolean {
    return Patterns.WEB_URL.matcher(url).matches()
}

fun Context.showToast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}