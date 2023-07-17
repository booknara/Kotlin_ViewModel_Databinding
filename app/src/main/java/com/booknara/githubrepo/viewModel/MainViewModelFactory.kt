package com.booknara.githubrepo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.booknara.githubrepo.data.GithubRepository

class MainViewModelFactory : ViewModelProvider.Factory {
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            repository = GithubRepository()
        ) as T
    throw IllegalArgumentException("Unknown ViewModel class")
    }
}
