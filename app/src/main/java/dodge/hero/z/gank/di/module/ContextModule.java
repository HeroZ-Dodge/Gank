package dodge.hero.z.gank.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dodge.hero.z.gank.di.scope.ForApp;

/**
 * Created by Linzheng on 2017/9/28.
 * <br>Email:linzheng@aipai.com</br>
 */
@Module
public class ContextModule {

    private Application mApplication;

    public ContextModule(Application application) {
        mApplication = application;
    }

    @ForApp
    @Provides
    public Application getApplication() {
        return mApplication;
    }

    @ForApp
    @Provides
    public Context getApplicationContext() {
        return mApplication.getApplicationContext();
    }

}
