package com.documentary.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sample.login.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        Log.e("parttt", "dashboard")
        return root
    }
}
