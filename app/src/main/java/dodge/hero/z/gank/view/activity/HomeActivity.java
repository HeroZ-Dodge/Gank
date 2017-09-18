package dodge.hero.z.gank.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;
import dodge.hero.z.gank.view.fragment.GankGirlFragment;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class HomeActivity extends BaseAbsActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_home);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.frame_layout, new GankGirlFragment())
                .commitAllowingStateLoss();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
