package dodge.hero.z.gank.di.component;

import android.app.Application;
import android.content.Context;

import dagger.Component;
import dodge.hero.z.gank.data.GankService;
import dodge.hero.z.gank.data.sp.IPreferencesRepository;
import dodge.hero.z.gank.di.scope.ForApp;
import dodge.hero.z.gank.di.module.ContextModule;
import dodge.hero.z.gank.di.module.DataModule;

/**
 * Created by Linzheng on 2017/9/28.
 * <br>Email:linzheng@aipai.com</br>
 */
@ForApp
@Component(modules = {
        ContextModule.class,
        DataModule.class
})
public interface AppComponent {

    Application application();

    Context context();

    IPreferencesRepository preferencesRepository();

    GankService gankService();
}
