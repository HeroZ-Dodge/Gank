package dodge.hero.z.gank.view.abstrac;

/**
 * Created by Linzheng on 2017/5/24.
 * <br>Email:linzheng@aipai.com</br>
 */

public interface IExpansionView extends IView {

    void progressShow();

    void progressShow(String msg);

    void progressCancel();

    void toast(String msg);

}
