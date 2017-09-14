package dodge.hero.z.gank.presenter;


import dodge.hero.z.gank.view.abstrac.IView;

/**
 * Created by hyj on 2017/5/6.
 */

public interface IPresenter<T extends IView> {

    void init(IPresenterManager presenterManager, T view);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
