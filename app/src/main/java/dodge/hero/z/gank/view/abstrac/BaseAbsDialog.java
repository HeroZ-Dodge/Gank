package dodge.hero.z.gank.view.abstrac;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;

import dodge.hero.z.gank.presenter.IPresenterManager;
import dodge.hero.z.gank.presenter.IPresenterManagerImpl;


/**
 * Created by Linzheng on 2017/7/4.
 * <br>Email:linzheng@aipai.com</br>
 */

public abstract class BaseAbsDialog extends DialogFragment implements IExpansionView {

    protected IPresenterManager mPresenterManager = new IPresenterManagerImpl();
    protected View mRootView;

    public IPresenterManager getPresenterManager() {
        return mPresenterManager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(layout(), container, false);
            initView();
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mRootView == null) {
            mRootView = view;
        }
    }

    public abstract int layout();

    public abstract void initView();


    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(@IdRes int id) {
        return (T) mRootView.findViewById(id);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenterManager.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenterManager.resume();
    }

    @Override
    public void onPause() {
        mPresenterManager.pause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mPresenterManager.stop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mPresenterManager.destroy();
        super.onDestroy();
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
