package com.booknara.githubrepo.data

import java.lang.Exception

sealed class BaseResponse<out T> {
    data class Success<out T>(val data: T) : BaseResponse<T>()
    data class Loading(val nothing: Nothing? = null) : BaseResponse<Nothing>()
    data class Error(val exception: Exception? = null) : BaseResponse<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success -> "Success: ${this.data}"
            is Loading -> "Loading"
            is Error -> "Error ${this.exception?.message}"
        }
    }
}
