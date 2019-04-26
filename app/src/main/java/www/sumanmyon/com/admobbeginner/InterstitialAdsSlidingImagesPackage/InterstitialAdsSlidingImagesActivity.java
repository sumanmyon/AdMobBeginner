package www.sumanmyon.com.admobbeginner.InterstitialAdsSlidingImagesPackage;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import www.sumanmyon.com.admobbeginner.R;

public class InterstitialAdsSlidingImagesActivity extends AppCompatActivity {

    private List<Album> imgList = new ArrayList<>();
    private ViewPager viewPager;
    private MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ads_sliding_images);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        prepareImageList();
        pageAdapter = new MyPageAdapter(imgList,this);
        viewPager.setAdapter(pageAdapter);
    }

    private void prepareImageList(){
        int count = 1;
        while (count<=11){
            String imgId = "pic"+String.valueOf(count);
            imgList.add(new Album(imgId));
            count++;
        }
    }
}
