package www.sumanmyon.com.admobbeginner.NativeAdsPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;

import www.sumanmyon.com.admobbeginner.R;

public class NativeAdsActivity extends AppCompatActivity {
    NativeExpressAdView nativeExpressAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ads);

        nativeExpressAdView = (NativeExpressAdView)findViewById(R.id.nativeExpressAdView);

        //initalize AdMob                      //here i have put sample id.... plz put real id to get real ad
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        nativeExpressAdView.loadAd(new AdRequest.Builder().build());
    }
}
