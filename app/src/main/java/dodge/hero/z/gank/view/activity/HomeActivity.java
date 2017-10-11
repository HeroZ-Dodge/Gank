package dodge.hero.z.gank.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.blankj.utilcode.util.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.http.DataType;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;
import dodge.hero.z.gank.view.fragment.ArticleFragment;
import dodge.hero.z.gank.view.fragment.GirlListFragment;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class HomeActivity extends BaseAbsActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FragmentPagerAdapter mPagerAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_home);
        initView();
    }

    private void initView() {
        mToolbar = findView(R.id.tool_bar);
        mToolbar.setOnClickListener(view -> {
            ActivityUtils.startActivity(this, MyCollectionActivity.class);
        });
        mViewPager = findView(R.id.view_pager);
        mTabLayout = findView(R.id.tab_layout);
        mViewPager.setOffscreenPageLimit(1);
        mPagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    private class FragmentAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
            mFragments = new ArrayList<>();
            mFragments.add(new GirlListFragment());
            mFragments.add(ArticleFragment.build(DataType.ALL));
            mFragments.add(ArticleFragment.build(DataType.ANDROID));
            mFragments.add(ArticleFragment.build(DataType.IOS));
            mFragments.add(ArticleFragment.build(DataType.VIDEO));
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "妹纸";
                case 1:
                    return "最新";
                case 2:
                    return "Android";
                case 3:
                    return "IOS";
                case 4:
                    return "视频";
                default:
                    return "其他";
            }
        }
    }

}
