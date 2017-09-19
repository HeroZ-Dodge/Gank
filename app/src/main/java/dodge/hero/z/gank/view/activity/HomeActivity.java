package dodge.hero.z.gank.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;
import dodge.hero.z.gank.view.fragment.GirlListFragment;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class HomeActivity extends BaseAbsActivity {

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
        mViewPager = findView(R.id.view_pager);
        mTabLayout = findView(R.id.tab_layout);
        mViewPager.setOffscreenPageLimit(1);
        mPagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    private class FragmentAdapter extends FragmentPagerAdapter {

//        private String[] mT


        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new GirlListFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

}
