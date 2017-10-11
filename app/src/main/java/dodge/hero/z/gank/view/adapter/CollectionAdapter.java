package dodge.hero.z.gank.view.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import dodge.hero.z.gank.R;
import dodge.hero.z.gank.data.model.Collection;
import dodge.hero.z.gank.view.adapter.base.CommonAdapter;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class CollectionAdapter extends CommonAdapter<Collection> {

    public CollectionAdapter(Context context, List<Collection> data) {
        super(context, R.layout.gank_item_my_collection, data);
    }

    @Override
    protected void convert(ViewHolder holder, Collection collection, int position) {

    }
}
