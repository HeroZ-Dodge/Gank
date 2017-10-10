package dodge.hero.z.gank.presenter.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dodge.hero.z.gank.data.DataType;
import dodge.hero.z.gank.data.GankService;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.data.sp.IPreferencesRepository;
import dodge.hero.z.gank.presenter.base.AbsPresenter;
import dodge.hero.z.gank.util.JsonType;
import dodge.hero.z.gank.view.IGirlListView;
import io.reactivex.android.schedulers.AndroidSchedulers;

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
        List<GankInfo> data = mPreferencesRepository.getValue(KEY_CACHE, new ArrayList<>(), new JsonType<ArrayList<GankInfo>>() {
        });
        if (!data.isEmpty()) {
            mView.refreshData(data);
            Log.d("加载缓存", "命中缓存");
        }
    }

    /**
     * 加载数据
     * @param next 下一页
     */
    public void loadData(boolean next) {
        int page = next ? mPage + 1 : 1;
        mGankService.loadData(DataType.GIRL, PAGE_SIZE, page)
                .map(response -> {
                    if (response.isError()) {
                        throw new IllegalArgumentException("加载福利失败");
                    } else {
                        return response.getResults();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    mPage = page;
                    mView.finishLoadData();
                    if (next) {
                        mPreferencesRepository.setValue(KEY_CACHE, data, new JsonType<List<GankInfo>>() {});
                        mView.addData(data);
                    } else {
                        mView.refreshData(data);
                    }
                }, throwable -> {
                    mView.finishLoadData();
                    mView.toast("加载数据超时");
                });
    }

}


