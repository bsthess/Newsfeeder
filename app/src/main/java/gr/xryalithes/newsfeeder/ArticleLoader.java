package gr.xryalithes.newsfeeder;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    /** Tag for log messages */
    private static final String LOG_TAG = ArticleLoader.class.getName();

    /** Query URL */
    private String mUrl;


    public ArticleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }


        List<Article> articles = JsonFactory.fetchArticleData(mUrl);
        return articles;
    }
}