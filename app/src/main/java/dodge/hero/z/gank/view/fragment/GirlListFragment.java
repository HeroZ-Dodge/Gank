package dodge.hero.z.gank.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.di.DI;
import dodge.hero.z.gank.presenter.impl.GirlListPresenter;
import dodge.hero.z.gank.view.IGirlListView;
import dodge.hero.z.gank.view.abstrac.BaseAbsFragment;
import dodge.hero.z.gank.view.activity.GirlPictureActivity;
import dodge.hero.z.gank.view.activity.GirlPreviewActivity;
import dodge.hero.z.gank.view.adapter.GankGirlAdapter;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GirlListFragment extends BaseAbsFragment implements IGirlListView {

    @Inject
    GirlListPresenter mPresenter;

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private GankGirlAdapter mAdapter;

    @Override
    public int layout() {
        return R.layout.gank_fragment_girl;
    }

    @Override
    public void initView() {
        mRefreshLayout = findView(R.id.refresh_layout);
        mRefreshLayout.setEnableLoadmore(false);
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));
        mRefreshLayout.setOnRefreshListener(layout -> loadData(false));
        mRecyclerView = findView(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    int[] lastPosition = layoutManager.findLastVisibleItemPositions(null);
                    if (mAdapter.getItemCount() - lastPosition[0] < 6) {
                        mPresenter.loadData(true);
                    }
                }
            }
        });
        mAdapter = new GankGirlAdapter(getContext(), new ArrayList<>());
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                GirlPreviewActivity.start(getActivity(), (ArrayList<GankInfo>) mAdapter.getData(), position);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter == null) {
            DI.component(getActivity()).inject(this);
            mPresenter.init(mPresenterManager, this);
            mPresenter.loadCache();
            loadData(false);
        }
    }


    private void loadData(boolean next) {
        mPresenter.loadData(next);
    }

    /**
     * 加载数据结束
     * 收起加载动画
     */
    @Override
    public void finishLoadData() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        } else if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadmore();
        }
    }

    @Override
    public void refreshData(List<GankInfo> data) {
        if (mAdapter != null) {
            mAdapter.setData(data);
        }
    }

    @Override
    public void addData(List<GankInfo> data) {
        if (mAdapter != null) {
            mAdapter.addData(data);
        }
    }

}
