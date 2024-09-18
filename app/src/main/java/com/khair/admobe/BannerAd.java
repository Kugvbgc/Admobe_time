package com.khair.admobe;

import static android.provider.Settings.System.getString;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;



public class BannerAd  {

    private AdView adView;
    private int bannerAdClicked=0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    public BannerAd(Context context, String Ad_uit , LinearLayout adContainerView){
        adView = new AdView(context);
        adView.setAdUnitId(Ad_uit);
        adView.setAdSize(AdSize.BANNER);


        adContainerView.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        sharedPreferences= context.getSharedPreferences(String.valueOf(R.string.app_name),Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        long currentTime=System.currentTimeMillis();
        long lastClickTime=sharedPreferences.getLong("lastClickTime",0);

        if (currentTime-lastClickTime>=300000){

            adContainerView.setVisibility(View.VISIBLE);
        }else {
            adContainerView.setVisibility(View.GONE);
        }




        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Toast.makeText(context, "onAdClicked", Toast.LENGTH_SHORT).show();
                bannerAdClicked++;
                if (bannerAdClicked==2) {
                    if (adView != null) adView.destroy();
                    long currentTime=System.currentTimeMillis();
                    long lastClickTime=sharedPreferences.getLong("lastClickTime",0);

                    if (currentTime - lastClickTime >= 300000) {

                        editor.putLong("lastClickTime", currentTime);
                        editor.apply();
                    } else {
                        adView.destroy();
                    }

                }


            }
        });
                

        adView.loadAd(adRequest);






    }
    //============================================================================




    //============================================================================
}
