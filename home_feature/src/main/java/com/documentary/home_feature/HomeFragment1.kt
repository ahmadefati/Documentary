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
import androidx.recyclerview.widget.LinearLayoutManager
import com.documentary.data.entities.CountryEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class HomeFragment1 : Fragment()/*(R.layout.fragment_home) */ {


    private val homeViewModel: HomeViewModel1 by viewModels()
    private val countriesAdapter: CountriesAdapter by lazy {
        CountriesAdapter {
            homeViewModel.selectCountry(it)
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

        initRecyclerView()
        subscribe(null);
        filterCountries()
    }

    private fun subscribe(list: List<CountryEntity>?) {
        homeViewModel.liveData.observe(viewLifecycleOwner, Observer {
            if (it.countryEntity.isNotEmpty() && list == null) {
                homeViewModel.countries = it.countryEntity.toList()
                countriesAdapter.submitList(homeViewModel.countries)
            } else if (list != null) {
                countriesAdapter.submitList(list)
            }


        })
    }

    private fun initRecyclerView() {
        recyclerHome1?.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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

                val filterResult = homeViewModel.countries.filter {
                    it.country.contains(target)
                }
                subscribe(filterResult)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }


}