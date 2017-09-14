package dodge.hero.z.gank.presenter;


import java.util.ArrayList;
import java.util.List;

import dodge.hero.z.gank.view.abstrac.IView;
import io.reactivex.disposables.Disposable;

/**
 * Created by hyj on 2017/5/6.
 */

public abstract class AbsPresenter<T extends IView> implements IPresenter<T> {

    protected T mView;
    private List<Disposable> mDisposableList;

    @Override
    public void init(IPresenterManager presenterManager, T view) {
        if (presenterManager != null) {
            presenterManager.register(this);
        }
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    protected void addCancelable(Disposable disposable){
        if(mDisposableList == null){
            mDisposableList = new ArrayList<>();
        }
        mDisposableList.add(disposable);
    }

    @Override
    public void onDestroy() {
        if(mDisposableList != null){
            for(Disposable disposable : mDisposableList){
                disposable.dispose();
            }
        }
    }
}
