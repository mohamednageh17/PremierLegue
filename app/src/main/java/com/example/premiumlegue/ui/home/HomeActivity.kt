package com.example.premiumlegue.ui.home

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.premiumlegue.base.BaseActivity
import com.example.premiumlegue.databinding.ActivityMainBinding
import com.example.premiumlegue.ui.home.adapters.DayAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
    override val isEnableToolbar: Boolean
        get() = false

    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { DayAdapter(onItemClick = {}) }

    override fun setup() {
        initRV()
        observe()
    }

    private fun initRV() {
        ui.itemsRv.adapter = adapter
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.matches.collect { state ->
                    when (state) {
                        is HomeState.Loading -> ui.progressBar.isVisible = state.loading
                        is HomeState.Success -> adapter.addItems(state.data?.toMutableList() ?: mutableListOf())
                        is HomeState.Error -> showMessage(state.error.message ?: "Unknown error..")
                    }
                }
            }
        }
    }
}