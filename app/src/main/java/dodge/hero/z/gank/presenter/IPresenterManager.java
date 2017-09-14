package dodge.hero.z.gank.presenter;

/**
 * Created by hyj on 2017/5/6.
 */

public interface IPresenterManager {
    void register(IPresenter presenter);

    void unRegister(IPresenter presenter);

    void start();

    void resume();

    void pause();

    void stop();

    void destroy();
}
