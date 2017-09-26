package dodge.hero.z.gank.data.sp;

import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences2.Preference;
import com.google.gson.Gson;

/**
 * Created by Linzheng on 2017/9/26.
 * <br>Email:linzheng@aipai.com</br>
 */


public class GsonPreferenceAdapter<T> implements Preference.Converter<T> {

    private Class<T> clazz;

    public GsonPreferenceAdapter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @NonNull
    public T deserialize(@NonNull String serialized) {
        Gson gson = new Gson();
        return gson.fromJson(serialized, clazz);
    }

    @NonNull
    public String serialize(@NonNull T value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }
}
