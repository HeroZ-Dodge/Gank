package dodge.hero.z.gank.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.component.image.GlideApp;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;

/**
 * Created by Linzheng on 2017/9/18.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GirlPictureActivity extends BaseAbsActivity {

    public static final String EXTRA_IMG_URL = "img_url";

    private String mImageUrl;
    private ImageView mIvGirl;

    public static void start(Activity activity, String url) {
        Intent intent = new Intent(activity, GirlPictureActivity.class);
        intent.putExtra(EXTRA_IMG_URL, url);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_girl_picture);
        mImageUrl = getIntent().getStringExtra(EXTRA_IMG_URL);
        mIvGirl = findView(R.id.iv_girl);
        GlideApp.with(this)
                .load(mImageUrl)
                .into(mIvGirl);
    }

}
