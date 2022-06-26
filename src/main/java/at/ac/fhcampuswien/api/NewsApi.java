package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.Exception.NewsAPIException;
import at.ac.fhcampuswien.models.NewsResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class NewsApi {
    public static final String DELIMITER = "&";
    private static final String URL = "https://newsapi.org/v2/%s?q=%s&apiKey=%s";
    private static final String API_KEY = Dotenv.load().get("API_TOKEN");   // read token from .env file -> add .env to .gitignore!!!
    private final OkHttpClient client;
    private final Builder builder;

    public NewsApi(Builder builder) {
        this.client = new OkHttpClient();
        this.builder = builder;
    }

    private String buildUrl() {
        String baseurl = String.format(URL, builder.getEndpoint().getValue(), builder.getQ(), API_KEY);

        StringBuilder sb = new StringBuilder(baseurl);

        if (builder.getFrom() != null) {
            sb.append(DELIMITER).append("from=").append(builder.getFrom());
        }
        if (builder.getTo() != null) {
            sb.append(DELIMITER).append("to=").append(builder.getTo());
        }
        if (builder.getPage() != null) {
            sb.append(DELIMITER).append("page=").append(builder.getPage());
        }
        if (builder.getPageSize() != null) {
            sb.append(DELIMITER).append("pageSize=").append(builder.getPageSize());
        }
        if (builder.getLanguage() != null) {
            sb.append(DELIMITER).append("language=").append(builder.getLanguage());
        }
        if (builder.getSourceCountry() != null) {
            sb.append(DELIMITER).append("country=").append(builder.getSourceCountry());
        }
        if (builder.getSourceCategory() != null) {
            sb.append(DELIMITER).append("category=").append(builder.getSourceCategory());
        }
        if (builder.getDomains() != null) {
            sb.append(DELIMITER).append("domains=").append(builder.getDomains());
        }
        if (builder.getExcludeDomains() != null) {
            sb.append(DELIMITER).append("excludeDomains=").append(builder.getExcludeDomains());
        }
        if (builder.getqInTitle() != null) {
            sb.append(DELIMITER).append("qInTitle=").append(builder.getqInTitle());
        }
        if (builder.getSortBy() != null) {
            sb.append(DELIMITER).append("sortBy=").append(builder.getSortBy().getValue());
        }

        return sb.toString();
    }

    public NewsResponse requestData() throws NewsAPIException {
        String url = buildUrl();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {   // try with resources syntax
            Gson gson = new Gson();
            NewsResponse apiResponse = gson.fromJson(Objects.requireNonNull(response.body()).string(), NewsResponse.class); // parse the json response to NewsResponse

            if (apiResponse.getStatus().equals("ok")) {   // http status code ok - 200
                return apiResponse;
            } else {
                throw new NewsAPIException("The status sent from the server was not okay!");
            }
        } catch (NewsAPIException e) {
            throw e;
        } catch (JsonSyntaxException e) {
            throw new NewsAPIException("The response from the server did not have the right format!", e);
        } catch (IOException e) {
            throw new NewsAPIException("The request to the server failed!", e);
        } catch (IllegalStateException e) {
            throw new NewsAPIException("The request has already been sent!", e);
        } catch (NullPointerException e) {
            throw new NewsAPIException("The response was empty!", e);
        } catch (Exception e) {
            throw new NewsAPIException(e);
        }
    }
}