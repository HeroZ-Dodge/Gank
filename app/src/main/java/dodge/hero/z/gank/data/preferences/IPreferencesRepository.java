package dodge.hero.z.gank.data.preferences;

import dodge.hero.z.gank.util.JsonType;
import io.reactivex.Observable;

/**
 * Created by Linzheng on 2017/9/26.
 * <br>Email:linzheng@aipai.com</br>
 */

public interface IPreferencesRepository {

    void setValue(String key, int value);

    int getInt(String key);

    int getInt(String key, int defaultValue);

    void setValue(String key, long value);

    long getLong(String key);

    long getLong(String key, long defaultValue);

    void setValue(String key, String value);

    String getString(String key);

    String getString(String key, String defaultValue);

    void setValue(String key, boolean value);

    boolean getBoolean(String key);

    boolean getBoolean(String key, boolean defaultValue);

    <T> void setValue(String key, T value, Class<T> clazz);

    <T> void setValue(String key, T value, JsonType<T> jsonType);

    <T> T getValue(String key, T defaultValue, Class<T> clazz);

    <T> T getValue(String key, T defaultValue, JsonType<T> jsonType);

    <T> Observable<T> getValueRx(String key, T defaultValue, JsonType<T> jsonType);
}
