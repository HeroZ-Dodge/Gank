package dodge.hero.z.gank;

import android.app.Application;

import dodge.hero.z.gank.di.DI;

/**
 * Created by Linzheng on 2017/9/28.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GankApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DI.init(this);
    }
}
