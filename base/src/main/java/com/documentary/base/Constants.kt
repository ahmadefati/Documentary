package com.documentary.base

import android.graphics.Color

object Constants {
    const val DATABASE_NAME = "running_db"

    const val REQUEST_CODE_LOCATION_PERMISSION = 0

    const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE"
    const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
    const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"
    const val ACTION_NAVIGATE_TO_TRACKING_FRAGMENT = "ACTION_NAVIGATE_TO_TRACKING_FRAGMENT"

    const val SHARED_PREFS_NAME = "running_sharedPrefs"
    const val KEY_NAME = "shared_prefs_key_name"
    const val KEY_WEIGHT = "shared_prefs_key_weight"
    const val KEY_FIRST_TIME_TOGGLE = "shared_prefs_key_first_time_toggle"

    const val TIMER_DELAY_INTERVAL = 50L

    const val UPDATE_LOCATION_INTERVAL = 5000L
    const val FASTEST_LOCATION_INTERVAL = 2000L

    const val POLYLINE_COLOR = Color.RED
    const val POLYLINE_WIDTH = 16f
    const val MAP_ZOOM = 18f

    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Tracking"
    const val NOTIFICATION_ID = 1
    const val EVENT_UNAUTH = "EVENT_UNAUTH"
}