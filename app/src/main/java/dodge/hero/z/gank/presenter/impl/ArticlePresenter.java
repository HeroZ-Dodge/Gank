package dodge.hero.z.gank.presenter.impl;

import javax.inject.Inject;

import dodge.hero.z.gank.data.DataType;
import dodge.hero.z.gank.data.GankService;
import dodge.hero.z.gank.data.sp.IPreferencesRepository;
import dodge.hero.z.gank.presenter.base.AbsPresenter;
import dodge.hero.z.gank.view.IArticleListView;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public class ArticlePresenter extends AbsPresenter<IArticleListView> {

    public static final int PAGE_SIZE = 20;

    @Inject
    GankService mGankService;
    @Inject
    IPreferencesRepository mPreferencesRepository;

    private int mPage = 1;


    @Inject
    public ArticlePresenter() {
    }


    public void loadData(boolean next) {
        int page = next ? mPage + 1 : 1;
        mGankService.loadData(DataType.ANDROID, PAGE_SIZE, page)
                .map(response -> {
                    if (response.isError()) {
                        throw new IllegalArgumentException("加载数据超时");
                    } else {
                        return response.getResults();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    mView.finishLoadData();
                    mPage = page;
                    if (page == 1) {
                        mView.refreshArticleData(data);
                    } else {
                        mView.addArticleData(data);
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    mView.finishLoadData();
                    mView.toast("加载数据超时");
                });
    }


}
