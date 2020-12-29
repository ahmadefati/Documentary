package com.documentary.data.services

import com.documentary.data.responses.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val IN_QUALIFIER = "in:name,description"

interface RepoService {
    @GET//("search/repositories?sort=stars")
    suspend fun searchRepos(
        @Url url: String,
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse
}