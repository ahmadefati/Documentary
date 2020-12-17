package com.documentary.home_feature

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
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
        subscribe();

    }

    private fun subscribe() {
        homeViewModel.liveData.observe(viewLifecycleOwner, Observer {
            if (it.countryEntity.isNotEmpty()) {
                countriesAdapter.submitList(it.countryEntity)
            }


        })
    }

    private fun initRecyclerView() {
        recyclerHome1?.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }


}