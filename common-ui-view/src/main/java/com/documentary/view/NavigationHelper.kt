package com.documentary.view

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.documentary.base.utils.DeepLink
import timber.log.Timber

fun safeNavigate(navController: NavController, direction: NavDirections) {
    try {
        navController.navigate(direction)
    } catch (e: Exception) {
        Timber.tag("Navigate").d(e)
    }
}


/**
 * Navigates through the current graph.
 * @param navController, the nav controller which is responsible for this transaction.
 * @param deepLink, an instance of [DeepLink] for setting destination, please refer to
 * this class for more info.
 * @param popupId, the id of fragment inside of graph which we want to pop up to.
 * @param inclusive, default is true and it means that the fragment related to this popupId will
 * be popped up too.
 */
fun safeNavigate(
    navController: NavController,
    deepLink: DeepLink,
    popupId: Int = 0,
    inclusive: Boolean = true
) {
    try {
        if (popupId != 0) {
            val navOption = NavOptions.Builder().setPopUpTo(popupId, inclusive).build()
            navController.navigate(deepLink.uri, navOption)
        } else {
            navController.navigate(deepLink.uri)
        }
    } catch (e: Exception) {
        Timber.tag("Navigate").d(e)
    }
}