package at.ac.fhcampuswien;

import javafx.scene.control.Hyperlink;

import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;


    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

}
