package dodge.hero.z.gank.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Linzheng on 2017/9/28.
 * <br>Email:linzheng@aipai.com</br>
 */

public class JsonParser {

    private static Gson mGson;

    private static Gson getGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
        return mGson;
    }

    public static String toJson(Object object) {
        return getGson().toJson(object);
    }

    public static <T> T fromJson(String json, JsonType<T> jsonType) {
        ParameterizedType parameterizedType = (ParameterizedType) jsonType.getClass().getGenericInterfaces()[0];
        Type type = parameterizedType.getActualTypeArguments()[0];
        T t = null;
        try {
            t = getGson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T fromJson(String json, TypeToken<T> typeToken) {
        T t = null;
        try {
            t = getGson().fromJson(json, typeToken.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


    public static <T> T fromJson(String json, Class<T> clazz) {
        return getGson().fromJson(json, clazz);
    }

}
