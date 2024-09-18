package com.khair.admobe;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {


    LinearLayout adContainerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adContainerView=findViewById(R.id.list_item);

        BannerAd bannerAd=new BannerAd(this,"ca-app-pub-3940256099942544/9214589741",adContainerView);



















    }
}