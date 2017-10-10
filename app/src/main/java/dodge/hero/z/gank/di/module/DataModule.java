package dodge.hero.z.gank.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import dodge.hero.z.gank.data.GankService;
import dodge.hero.z.gank.data.sp.IPreferencesRepository;
import dodge.hero.z.gank.data.sp.PreferencesRepository;
import dodge.hero.z.gank.di.scope.ForApp;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
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



}
