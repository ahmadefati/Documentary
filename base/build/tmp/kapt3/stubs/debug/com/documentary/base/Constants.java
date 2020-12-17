package com.documentary.base;

import android.graphics.Color;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/documentary/base/Constants;", "", "()V", "ACTION_NAVIGATE_TO_TRACKING_FRAGMENT", "", "ACTION_PAUSE_SERVICE", "ACTION_START_OR_RESUME_SERVICE", "ACTION_STOP_SERVICE", "DATABASE_NAME", "EVENT_UNAUTH", "FASTEST_LOCATION_INTERVAL", "", "KEY_FIRST_TIME_TOGGLE", "KEY_NAME", "KEY_WEIGHT", "MAP_ZOOM", "", "NOTIFICATION_CHANNEL_ID", "NOTIFICATION_CHANNEL_NAME", "NOTIFICATION_ID", "", "POLYLINE_COLOR", "POLYLINE_WIDTH", "REQUEST_CODE_LOCATION_PERMISSION", "SHARED_PREFS_NAME", "TIMER_DELAY_INTERVAL", "UPDATE_LOCATION_INTERVAL", "base_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "running_db";
    public static final int REQUEST_CODE_LOCATION_PERMISSION = 0;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_NAVIGATE_TO_TRACKING_FRAGMENT = "ACTION_NAVIGATE_TO_TRACKING_FRAGMENT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SHARED_PREFS_NAME = "running_sharedPrefs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_NAME = "shared_prefs_key_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_WEIGHT = "shared_prefs_key_weight";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_FIRST_TIME_TOGGLE = "shared_prefs_key_first_time_toggle";
    public static final long TIMER_DELAY_INTERVAL = 50L;
    public static final long UPDATE_LOCATION_INTERVAL = 5000L;
    public static final long FASTEST_LOCATION_INTERVAL = 2000L;
    public static final int POLYLINE_COLOR = android.graphics.Color.RED;
    public static final float POLYLINE_WIDTH = 16.0F;
    public static final float MAP_ZOOM = 18.0F;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_ID = "tracking_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_NAME = "Tracking";
    public static final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EVENT_UNAUTH = "EVENT_UNAUTH";
    public static final com.documentary.base.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}