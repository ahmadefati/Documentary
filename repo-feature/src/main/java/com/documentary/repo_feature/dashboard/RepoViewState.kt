package com.documentary.repo_feature.dashboard

import androidx.paging.PagingData
import com.documentary.view.UiError

data class RepoViewState(
    val pagingDataUiModel: PagingData<UiModel> = PagingData.empty(),
    val error: UiError? = null,
    val refreshing: Boolean = false
)