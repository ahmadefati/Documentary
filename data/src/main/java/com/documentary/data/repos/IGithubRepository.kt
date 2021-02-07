package com.documentary.data.repos

import androidx.paging.PagingSource
import com.documentary.data.entities.Repo
import com.documentary.data.remote.GithubRemoteMediator

interface IGithubRepository {
    fun getPagingSourceFactory(query: String): PagingSource<Int, Repo>
    fun getGithubRemoteMediator(query: String): GithubRemoteMediator
}