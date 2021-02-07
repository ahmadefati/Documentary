package com.documentary.repo_feature.dashboard

import com.documentary.data.repos.GithubRepository
import io.mockk.impl.annotations.MockK


class DashboardViewModelTest {
    @MockK(relaxed = true)
    lateinit var repository: GithubRepository
    lateinit var viewModel: DashboardViewModel
}