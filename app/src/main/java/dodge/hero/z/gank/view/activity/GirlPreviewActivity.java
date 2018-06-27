package dodge.hero.z.gank.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.component.image.GlideApp;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;

/**
 * Created by linzheng on 2018/6/7.
 */

public class GirlPreviewActivity extends BaseAbsActivity {

    public static final String EXTRA_GANK_LIST = "gank_list";
    public static final String EXTRA_POSITION = "position";

    private ViewPager mViewPager;
    private List<GankInfo> gankList;
    private int mPosition;

    public static void start(Context context, ArrayList<GankInfo> gankList, int position) {
        Intent intent = new Intent(context, GirlPreviewActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_GANK_LIST, gankList);
        intent.putExtra(EXTRA_POSITION, position);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_preview_girl);
        mViewPager = findViewById(R.id.view_pager);
        gankList = getIntent().getParcelableArrayListExtra(EXTRA_GANK_LIST);
        mPosition = getIntent().getIntExtra(EXTRA_POSITION, 0);
        if (gankList != null && !gankList.isEmpty()) {
            mViewPager.setAdapter(new PictureAdapter(this, gankList));
            mViewPager.setCurrentItem(mPosition);
        }
    }

    private class PictureAdapter extends PagerAdapter {

        private Context mContext;
        private List<GankInfo> mData;

        public PictureAdapter(Context mContext, List<GankInfo> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @Override
        public int getCount() {
            return mData == null ? 0 : mData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.gank_item_preview_picture, container, false);
            bindViewData(view, position);
            container.addView(view);
            return view;
        }

        private void bindViewData(View view, int position) {
            GankInfo item = mData.get(position);
            PhotoView photoView = view.findViewById(R.id.photo_view);
            GlideApp.with(mContext).load(item.getUrl()).centerCrop().into(photoView);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (object instanceof View) {
                container.removeView((View) object);
            }
        }

    }

}
