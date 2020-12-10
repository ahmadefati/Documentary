package com.androiddevs.base.utils;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.androiddevs.base.Polyline;
import pub.devrel.easypermissions.EasyPermissions;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/androiddevs/base/utils/TrackingUtility;", "", "()V", "calculatePolylineLength", "", "polyline", "", "Lcom/google/android/gms/maps/model/LatLng;", "Lcom/androiddevs/base/Polyline;", "getFormattedStopWatchText", "", "millis", "", "includeMillis", "", "hasLocationPermission", "context", "Landroid/content/Context;", "base_debug"})
public final class TrackingUtility {
    public static final com.androiddevs.base.utils.TrackingUtility INSTANCE = null;
    
    public final boolean hasLocationPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final float calculatePolylineLength(@org.jetbrains.annotations.NotNull()
    java.util.List<com.google.android.gms.maps.model.LatLng> polyline) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedStopWatchText(long millis, boolean includeMillis) {
        return null;
    }
    
    private TrackingUtility() {
        super();
    }
}