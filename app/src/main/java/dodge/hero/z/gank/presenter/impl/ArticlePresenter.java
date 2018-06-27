package dodge.hero.z.gank.presenter.impl;

import com.blankj.utilcode.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dodge.hero.z.gank.data.http.DataType;
import dodge.hero.z.gank.data.http.GankService;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.data.model.GankResponse;
import dodge.hero.z.gank.data.preferences.IPreferencesRepository;
import dodge.hero.z.gank.presenter.base.AbsPresenter;
import dodge.hero.z.gank.util.JsonType;
import dodge.hero.z.gank.view.IArticleListView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public class ArticlePresenter extends AbsPresenter<IArticleListView> {

    public static final int PAGE_SIZE = 20;
    public static final String CACHE_KEY = "ArticlePresenter_";

    @Inject
    GankService mGankService;
    @Inject
    IPreferencesRepository mPreferencesRepository;

    private int mPage = 1;
    private String mDataType;

    @Inject
    public ArticlePresenter() {
    }


    public void initData(String dataType) {
        this.mDataType = dataType;
    }

    /**
     * 加载缓存
     */
    public void loadCache() {
        Disposable disposable = mPreferencesRepository.getValueRx(CACHE_KEY + mDataType,
                new ArrayList<>(), new JsonType<ArrayList<GankInfo>>() {
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> mView.refreshArticleData(data));
        addCancelable(disposable);
    }

    private boolean mIsLoading = false;

    public void loadData(boolean next) {
        if (mIsLoading) {
            return;
        }
        LogUtils.d("加载更多");
        mIsLoading = true;
        int page = next ? mPage + 1 : 1;
        Disposable disposable = mGankService.loadData(mDataType, PAGE_SIZE, page)
                .map(GankResponse::getResults)
                .doOnNext(data -> {
                    if (!next)
                        mPreferencesRepository.setValue(CACHE_KEY + mDataType, data, new JsonType<List<GankInfo>>() {
                        });
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
                    mIsLoading = false;
                }, throwable -> {
                    throwable.printStackTrace();
                    mView.finishLoadData();
                    mView.toast("加载数据超时");
                    mIsLoading = false;
                });
        addCancelable(disposable);
    }


}
