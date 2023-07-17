package com.booknara.githubrepo.network

import com.booknara.githubrepo.data.model.GithubResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {
    @GET("search/repositories")
    fun getAllRepo(@Query("q") q : String) : Call<GithubResponseModel>
}
