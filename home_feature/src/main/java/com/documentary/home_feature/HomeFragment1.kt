package com.documentary.home_feature

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.domain.runs.SortType
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment1 : Fragment(R.layout.fragment_home) {

    private  val homeViewModel : HomeViewModel1 by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//            homeViewModel.clickOnCountry()
//        setupRecyclerView()


    }

    private fun showAllInfo() {
        initInfoWithDatabase()
        getInfoFromRemote()
    }

    private fun showCountriesList() {

        initCountriesWithDb()
        getCountriesFromRemote()

    }

    private fun getInfoFromRemote() {
        homeViewModel.getAllInfo()

        homeViewModel.allInfoResult.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.info = it.data
                }
                Status.LOADING -> {
                    Snackbar.make(
                        requireView(),
                        getString(R.string.please_wait),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Snackbar.make(
                        requireView(),
                        getString(R.string.network_timeout),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            hideSwipeRefreshProgress()
        })
    }

    private fun hideSwipeRefreshProgress() {
        binding.swipeLayout.isRefreshing = false
    }

    private fun initInfoWithDatabase() {
        homeViewModel.getAllInfoDb()
        homeViewModel.allInfoDbResult.observe(viewLifecycleOwner, Observer {
            binding.info = it
        })
    }

    private fun getCountriesFromRemote() {
        homeViewModel.getAllCountries()

        homeViewModel.allCountriesResult.observe(viewLifecycleOwner, Observer {
            if (it.status == Status.SUCCESS) {

                it.data?.let { all ->
                    countries = all.toList()
                }

                showRecycler(it.data?.toList())
            }
            hideSwipeRefreshProgress()
        })
    }

    private fun initCountriesWithDb() {
        homeViewModel.getAllCountriesDb()
        homeViewModel.allCountriesDbResult.observe(viewLifecycleOwner, Observer {
            countries = it
            showRecycler(it)
        })
    }

    private fun showRecycler(list: List<CountryEntity>?) {
        list?.let {
            countriesAdapter = CountriesAdapter(
                it,
                this
            )
        }

        binding.recyclerHome.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        hideProgressBar()

    }

    private fun setOnAllInfoClick() {

        binding.allDetails.setOnSingleClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment())
        }

    }

    private fun hideProgressBar() {
        binding.homeProgress.visibility = View.GONE
    }

    private fun filterFeedArticles() {
        binding.textInputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val target = charSequence.toString()
                if (target.isNotEmpty()) {
                    target[0].toUpperCase()
                }

                val filterResult = countries.filter {
                    it.country.contains(target)
                }
                showRecycler(filterResult)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    override fun onItemClick(countryName: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToCountryFragment(
                countryName
            )
        )
    }

    override fun onRefresh() {
        getInfoFromRemote()
        getCountriesFromRemote()
    }

}