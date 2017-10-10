package dodge.hero.z.gank.di.component;

import android.app.Activity;

import dagger.Component;
import dodge.hero.z.gank.di.scope.ForActivity;
import dodge.hero.z.gank.di.module.ActivityModule;
import dodge.hero.z.gank.view.fragment.ArticleFragment;
import dodge.hero.z.gank.view.fragment.GirlListFragment;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */

@ForActivity
@Component(dependencies = AppComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent extends AppComponent {

    Activity activity();

    void inject(ArticleFragment fragment);
    void inject(GirlListFragment fragment);

}
