package dodge.hero.z.gank.view.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.component.image.GlideApp;
import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.view.adapter.base.CommonAdapter;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GankGirlAdapter extends CommonAdapter<GankInfo> {

    public GankGirlAdapter(Context context, List<GankInfo> data) {
        super(context, R.layout.gank_item_girl_image, data);
    }

    @Override
    protected void convert(ViewHolder holder, GankInfo girlImage, int position) {
        GlideApp.with(mContext).load(girlImage.getUrl())
                .centerCrop()
                .into((ImageView) holder.getView(R.id.iv_girl));
    }
}
