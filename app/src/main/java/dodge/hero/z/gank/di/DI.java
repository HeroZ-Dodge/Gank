package dodge.hero.z.gank.di;

import android.app.Activity;
import android.app.Application;

import dodge.hero.z.gank.data.database.DatabaseRepository;
import dodge.hero.z.gank.data.preferences.IPreferencesRepository;
import dodge.hero.z.gank.di.component.ActivityComponent;
import dodge.hero.z.gank.di.component.AppComponent;
import dodge.hero.z.gank.di.component.DaggerActivityComponent;
import dodge.hero.z.gank.di.component.DaggerAppComponent;
import dodge.hero.z.gank.di.module.ActivityModule;
import dodge.hero.z.gank.di.module.ContextModule;

/**
 * Created by Linzheng on 2017/9/28.
 * <br>Email:linzheng@aipai.com</br>
 */

public class DI {

    private static AppComponent appComponent;


    public static void init(Application application) {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .contextModule(new ContextModule(application))
                    .build();
        }
    }

    public static ActivityComponent component(Activity activity) {
        return DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(activity))
                .build();
    }


    public static IPreferencesRepository preferencesRepository() {
        return appComponent.preferencesRepository();
    }

    public static DatabaseRepository dbRepository() {
        return appComponent.dbRepository();
    }


}
