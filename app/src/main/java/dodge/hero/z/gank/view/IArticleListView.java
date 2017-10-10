package dodge.hero.z.gank.view;

import java.util.List;

import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.view.abstrac.IExpansionView;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

public interface IArticleListView extends IExpansionView {

    void finishLoadData();

    void showArticle(List<GankInfo> data);


}
