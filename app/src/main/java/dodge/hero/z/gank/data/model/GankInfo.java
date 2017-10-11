package dodge.hero.z.gank.data.model;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;

import dodge.hero.z.gank.data.database.StringListPropertyConverter;

/**
 * Created by Linzheng on 2017/10/10.
 * <br>Email:linzheng@aipai.com</br>
 */
@Entity
public class GankInfo {


    /**
     * _id : 59dc4dd0421aa94e07d1848e
     * createdAt : 2017-10-10T12:34:24.701Z
     * desc : Android 展开型布局菜单。
     * images : ["http://img.gank.io/b39a4adf-b48a-4f2e-990f-b672027bf643","http://img.gank.io/a7b25e90-63ba-4703-bd6c-dc4483fa5172"]
     * publishedAt : 2017-10-10T12:41:34.882Z
     * source : chrome
     * type : Android
     * url : https://github.com/iammert/ScalingLayout
     * used : true
     * who : 代码家
     */
    @Id(autoincrement = true)
    private Long pkId;
    @Index
    private String collectionId; // 收藏夹的id
    @Property(nameInDb = "gank_Id")
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    @Convert(converter = StringListPropertyConverter.class, columnType = String.class)
    private List<String> images;

    @Generated(hash = 1495558386)
    public GankInfo(Long pkId, String collectionId, String _id, String createdAt, String desc, String publishedAt, String source,
            String type, String url, boolean used, String who, List<String> images) {
        this.pkId = pkId;
        this.collectionId = collectionId;
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.publishedAt = publishedAt;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
        this.images = images;
    }

    @Generated(hash = 1682206697)
    public GankInfo() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Long getPkId() {
        return this.pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getCollectionId() {
        return this.collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public boolean getUsed() {
        return this.used;
    }
}
