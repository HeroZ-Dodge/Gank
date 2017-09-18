package dodge.hero.z.gank.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.GankService;
import dodge.hero.z.gank.data.model.GirlImage;
import dodge.hero.z.gank.view.abstrac.BaseAbsFragment;
import dodge.hero.z.gank.view.adapter.GankGirlAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GankGirlFragment extends BaseAbsFragment {

    private RecyclerView mRecyclerView;
    private GankGirlAdapter mAdapter;
    private GankService mGankService;


    @Override
    public int layout() {
        return R.layout.gank_fragment_girl;
    }

    @Override
    public void initView() {
        mRecyclerView = findView(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create());
        mGankService = builder.build().create(GankService.class);
        mGankService.getUserList(1)
                .doOnSubscribe(disposable -> {
                    Log.d("GirlFragment", "加载中");
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    showGirlListData(response.getResults());
                }, Throwable::printStackTrace);
    }


    public void showGirlListData(List<GirlImage> data) {
        mAdapter = new GankGirlAdapter(getContext(), R.layout.gank_item_girl_image, data);
        mRecyclerView.setAdapter(mAdapter);
    }



}
