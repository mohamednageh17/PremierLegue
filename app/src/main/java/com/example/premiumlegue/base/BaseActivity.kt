package com.example.premiumlegue.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.example.premiumlegue.R

abstract class BaseActivity<T : ViewBinding>:AppCompatActivity() {
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> T
    internal var toolbar: Toolbar? = null
    protected abstract val isEnableToolbar: Boolean

    @Suppress("UNCHECKED_CAST")
    protected val ui: T
        get() = _binding as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        if (isEnableToolbar) {
            configureToolbar()
        }
        intent
        setup()
    }

    protected fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    abstract fun setup()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun setToolbarTitle(title: String) {
        toolbar?.let {
            it.title = title
            setSupportActionBar(it)
        }
    }

    private fun configureToolbar() {
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar?
        toolbar?.title = ""
        setSupportActionBar(toolbar)
    }
}