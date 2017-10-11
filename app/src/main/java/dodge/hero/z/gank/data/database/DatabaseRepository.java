package dodge.hero.z.gank.data.database;

import java.util.List;
import java.util.UUID;

import dodge.hero.z.gank.dao.DaoSession;
import dodge.hero.z.gank.data.model.Collection;

/**
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */

public class DatabaseRepository {

    private DaoSession mDaoSession;

    public DatabaseRepository(DaoSession daoSession) {
        mDaoSession = daoSession;
    }


    public List<Collection> loadAllCollections() {
        return mDaoSession.getCollectionDao()
                .loadAll();
    }

    public long collectionCount() {
        return mDaoSession.getCollectionDao()
                .count();
    }

    public boolean createCollection(String name) {
        Collection collection = new Collection();
        collection.setName(name);
        collection.setUuid(UUID.randomUUID().toString());
        try {
            mDaoSession.getCollectionDao().save(collection);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveCollection(Collection collection) {
        try {
            mDaoSession.getCollectionDao().saveInTx(collection);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCollection(Collection collection) {
        try {
            mDaoSession.delete(collection);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
