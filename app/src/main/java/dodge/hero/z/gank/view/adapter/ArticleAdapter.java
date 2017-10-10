package dodge.hero.z.gank.view.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.view.adapter.base.CommonAdapter;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public class ArticleAdapter extends CommonAdapter<GankInfo> {


    public ArticleAdapter(Context context, List<GankInfo> data) {
        super(context, R.layout.gank_item_article, data);
    }

    @Override
    protected void convert(ViewHolder holder, GankInfo gankInfo, int position) {
        holder.setText(R.id.tv_desc, gankInfo.getDesc());
        holder.setText(R.id.tv_date, gankInfo.getPublishedAt());
    }

}
