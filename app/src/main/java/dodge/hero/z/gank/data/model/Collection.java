package dodge.hero.z.gank.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 收藏夹
 * Created by Linzheng on 2017/10/11.
 * <br>Email:linzheng@aipai.com</br>
 */
@Entity
public class Collection {

    @Id(autoincrement = true)
    private Long pkId;
    @Unique
    private String uuid;
    private String name;
    private String desc;
    private int bgColor;    // 背景颜色
    private int bgRes;      // 背景资源颜色
    @Generated(hash = 1907987598)
    public Collection(Long pkId, String uuid, String name, int bgColor, int bgRes) {
        this.pkId = pkId;
        this.uuid = uuid;
        this.name = name;
        this.bgColor = bgColor;
        this.bgRes = bgRes;
    }
    @Generated(hash = 1149123052)
    public Collection() {
    }
    public Long getPkId() {
        return this.pkId;
    }
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBgColor() {
        return this.bgColor;
    }
    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
    public int getBgRes() {
        return this.bgRes;
    }
    public void setBgRes(int bgRes) {
        this.bgRes = bgRes;
    }

}
