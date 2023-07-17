package com.booknara.githubrepo.data

import com.booknara.githubrepo.network.ApiEndPoint
import com.booknara.githubrepo.network.RetrofitClient

class GithubRepository {
    private val retrofit = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)

    fun getAllRepository(query : String) = retrofit.getAllRepo(query)
}
