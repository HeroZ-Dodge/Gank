package dodge.hero.z.gank.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

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

    private PhotoViewAttacher mViewAttacher;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_girl_picture);
        mImageUrl = getIntent().getStringExtra(EXTRA_IMG_URL);
        mIvGirl = findView(R.id.iv_girl);
        GlideApp.with(this)
                .load(mImageUrl)
                .into(mIvGirl);

        mViewAttacher = new PhotoViewAttacher(mIvGirl);
        mViewAttacher.setOnLongClickListener(view -> {
            ToastUtils.showShort("长按");
            return true;
        });
        mViewAttacher.setOnScaleChangeListener((scaleFactor, focusX, focusY) -> {
            Log.d("ScaleChange", String.format("scaleFactor = %s, focusX = %s , focusY = %s", scaleFactor, focusX, focusY));
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
