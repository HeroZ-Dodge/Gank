package dodge.hero.z.gank.view.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.SparseIntArray;
import android.widget.ImageView;

import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.component.image.GlideApp;
import dodge.hero.z.gank.data.ColorGenerator;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.view.adapter.base.CommonAdapter;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public class ArticleAdapter extends CommonAdapter<GankInfo> {

    private SparseIntArray mColorArray = new SparseIntArray();

    public ArticleAdapter(Context context, List<GankInfo> data) {
        super(context, R.layout.gank_item_article, data);
    }

    @Override
    protected void convert(ViewHolder holder, GankInfo gankInfo, int position) {
        holder.setText(R.id.tv_desc, gankInfo.getDesc());
        holder.setText(R.id.tv_date, gankInfo.getPublishedAt());
        if (mColorArray.indexOfKey(position) < 0) {
            mColorArray.put(position, ColorGenerator.generator());
        }
        holder.setImageDrawable(R.id.iv_bg, new ColorDrawable(mColorArray.get(position)));
        if (gankInfo.getImages() != null && !gankInfo.getImages().isEmpty()) {
            GlideApp.with(mContext).load(gankInfo.getImages().get(0))
                    .centerCrop()
                    .into((ImageView) holder.getView(R.id.iv_type));
        } else {
            holder.setImageDrawable(R.id.iv_type, new ColorDrawable(ColorGenerator.COLOR_2));
        }
    }

}
