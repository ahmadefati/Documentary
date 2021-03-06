package com.documentary.home_feature

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.documentary.base.data.model.AppStatus
import com.documentary.view.autoCleared
import com.documentary.view.safeNavigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var navController: NavController

    @Inject
    lateinit var appStatus: AppStatus

    private val homeViewModel: HomeViewModel by viewModels()

    private var countriesAdapter by autoCleared<CountriesAdapter>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()
        if (!appStatus.showSplash) {
            safeNavigate(
                navController,
                HomeFragmentDirections.actionHomePageFragmentToSplashFragment()
            )
            appStatus.showSplash = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false).also {
            Log.e("parttt", "home")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getAllCountries()
        initRecyclerView()
        subscribe(null);
        filterCountries()
    }

    private fun subscribe(list: List<CountryView>?) {
        homeViewModel.liveData.observe(viewLifecycleOwner, Observer {
            if (it.countryView.isNotEmpty() && list == null) {
                homeViewModel.countries = it.countryView.toList()
                countriesAdapter.submitList(homeViewModel.countries)
                if (it.allInfoView != null) {
                    allCasesText.text = it.allInfoView.cases.toString()
                    deathsText.text = it.allInfoView.deaths.toString()
                    recovered.text = it.allInfoView.recovered.toString()
                }
            } else if (list != null) {
                countriesAdapter.submitList(list)
            }

        })
    }

    private fun initRecyclerView() {
        countriesAdapter = CountriesAdapter(
            // homeViewModel.selectCountry(it)
        )
        recyclerHome1?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = countriesAdapter

        }
    }

    private fun filterCountries() {
        textInputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val target = charSequence.toString()
                if (target.isNotEmpty()) {
                    target[0].toUpperCase()
                }

                val filterResult = homeViewModel.countries?.filter {
                    it.country.contains(target)
                }
                subscribe(filterResult)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

}