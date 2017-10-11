package dodge.hero.z.gank.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import dodge.hero.z.gank.util.JsonType;

/**
 * Created by Linzheng on 2017/9/26.
 * <br>Email:linzheng@aipai.com</br>
 */

public class PreferencesRepository implements IPreferencesRepository {

    private RxSharedPreferences mRxPreferences;

    public PreferencesRepository(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        mRxPreferences = RxSharedPreferences.create(preferences);
    }

    @Override
    public void setValue(String key, int value) {
        mRxPreferences.getInteger(key).set(value);
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
    public void setValue(String key, long value) {
        mRxPreferences.getLong(key).set(value);
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
    public void setValue(String key, String value) {
        mRxPreferences.getString(key).set(value);
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
    public void setValue(String key, boolean value) {
        mRxPreferences.getBoolean(key).set(value);
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
    public <T> void setValue(String key, T value, Class<T> clazz) {
        Preference.Converter<T> converter = new GsonPreferenceAdapter<>(clazz);
        mRxPreferences.getString(key).set(converter.serialize(value));
    }

    @Override
    public <T> void setValue(String key, T value, JsonType<T> jsonType) {
        Preference.Converter<T> converter = new GsonPreferenceAdapter<>(jsonType);
        mRxPreferences.getString(key).set(converter.serialize(value));
    }

    @Override
    public <T> T getValue(String key, T defaultValue, Class<T> clazz) {
        Preference.Converter<T> converter = new GsonPreferenceAdapter<>(clazz);
        return mRxPreferences.getObject(key, defaultValue, converter).get();
    }

    @Override
    public <T> T getValue(String key, T defaultValue, JsonType<T> jsonType) {
        Preference.Converter<T> converter = new GsonPreferenceAdapter<>(jsonType);
        return mRxPreferences.getObject(key, defaultValue, converter).get();
    }


}
