package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;

    public AppController(){

    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    NewsApi newsApi = new NewsApi("f970a93f427c449d8a61d53e717fc78c");

    public int getArticleCount() {
        if (newsApi.getNewsResponse() == null)
            return 0;
        else return newsApi.getNewsResponse().getTotalResults();
    }

    public List<Article> getTopHeadlinesAustria() {
        newsApi.topHeadlines();
        if (newsApi.getNewsResponse() == null) {

            return new ArrayList<Article>();
        }
        return newsApi.getNewsResponse().getArticles();
    }

    public List<Article> getAllNewsBitcoin() {
        return newsApi.everything("bitcoin", Language.any).getArticles();
    }
    // stream = relativ neue Methode - filtert in eine liste, die gleichzeitig die Rückgabeliste ist
    // toLowerCase, damit Groß- und Kleinschreibung egal ist - deshalb alles in klein zum Vergleichen
    protected static List<Article> filterList(String query, List<Article> articles) {
        query = query.toLowerCase();
        String finalQuery = query;
        return articles.stream().filter(e -> e.getTitle().toLowerCase().contains(finalQuery)).collect(Collectors.toList());
    }


}
