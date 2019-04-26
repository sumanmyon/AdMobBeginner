package www.sumanmyon.com.admobbeginner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent interstitialAdIntent = new Intent(this,InterstitialAdUnitActivity.class);
        startActivity(interstitialAdIntent);


        //initalize AdMob                      //here i have put sample id.... plz put real id to get real ad
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        //initalizing adView
        adView = findViewById(R.id.adView);

        //requesting ad
        AdRequest adRequest = new AdRequest.Builder().build();

        //loading ad
        adView.loadAd(adRequest);

        //ad listener
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("Ad Test","ad finishes loading.");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("Ad Test","ad request fails.");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d("Ad Test","ad opens an overlay that covers the screen.");
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.d("Ad Test","user clicks on an ad.");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d("Ad Test","user has left the app.");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d("Ad Test","user is about to return to the app after tapping on an ad.");
            }
        });
    }
}
