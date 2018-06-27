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
import dodge.hero.z.gank.view.IGirlListView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GirlListPresenter extends AbsPresenter<IGirlListView> {

    public static final String KEY_CACHE = "GIRL_LIST_CACHE";
    public static final int PAGE_SIZE = 20;

    @Inject
    GankService mGankService;
    @Inject
    IPreferencesRepository mPreferencesRepository;

    private int mPage = 1;

    @Inject
    public GirlListPresenter() {
    }

    /**
     * 加载缓存
     */
    public void loadCache() {
        Disposable disposable = mPreferencesRepository.getValueRx(KEY_CACHE,
                new ArrayList<>(), new JsonType<ArrayList<GankInfo>>() {
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> mView.refreshData(data));
        addCancelable(disposable);
    }

    private boolean mIsLoading = false;

    /**
     * 加载数据
     *
     * @param next 下一页
     */
    public void loadData(boolean next) {
        if (mIsLoading) {
            return;
        }
        LogUtils.d("加载更多");
        mIsLoading = true;
        int page = next ? mPage + 1 : 1;
        Disposable disposable = mGankService.loadData(DataType.GIRL, PAGE_SIZE, page)
                .map(GankResponse::getResults)
                .doOnNext(data -> {
                    if (!next)
                        mPreferencesRepository.setValue(KEY_CACHE, data, new JsonType<List<GankInfo>>() {
                        });
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    mView.finishLoadData();
                    mPage = page;
                    if (next) {
                        mView.addData(data);
                    } else {
                        mView.refreshData(data);
                    }
                    mIsLoading = false;
                }, throwable -> {
                    mView.finishLoadData();
                    mView.toast("加载数据超时");
                    mIsLoading = false;
                });
        addCancelable(disposable);
    }

}


