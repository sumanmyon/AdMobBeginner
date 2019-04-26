package www.sumanmyon.com.admobbeginner.InterstitialAdsSlidingImagesPackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import www.sumanmyon.com.admobbeginner.R;

public class MyPageAdapter extends PagerAdapter {

    private List<Album> imAlbumList;
    private Context context;
    private LayoutInflater inflater;

    public MyPageAdapter(List<Album> imAlbumList, Context context) {
        this.imAlbumList = imAlbumList;
        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imAlbumList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Album album = imAlbumList.get(position);
        View itemView = inflater.inflate(R.layout.album_layout,container,false);

        ImageView imageView = (ImageView)itemView.findViewById(R.id.imageView);
        int imgId = context.getResources().getIdentifier(album.getImageID(),"drawable",context.getPackageName());
        imageView.setImageResource(imgId);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
