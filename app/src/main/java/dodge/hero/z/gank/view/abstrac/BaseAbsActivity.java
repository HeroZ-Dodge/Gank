package dodge.hero.z.gank.view.abstrac;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import dodge.hero.z.gank.presenter.base.IPresenterManager;
import dodge.hero.z.gank.presenter.base.IPresenterManagerImpl;


/**
 * Created by hyj on 2017/5/6.
 */

public abstract class BaseAbsActivity extends RxAppCompatActivity implements IExpansionView {

    protected IPresenterManager mPresenterManager = new IPresenterManagerImpl();

    public IPresenterManager getPresenterManager() {
        return mPresenterManager;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //保证APP内的字体不受系统设置字号大小影响
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;
        mPresenterManager.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenterManager.resume();
    }

    @Override
    protected void onPause() {
        mPresenterManager.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mPresenterManager.stop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mPresenterManager.destroy();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1) {
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration configuration = res.getConfiguration();
        if (configuration.fontScale != 1) {
            configuration.fontScale = 1;
            res.updateConfiguration(configuration, res.getDisplayMetrics());
        }
        return res;
    }


    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(@IdRes int id) {
        return (T) findViewById(id);
    }

    @Override
    public void progressShow() {
        ToastUtils.showShort("TODO");
    }

    @Override
    public void progressShow(String msg) {
        ToastUtils.showShort("TODO");
    }

    @Override
    public void progressCancel() {
        ToastUtils.showShort("TODO");
    }

    @Override
    public void toast(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            ToastUtils.showShort(msg);
        }
    }


}
