package com.booknara.githubrepo.network

import javax.inject.Inject

class GithubRepository @Inject constructor(private val apiService: ApiService) {
    fun getAllRepository(query : String) = apiService.getAllRepo(query)
}
