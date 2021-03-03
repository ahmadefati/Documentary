package com.documentary.home_feature

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.documentary.home_feature.databinding.FragmentSplashBinding
import com.documentary.view.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SplashFragment : Fragment() {

    var splashFinished = false
    lateinit var navController: NavController

    private var binding by autoCleared<FragmentSplashBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()
        initView()
    }

    private fun initView() {

        val splashAnimation = R.raw.splash_light

        binding.lvSplash.setAnimation(splashAnimation)

        binding.lvSplash.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                finishSplash()
                splashFinished = true

            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }
        })

    }

    private fun finishSplash() {
        try {
            navController.navigateUp()
        } catch (t: Throwable) {
            Timber.tag("SplashFragment").d(t)
        }
    }

    override fun onResume() {
        super.onResume()

        if (splashFinished)
            finishSplash()

    }


}