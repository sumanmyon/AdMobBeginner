package www.sumanmyon.com.admobbeginner.RewardedAds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import www.sumanmyon.com.admobbeginner.R;

//2. implement listener
public class RewardedVideoAdsActivity extends AppCompatActivity implements RewardedVideoAdListener {

    Button rewardedAdsButton;
    RewardedVideoAd videoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_video_ads);
        rewardedAdsButton = (Button)findViewById(R.id.rewardedAds);

        //1.  initalize AdMob                      //here i have put sample id.... plz put real id to get real ad
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        videoAd = MobileAds.getRewardedVideoAdInstance(this);
        videoAd.setRewardedVideoAdListener(this);

        //3. load video Ads
        videoAd.loadAd("ca-app-pub-3940256099942544/5224354917",new AdRequest.Builder().build());

        rewardedAdsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4. show Ads
                if(videoAd.isLoaded())
                    videoAd.show();
            }
        });
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}
