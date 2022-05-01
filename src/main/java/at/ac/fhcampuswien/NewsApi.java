package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {

    private final String apiKey;
    private NewsResponse newsResponse;

    public NewsApi(String key) {
        this.apiKey = key;
    }

    private NewsResponse apiCall(Endpoint endpoint, String query, Language language, Country country, SortBy sortBy, Category category) {
        StringBuilder builder = new StringBuilder();
        builder.append(endpoint.getUrl()).append("?apiKey=").append(apiKey);

        if (query.length() > 0) {
            appendQueryParameter(builder, "q", query);
        }
        appendQueryParameter(builder, "pageSize", "5");
        if (language != Language.any) {
            appendQueryParameter(builder, "language", language.name());
        }
        if (country != Country.none) {
            appendQueryParameter(builder, "country", country.name());
        }
        if (sortBy != SortBy.none) {
            appendQueryParameter(builder, "sortBy", sortBy.name());
        }
        if (category != Category.none) {
            appendQueryParameter(builder, "category", category.name());
        }

        String url = builder.toString();
        try {
            String json = run(url);
            newsResponse = transform(json);
        } catch (IOException ioe) {
            System.err.println(ioe); //gibt Fehlermeldung aus
        }
        return newsResponse;
    }

    public NewsResponse everything(String query, Language language) {
        return apiCall(Endpoint.EVERYTHING, query, language, Country.none, SortBy.none, Category.none);
    }

    private StringBuilder appendQueryParameter(StringBuilder builder, String parameter, String value)
    {
        return builder.append("&").append(parameter).append("=").append(value);
    }

    // wir wandeln den gson string in ein Objekt um.
    public NewsResponse transform(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, NewsResponse.class);
    }

    public NewsResponse topHeadlines() { //man klickt die url und man muss daraus senden.
        return apiCall(Endpoint.TOP_HEADLINES, "", Language.any, Country.at, SortBy.none, Category.none);
    }


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
