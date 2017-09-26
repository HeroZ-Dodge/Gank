package dodge.hero.z.gank.data.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

/**
 * Created by Linzheng on 2017/9/26.
 * <br>Email:linzheng@aipai.com</br>
 */

public class PreferencesRepository implements IPreferencesRepository {

    RxSharedPreferences mRxPreferences;

    public PreferencesRepository(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        mRxPreferences = RxSharedPreferences.create(preferences);
    }


    @Override
    public int getInt(String key) {
        return mRxPreferences.getInteger(key).get();
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return mRxPreferences.getInteger(key, defaultValue).get();
    }

    @Override
    public long getLong(String key) {
        return mRxPreferences.getLong(key).get();
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return mRxPreferences.getLong(key, defaultValue).get();
    }

    @Override
    public String getString(String key) {
        return mRxPreferences.getString(key).get();
    }

    @Override
    public String getString(String key, String defaultValue) {
        return mRxPreferences.getString(key, defaultValue).get();
    }

    @Override
    public boolean getBoolean(String key) {
        return mRxPreferences.getBoolean(key).get();
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return mRxPreferences.getBoolean(key, defaultValue).get();
    }

    @Override
    public <T> T getValue(String key, T defaultValue) {
        Preference.Converter<T> converter = new GsonPreferenceAdapter<T>(defaultValue.getClass());
        return mRxPreferences.getObject(key, defaultValue, converter).get();
    }

}
