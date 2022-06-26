package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.Exception.NewsAPIException;
import at.ac.fhcampuswien.controllers.AppController;
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
    private static final NewsApi instance = new NewsApi();
    public static NewsApi getInstance() {
        return instance;
    }

    private final OkHttpClient client;

    private NewsApi() { // es werden keine Parameter außer Builder  Objekt benötigt
        this.client = new OkHttpClient();
    }


    public NewsResponse requestData(Request request) throws NewsAPIException {
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