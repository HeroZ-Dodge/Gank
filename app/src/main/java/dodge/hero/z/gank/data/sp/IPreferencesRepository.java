package dodge.hero.z.gank.data.sp;

/**
 * Created by Linzheng on 2017/9/26.
 * <br>Email:linzheng@aipai.com</br>
 */

public interface IPreferencesRepository {


    int getInt(String key);

    int getInt(String key, int defaultValue);

    long getLong(String key);

    long getLong(String key, long defaultValue);

    String getString(String key);

    String getString(String key, String defaultValue);

    boolean getBoolean(String key);

    boolean getBoolean(String key, boolean defaultValue);

    <T> T getValue(String key, T defaultValue);



}
