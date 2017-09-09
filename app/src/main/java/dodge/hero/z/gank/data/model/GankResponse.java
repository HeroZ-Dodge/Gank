package dodge.hero.z.gank.data.model;

import java.util.List;

/**
 * Created by Linzheng on 2017/9/9.
 * <br>Email:linzheng@aipai.com</br>
 */

public class GankResponse<T> {

    private boolean error;

    private List<T> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
