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

    }



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