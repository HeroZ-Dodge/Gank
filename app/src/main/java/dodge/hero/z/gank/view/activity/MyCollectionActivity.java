package dodge.hero.z.gank.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.model.Collection;
import dodge.hero.z.gank.di.DI;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;
import dodge.hero.z.gank.view.adapter.CollectionAdapter;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class MyCollectionActivity extends BaseAbsActivity {

    private Button mBtnAdd;
    private Button mBtnRefresh;
    private RecyclerView mRecyclerView;
    private CollectionAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_my_collection);
        mBtnAdd = findView(R.id.btn_add);
        mRecyclerView = findView(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new CollectionAdapter(this, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
        mBtnAdd.setOnClickListener(view -> {
            DI.dbRepository().createCollection("我的收藏夹");
            ToastUtils.showShort("添加成功");
        });

        mBtnRefresh = findView(R.id.btn_refresh);
        mBtnRefresh.setOnClickListener(view -> {
            List<Collection> data = DI.dbRepository().loadAllCollections();
            mAdapter.setData(data);
        });

        List<Collection> data = DI.dbRepository().loadAllCollections();

        if (data != null && !data.isEmpty()) {
            mAdapter.setData(data);
        }

    }
}
