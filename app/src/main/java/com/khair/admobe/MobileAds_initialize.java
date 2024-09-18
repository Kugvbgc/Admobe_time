package com.khair.admobe;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class MobileAds_initialize extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this);

    }
}
