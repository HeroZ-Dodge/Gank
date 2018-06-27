package dodge.hero.z.gank.view.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.component.image.GlideApp;
import dodge.hero.z.gank.data.ColorGenerator;
import dodge.hero.z.gank.data.model.GankInfo;

/**
 * Created by linzheng on 2018/6/27.
 */

public class ArticleWithImgDelegate implements ItemViewDelegate<GankInfo> {

    private Context mContext;

    public ArticleWithImgDelegate(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.gank_item_article_with_img;
    }

    @Override
    public boolean isForViewType(GankInfo item, int position) {
        return item.getImages() != null && !item.getImages().isEmpty();
    }

    @Override
    public void convert(ViewHolder holder, GankInfo gankInfo, int position) {
        holder.setText(R.id.tv_desc, gankInfo.getDesc());
        if (TextUtils.isEmpty(gankInfo.getPublishedAt())) {
            holder.setText(R.id.tv_date, "");
        } else {
            String[] dates = gankInfo.getPublishedAt().split("T");
            holder.setText(R.id.tv_date, dates.length > 0 ? dates[0] : "");
        }
        holder.setImageDrawable(R.id.iv_bg, new ColorDrawable(ColorGenerator.generator()));
        if (gankInfo.getImages() != null && !gankInfo.getImages().isEmpty()) {
            GlideApp.with(mContext).load(gankInfo.getImages().get(0))
                    .centerCrop()
                    .into((ImageView) holder.getView(R.id.iv_type));
        } else {
            holder.setImageDrawable(R.id.iv_type, new ColorDrawable(ColorGenerator.COLOR_2));
        }
    }

}
