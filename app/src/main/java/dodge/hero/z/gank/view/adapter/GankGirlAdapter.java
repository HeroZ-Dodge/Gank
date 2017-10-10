package dodge.hero.z.gank.view.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.component.image.GlideApp;
import dodge.hero.z.gank.data.model.GankInfo;

/**
 * Created by Linzheng on 2017/9/15.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GankGirlAdapter extends CommonAdapter<GankInfo> {

    public GankGirlAdapter(Context context, int layoutId, List<GankInfo> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(ViewHolder holder, GankInfo girlImage, int position) {
        GlideApp.with(mContext).load(girlImage.getUrl())
                .centerCrop()
                .into((ImageView) holder.getView(R.id.iv_girl));
    }
}
