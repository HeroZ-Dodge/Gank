package dodge.hero.z.gank.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import dodge.hero.z.gank.di.scope.ForActivity;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ForActivity
    public Activity getActivity() {
        return this.mActivity;
    }

}
