package com.documentary.data.repos

import androidx.paging.PagingSource
import com.documentary.data.entities.repo.RepoEntity
import com.documentary.data.remote.GithubRemoteMediator

interface IGithubRepository {
    fun getPagingSourceFactory(query: String): PagingSource<Int, RepoEntity>
    fun getGithubRemoteMediator(query: String): GithubRemoteMediator
}