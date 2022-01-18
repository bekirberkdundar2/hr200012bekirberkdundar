package com.hr200012.bekir_berk_dundar_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetUtil {
    public static boolean internetVarMi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return netInfo != null
                &&
                netInfo.isAvailable()
                &&
                netInfo.isConnected();
    }
}