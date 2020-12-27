package com.documentary.repo_feature.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.documentary.repo_feature.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashboard.*

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    /*  override fun onCreateView(
          inflater: LayoutInflater,
          container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
  //        dashboardViewModel =
  //            ViewModelProvider(this).get(DashboardViewModel::class.java)
          val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
          val textView: TextView = root.findViewById(R.id.text_dashboard)
          dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
              textView.text = it
          })
          Log.e("parttt", "dashboard")
          return root
      }*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false).also {
            Log.e("parttt", "home")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            text_dashboard.text = it
        })

    }

}