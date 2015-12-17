package com.gzqilin.weimi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 网络状态判断
 *
 * @author lsh
 */
public class NetworkUtils {

    /**
     * need "android.permission.ACCESS_NETWORK_STATE" permission if network unavailable, will
     * return null or false
     */
    public static boolean available(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 可能为null，会触发NullPointerExcepion
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            return false;
        } else {
            return ni.isAvailable();
        }
    }

    /**
     * need "android.permission.CHANGE_NETWORK_STATE" permission
     */
    public static void toggleGprs(Context context, boolean enabled) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class<?> connectivityManagerClass = Class.forName(connectivityManager.getClass().getName());
            Field mServiceField = connectivityManagerClass.getDeclaredField("mService");
            mServiceField.setAccessible(true);
            Object iConnectivityManagerObject = mServiceField.get(connectivityManager);
            Class<?> iConnectivityManagerClass = Class.forName(iConnectivityManagerObject.getClass().getName());
            Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
            setMobileDataEnabledMethod.setAccessible(true);
            setMobileDataEnabledMethod.invoke(iConnectivityManagerObject, enabled);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * need "android.permission.CHANGE_WIFI_STATE" permission
     */
    public void toggleWiFi(Context context, boolean enabled) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(enabled);
    }

    public static NetworkType getType(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 可能为null，会触发NullPointerExcepion
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null) {
            switch (ni.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    return NetworkType.Wifi;
                case ConnectivityManager.TYPE_MOBILE:
                    return NetworkType.Mobile;
                default:
                    return NetworkType.Other;
            }
        }
        return NetworkType.None;
    }

    public static boolean isWifi(Context context) {
        return getType(context).equals(NetworkType.Wifi);
    }

    public enum NetworkType {
        None(0),
        Mobile(1),
        Wifi(2),
        Other(3);

        public int value;

        NetworkType(int value) {
            this.value = value;
        }

    }

}