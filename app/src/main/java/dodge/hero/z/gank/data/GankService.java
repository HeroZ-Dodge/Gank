package dodge.hero.z.gank.data;

import dodge.hero.z.gank.data.model.GankInfo;
import dodge.hero.z.gank.data.model.GankResponse;
import dodge.hero.z.gank.data.model.GirlImage;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Linzheng on 2017/9/9.
 * <br>Email:linzheng@aipai.com</br>
 */

public interface GankService {


    @GET("data/福利/10/{page}")
    Observable<GankResponse<GirlImage>> getGirlList(@Path("page") int page);

    @GET("data/{type}/{page_size}/{page}")
    Observable<GankResponse<GankInfo>> loadData(@Path("type") String type,
                                                @Path("page_size") int pageSize,
                                                @Path("page") int page);


}
