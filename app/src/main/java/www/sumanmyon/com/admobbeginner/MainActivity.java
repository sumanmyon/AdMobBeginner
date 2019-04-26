package www.sumanmyon.com.admobbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initalize AdMob
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
    }
}
