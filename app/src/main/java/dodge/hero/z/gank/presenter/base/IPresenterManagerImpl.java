package dodge.hero.z.gank.presenter.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyj on 2017/5/6.
 */

public class IPresenterManagerImpl implements IPresenterManager {

    private List<IPresenter> mPresenters = new ArrayList<>();

    @Override
    public void register(IPresenter presenter) {
        if (!mPresenters.contains(presenter)) {
            mPresenters.add(presenter);
        }
    }

    @Override
    public void unRegister(IPresenter presenter) {
        mPresenters.remove(presenter);
    }

    @Override
    public void start() {
        foreachPresenter(IPresenter::onStart, true);
    }

    @Override
    public void resume() {
        foreachPresenter(IPresenter::onResume, false);
    }

    @Override
    public void pause() {
        foreachPresenter(IPresenter::onPause, true);
    }

    @Override
    public void stop() {
        foreachPresenter(IPresenter::onStop, true);
    }

    @Override
    public void destroy() {
        foreachPresenter(IPresenter::onDestroy, true);
    }

    private void foreachPresenter(Consumer<IPresenter> consumer, boolean reverse) {
        int start = 0;
        int end = mPresenters.size();
        int step = 1;
        if (reverse) {
            start = mPresenters.size() - 1;
            step = -1;
            end = -1;
        }
        while (start != end) {
            consumer.accept(mPresenters.get(start));
            start += step;
        }
    }

    interface Consumer<T> {
        void accept(T t);
    }
}
