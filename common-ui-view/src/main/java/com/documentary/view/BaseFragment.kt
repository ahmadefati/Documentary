package com.documentary.view

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.documentary.base.data.model.AppStatus
import com.documentary.base.utils.DateUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

interface OnKeyboardVisibilityListener {
    fun onKeyboardVisibilityChanged(visible: Boolean)
}

@AndroidEntryPoint
open class BaseFragment : Fragment(), OnKeyboardVisibilityListener {

    companion object {
        var loginSubmitCallback: ((Int) -> Unit)? = null
    }

    @Inject
    lateinit var appStatus: AppStatus

    @MenuRes
    open var menuResource: Int = -1

    lateinit var navController: NavController


    @Inject
    lateinit var dateUtil: DateUtil

    open val visibilityStatusBar = true

    open val keyboardVisibilityListener = false

    private lateinit var globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener
    var parentView: View? = null

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menuResource != -1) inflater.inflate(menuResource, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /***
         * removes last actionbar to prevent memory leak
         * cannot be done in onDestroy() because lastFragment onDestroy called
         *  after newFragment onCreate and sets new supportActionBar null
         * so first we removes last supportActionBar  first(if there is any)
         *  and then set new supportActionBar using setupToolbar function if it's necessary
         */
        (requireActivity() as AppCompatActivity).setSupportActionBar(null)

        navController = findNavController()
//        visibilityStatusBar(visibilityStatusBar)
    }

    /* open fun setupToolbar() {

         requireView().findViewById<Toolbar>(R.id.toolbar_general)?.let { toolbar ->

             (requireActivity() as AppCompatActivity).apply {
                 setSupportActionBar(toolbar)

                 supportActionBar?.let { actionBar ->
                     actionBar.setDisplayShowTitleEnabled(false)
                     actionBar.setDisplayHomeAsUpEnabled(true)
                     actionBar.setDisplayShowHomeEnabled(true)
                 }
             }

             toolbar.findViewById<View>(R.id.tv_toolbar_go_to_home)?.let {
                 it.setOnClickListener {
                     navController.popBackStack(R.id.personalInfoFragment, false)
                 }
             }
         }

     }*/

    /*   fun visibilityStatusBar(showStatusBar: Boolean) {
           if (showStatusBar) {
               requireActivity().window.setFlags(
                   WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                   WindowManager.LayoutParams.FLAG_FULLSCREEN
               )
               requireActivity().window.decorView.systemUiVisibility =
                   SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                   requireActivity().window.statusBarColor =
                       ContextCompat.getColor(requireContext(), R.color.colorWhite)
               }
           } else {
               requireActivity().window.decorView.systemUiVisibility =
                   SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                   requireActivity().window.statusBarColor = Color.TRANSPARENT
               }

           }
       }*/

    /*open fun checkForResetApp(
        errorCode: String?,
        errorMessage: String?,
        submitCallback: ((Int) -> Unit)? = null,
        cancelCallback: ((Int) -> Unit)? = null,
        submitElseCallback: ((Int) -> Unit)? = null,
        elseRun: ((Int) -> Unit)? = null

    ) {
        when {
            (errorCode ?: "") == ExceptionHelper.ErrorCodes.NoInternetConnection.name -> {
                val connectionErrorDialog =
                    getConnectionErrorDialog(requireContext(), navController = navController)
                connectionErrorDialog.submitCallback = submitCallback
                if (cancelCallback != null) {
                    connectionErrorDialog.cancelCallback = cancelCallback
                }
                connectionErrorDialog.safeShow(childFragmentManager, "no_internet_connection")
            }
            (errorCode ?: "") == "10" -> {
                when (navController.currentDestination?.id) {
                    R.id.splashFragment,
                    R.id.homePageFragment,
                    R.id.userHomePageFragment,
                    R.id.userRegisterFragment,
                    R.id.userLoginFragment,
                    R.id.userForgetPasswordFragment,
                    R.id.userForgetPasswordVerificationFragment -> return
                    else -> {
                        loginSubmitCallback = submitCallback

                        safeNavigate(
                            navController,
                            DeepLink.Builder()
                                .module(MODULE_UI_USER)
                                .fragment(DIALOG_LOGIN)
                                .build()
                        )
                    }
                }
            }
            else -> elseRun?.invoke(0) ?: run {
                val errorDialog = getErrorDialog(
                    requireContext(),
                    getString(R.string.msg_general_error_title),
                    errorMessage ?: getString(R.string.msg_general_error),
                    if (submitElseCallback == null && submitCallback == null) requireContext().getString(
                        R.string.label_dialog_submit
                    ) else requireContext().getString(R.string.btn_retry)
                )
                errorDialog.submitCallback = submitElseCallback ?: submitCallback
                errorDialog.safeShow(childFragmentManager, "errorMessage")
            }
        }
    }*/

    override fun onResume() {
        super.onResume()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }


    private fun setKeyboardVisibilityListener(onKeyboardVisibilityListener: OnKeyboardVisibilityListener) {
        parentView =
            (requireActivity().findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0)

        globalLayoutListener = object : ViewTreeObserver.OnGlobalLayoutListener {

            private var alreadyOpen: Boolean = false
            private val defaultKeyboardHeightDP = 100
            private val EstimatedKeyboardDP =
                defaultKeyboardHeightDP + if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) 48 else 0
            private val rect = Rect()

            override fun onGlobalLayout() {
                parentView?.let {
                    val estimatedKeyboardHeight = TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        EstimatedKeyboardDP.toFloat(),
                        it.resources.displayMetrics
                    ).toInt()
                    it.getWindowVisibleDisplayFrame(rect)
                    val heightDiff = it.rootView.height - (rect.bottom - rect.top)
                    val isShown = heightDiff >= estimatedKeyboardHeight

                    if (isShown == alreadyOpen) {
                        return
                    }
                    alreadyOpen = isShown


                    onKeyboardVisibilityListener.onKeyboardVisibilityChanged(isShown)
                }
            }
        }
        parentView?.viewTreeObserver?.addOnGlobalLayoutListener(globalLayoutListener)
    }

    override fun onKeyboardVisibilityChanged(visible: Boolean) {}

    override fun onStart() {
        super.onStart()
        if (keyboardVisibilityListener)
            setKeyboardVisibilityListener(this)
    }

    override fun onStop() {
        super.onStop()
        parentView?.viewTreeObserver?.removeOnGlobalLayoutListener(globalLayoutListener)
    }

}