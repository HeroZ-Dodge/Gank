package dodge.hero.z.gank.data.database;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class StringListPropertyConverter implements PropertyConverter<List<String>, String> {

    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        return null;
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        return null;
    }

}
