package com.documentary.base.data.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MainActivityViewModel @ViewModelInject constructor() : ViewModel() {
    var isLoginFragment = false;
}