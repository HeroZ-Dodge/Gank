package dodge.hero.z.gank.data.database;

import android.content.Context;

import com.blankj.utilcode.util.LogUtils;

import org.greenrobot.greendao.database.Database;

import dodge.hero.z.gank.dao.DaoMaster;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GankDbOpenHelper extends DaoMaster.DevOpenHelper {

    private static final String TAG = "GankDbOpenHelper";
    private static final String SCHEMA_NAME = "gank_db";

    public GankDbOpenHelper(Context context) {
        super(context, SCHEMA_NAME);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
        LogUtils.d(TAG, "创建数据库");
    }


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        LogUtils.d(TAG, "更新数据库");
    }
}
