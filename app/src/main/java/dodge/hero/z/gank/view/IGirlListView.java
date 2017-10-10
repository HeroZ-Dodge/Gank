package dodge.hero.z.gank.view;

import java.util.List;

import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.view.abstrac.IExpansionView;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public interface IGirlListView extends IExpansionView {

    void finishLoadData();


    void refreshData(List<GankInfo> data);

    void addData(List<GankInfo> data);


}
