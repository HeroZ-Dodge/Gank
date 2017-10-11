package dodge.hero.z.gank.data.preferences;

import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences2.Preference;

import dodge.hero.z.gank.util.JsonParser;
import dodge.hero.z.gank.util.JsonType;

/**
 * Created by Linzheng on 2017/9/26.
 * <br>Email:linzheng@aipai.com</br>
 */


public class GsonPreferenceAdapter<T> implements Preference.Converter<T> {

    private Class<T> mClass;
    private JsonType<T> mJsonType;

    public GsonPreferenceAdapter(Class<T> aClass) {
        mClass = aClass;
    }

    public GsonPreferenceAdapter(JsonType<T> jsonType) {
        mJsonType = jsonType;
    }

    @NonNull
    public T deserialize(@NonNull String serialized) {
        if (mClass != null) {
            return JsonParser.fromJson(serialized, mClass);
        } else {
            return JsonParser.fromJson(serialized, mJsonType);
        }
    }

    @NonNull
    public String serialize(@NonNull T value) {
        return JsonParser.toJson(value);
    }
}
