package com.documentary.repo_feature.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.documentary.domain.observers.GithubObserver
import com.documentary.domain.repo.Repo
import com.documentary.home_feature.toRepoView
import com.documentary.view.BaseViewModel
import com.documentary.view.ObservableLoadingCounter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DashboardViewModel @ViewModelInject constructor(
    private val pagingInteractor: GithubObserver
) : BaseViewModel<RepoViewState>(RepoViewState()) {
    private val loadingState = ObservableLoadingCounter()
    private val pagingConfig = PagingConfig(pageSize = 50, enablePlaceholders = false)

    val pagedList: Flow<PagingData<Repo>>
        get() = pagingInteractor.observe()

    private var currentQueryValue: String? = null


    fun testsearch(query: String) {
        viewModelScope.launch {
            searchRepo(query)
                .onStart {
                    loadingState.addLoader()
                }.onEach {
                    loadingState.removeLoader()
                }.collectAndSetState {
                    copy(pagingDataUiModel = it)
                }
        }

        viewModelScope.launch {
            loadingState.observable.collectAndSetState { copy(refreshing = it) }
        }

    }

    private var currentSearchResult: Flow<PagingData<UiModel>>? = null
    fun searchRepo(queryString: String): Flow<PagingData<UiModel>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        currentQueryValue = queryString
        updateDataSource(queryString)
        val newResult: Flow<PagingData<UiModel>> =
            pagedList
                .map { pagingData -> pagingData.map { UiModel.RepoItem(it.toRepoView()) } }
                .map {
                    it.insertSeparators<UiModel.RepoItem, UiModel> { before, after ->
                        if (after == null) {
                            // we're at the end of the list
                            return@insertSeparators null
                        }

                        if (before == null) {
                            // we're at the beginning of the list
                            return@insertSeparators UiModel.SeparatorItem("${after.roundedStarCount}0.000+ stars")
                        }
                        // check between 2 items
                        if (before.roundedStarCount > after.roundedStarCount) {
                            if (after.roundedStarCount >= 1) {
                                UiModel.SeparatorItem("${after.roundedStarCount}0.000+ stars")
                            } else {
                                UiModel.SeparatorItem("< 10.000+ stars")
                            }
                        } else {
                            // no separator
                            null
                        }
                    }
                }
                .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }

    fun updateDataSource(query: String) {
        pagingInteractor(GithubObserver.Parameters(pagingConfig, query))
    }

}

sealed class UiModel {
    data class RepoItem(val repoView: RepoView) : UiModel()
    data class SeparatorItem(val description: String) : UiModel()
}

private val UiModel.RepoItem.roundedStarCount: Int
    get() = this.repoView.stars / 10_000