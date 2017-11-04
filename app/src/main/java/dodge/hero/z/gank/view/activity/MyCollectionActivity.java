package dodge.hero.z.gank.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.model.Collection;
import dodge.hero.z.gank.di.DI;
import dodge.hero.z.gank.view.abstrac.BaseAbsActivity;
import dodge.hero.z.gank.view.adapter.CollectionAdapter;
import dodge.hero.z.gank.view.dialog.CreateCollectionDialog;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class MyCollectionActivity extends BaseAbsActivity {


    private ImageView mIvAddFolder;
    private ImageView mIvEdit;


    private Toolbar mToolbar;




    private RecyclerView mRecyclerView;
    private CollectionAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_activity_my_collection);
        initView();

        loadData();

    }

    private void initView() {
        mToolbar = findView(R.id.tool_bar);
        mIvAddFolder = findView(R.id.iv_add_folder);
        mIvEdit = findView(R.id.iv_edit);

        mIvAddFolder.setOnClickListener(v -> {
            DialogFragment dialog = new CreateCollectionDialog();
            dialog.show(getSupportFragmentManager(), "create");
        });

        mIvEdit.setOnClickListener(v -> {
            ToastUtils.showShort("edit");
        });

        mToolbar.setTitle("我的收藏");
        setSupportActionBar(mToolbar);

        mRecyclerView = findView(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new CollectionAdapter(this, new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadData() {
        List<Collection> data = DI.dbRepository().loadAllCollections();
        if (data != null && !data.isEmpty()) {
            mAdapter.setData(data);
        }
    }


}
