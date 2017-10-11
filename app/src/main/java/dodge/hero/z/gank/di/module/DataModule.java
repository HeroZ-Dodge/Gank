package dodge.hero.z.gank.di.module;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import dagger.Module;
import dagger.Provides;
import dodge.hero.z.gank.dao.DaoMaster;
import dodge.hero.z.gank.dao.DaoSession;
import dodge.hero.z.gank.data.http.GankService;
import dodge.hero.z.gank.data.database.DatabaseRepository;
import dodge.hero.z.gank.data.database.GankDbOpenHelper;
import dodge.hero.z.gank.data.preferences.IPreferencesRepository;
import dodge.hero.z.gank.data.preferences.PreferencesRepository;
import dodge.hero.z.gank.di.scope.ForApp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 数据层 Module
 * Created by Linzheng on 2017/9/28.
 * <br>Email:linzheng@aipai.com</br>
 */
@Module
public class DataModule {

    @ForApp
    @Provides
    public IPreferencesRepository preferencesRepository(Context context) {
        return new PreferencesRepository(context);
    }

    @ForApp
    @Provides
    public GankService gankService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build().create(GankService.class);
    }

    @ForApp
    @Provides
    public DatabaseRepository dbRepository(Context context) {
        GankDbOpenHelper openHelper = new GankDbOpenHelper(context);
        Database database = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        return new DatabaseRepository(daoSession);
    }

}
