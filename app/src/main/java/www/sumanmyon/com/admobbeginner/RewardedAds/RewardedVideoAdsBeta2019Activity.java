package www.sumanmyon.com.admobbeginner.RewardedAds;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import www.sumanmyon.com.admobbeginner.R;

public class RewardedVideoAdsBeta2019Activity extends AppCompatActivity {

    private Button rewardedAdsButton,rewardedAdPreloadButton;
    private RewardedAd rewardedAd,rewardedAd1, rewardedAdPreload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_video_ads_beta2019);
        rewardedAdsButton = (Button)findViewById(R.id.rewardedAds_Beta);
        rewardedAdPreloadButton = (Button)findViewById(R.id.rewardedAds_Beta2);

        //1.  initalize AdMob                      //here i have put sample id.... plz put real id to get real ad
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");

        //2...5 RewardedAd
        //2. instantiating a RewardedAd
        rewardedAd = new RewardedAd(this, "ca-app-pub-3940256099942544/5224354917");

        //3. Load an ad
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback(){
            @Override
            public void onRewardedAdLoaded() {

            }

            @Override
            public void onRewardedAdFailedToLoad(int i) {

            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);

        rewardedAdsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5. Show the ad
                if(rewardedAd.isLoaded()){
                    Activity activity = RewardedVideoAdsBeta2019Activity.this;

                    RewardedAdCallback callback = new RewardedAdCallback(){
                        @Override
                        public void onRewardedAdOpened() {

                        }

                        @Override
                        public void onRewardedAdClosed() {

                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                        }

                        @Override
                        public void onRewardedAdFailedToShow(int i) {

                        }
                    };
                    rewardedAd.show(activity,callback);
                }else {
                    Toast.makeText(RewardedVideoAdsBeta2019Activity.this,"Failed to load",Toast.LENGTH_LONG).show();
                }
            }
        });



        //6...7   RewardedAd for pre load ads
        //6. calling method RewardedAd
        rewardedAdPreload = createAndLoadRewardedAd();
        rewardedAdPreloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //7. Show preload the ad
                showPreloadAds();
            }
        });

        

    }

    private void showPreloadAds() {
        if(rewardedAdPreload.isLoaded()){
            Activity activity = RewardedVideoAdsBeta2019Activity.this;

            RewardedAdCallback callback = new RewardedAdCallback(){
                @Override
                public void onRewardedAdOpened() {

                }

                @Override
                public void onRewardedAdClosed() {
                    rewardedAdPreload = createAndLoadRewardedAd();
                }

                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                }

                @Override
                public void onRewardedAdFailedToShow(int i) {

                }
            };
            rewardedAdPreload.show(activity,callback);
        }else {
            Toast.makeText(RewardedVideoAdsBeta2019Activity.this,"Failed to load",Toast.LENGTH_LONG).show();
        }
    }

    public RewardedAd createAndLoadRewardedAd() {
        RewardedAd ad = new RewardedAd(this, "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback loadCallback = new RewardedAdLoadCallback(){
            @Override
            public void onRewardedAdLoaded() {
            }

            @Override
            public void onRewardedAdFailedToLoad(int i) {
            }
        };
        ad.loadAd(new AdRequest.Builder().build(), loadCallback);
        return ad;
    }
}
