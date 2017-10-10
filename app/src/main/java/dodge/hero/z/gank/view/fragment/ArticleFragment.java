package dodge.hero.z.gank.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
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
import dodge.hero.z.gank.presenter.impl.ArticlePresenter;
import dodge.hero.z.gank.view.IArticleListView;
import dodge.hero.z.gank.view.abstrac.BaseAbsFragment;
import dodge.hero.z.gank.view.activity.WebActivity;
import dodge.hero.z.gank.view.adapter.ArticleAdapter;

/**
 * 文章列表
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */
public class ArticleFragment extends BaseAbsFragment implements IArticleListView {


@Inject
    ArticlePresenter mPresenter;

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;

    private ArticleAdapter mAdapter;


    @Override
    public int layout() {
        return R.layout.gank_fragment_article;
    }

    @Override
    public void initView() {
        mRefreshLayout = findView(R.id.refresh_layout);
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));
        mRefreshLayout.setRefreshFooter(new ClassicsFooter(getContext()));
        mRefreshLayout.setOnLoadmoreListener(layout -> loadData(true));
        mRefreshLayout.setOnRefreshListener(layout -> loadData(false));
        mRecyclerView = findView(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ArticleAdapter(getContext(), new ArrayList<>());
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                String url = mAdapter.getData().get(position).getUrl();
                Bundle bundle = new Bundle();
                bundle.putString(WebActivity.EXTRA_URL, url);
                ActivityUtils.startActivity(bundle, getActivity(), WebActivity.class);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });


        mRecyclerView.setAdapter(mAdapter);
        DI.component(getActivity()).inject(this);
        mPresenter.init(mPresenterManager, this);
        loadData(false);
    }

    private void loadData(boolean next) {
        mPresenter.loadData(next);
    }

    @Override
    public void finishLoadData() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.finishRefresh();
        } else if (mRefreshLayout.isLoading()) {
            mRefreshLayout.finishLoadmore();
        }
    }

    @Override
    public void refreshArticleData(List<GankInfo> data) {
        mAdapter.setData(data);
    }

    @Override
    public void addArticleData(List<GankInfo> data) {
        mAdapter.addData(data);
    }



}
