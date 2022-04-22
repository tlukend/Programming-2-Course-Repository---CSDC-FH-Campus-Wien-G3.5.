package at.ac.fhcampuswien;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {

    public static void main(String[] args) {
        try {
         System.out.println(run("https://newsapi.org/v2/everything?q=bitcoin&apiKey= f970a93f427c449d8a61d53e717fc78c")); //url sollte dynamisch generiert werden können
        }catch (IOException e){
        System.out.println("ERROR");
        }
    }
    public static String run(String url)throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url(url)
            .build();

  try (Response response = client.newCall(request).execute()) {
        return response.body().string();
    }
    
}
}
