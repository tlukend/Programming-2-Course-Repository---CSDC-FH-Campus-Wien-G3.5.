package at.ac.fhcampuswien;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {

    private final String apiKey;
    private static final String URL_EVERYTHING = "https://newsapi.org/v2/everything?q=";
    private static final String URL_TOPHEADLINES = "https://newsapi.org/v2/top-headlines?country="; //url von newsApi hinzugefuegt, weil es zwei gibt als eigene Variable hinzugefügt
    private NewsResponse newsResponse;

    public NewsApi(String key)
    {
        this.apiKey = key;
    }

    public NewsResponse everything(String keyword) {
        String target = URL_EVERYTHING + keyword + "&apiKey=" + apiKey;
        try {
            String json = run(target);
            newsResponse = transform(json);
        } catch (IOException ioe) {

        }
        return newsResponse;
    }
    // wir wandeln den gson string in ein Objekt um.
    public NewsResponse transform(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, NewsResponse.class);
    }

    public NewsResponse topHeadlines() { //man klickt die url und man muss daraus senden.
        String country = "at";
        // category ...
        String target = URL_TOPHEADLINES + country + "&apiKey=" + apiKey;
        try {
            String json = run(target);
            newsResponse = transform(json);

        } catch (IOException ioe) {

        }
        return newsResponse;
    }
    /*

    public static void main(String[] args) {
//        try {
        NewsApi newsApi = new NewsApi();
        newsApi.everything("Ukraine");
        System.out.println(newsApi.getNewsResponse().getTotalResults());


            /*
            String json=run("https://newsapi.org/v2/everything?q=bitcoin&apiKey=f970a93f427c449d8a61d53e717fc78c");

            Gson gson = new Gson();
            NewsResponse newsResponse = gson.fromJson(json, NewsResponse.class);

            System.out.println(newsResponse.status);
            System.out.println(newsResponse.totalResults);
            System.out.println(newsResponse.articles);
*/

        //System.out.println(run("https://newsapi.org/v2/everything?q=bitcoin&apiKey=f970a93f427c449d8a61d53e717fc78c")); //url sollte dynamisch generiert werden können
      /*  } catch (IOException e) {
            System.out.println("ERROR");
        }

       */


    public static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public NewsResponse getNewsResponse() {
    return newsResponse;
    }



}
