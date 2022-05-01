package at.ac.fhcampuswien;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;

    public AppController(){
        articles = generateMocklist();
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
        return newsApi.everything("bitcoin").getArticles();
        //return filterList("bitcoin", newsApi.getNewsResponse().getArticles());
    }

    protected static List<Article> filterList(String query, List<Article> articles) {
        query = query.toLowerCase();
        String finalQuery = query;
        return articles.stream().filter(e -> e.getTitle().toLowerCase().contains(finalQuery)).collect(Collectors.toList());
    }
    // stream = relativ neue Methode - filtert in eine liste, die gleichzeitig die Rückgabeliste ist
    // toLowerCase, damit Groß- und Kleinschreibung egal ist - deshalb alles in klein zum Vergleichen

    private static List<Article> generateMocklist() {
        ArrayList<Article> mock = new ArrayList<>();
        Article a01 = new Article("Margarete Stokowski", "Finger weg von den Frauen!");
        Article a02 = new Article("Melisa Erkurt", "Reiche Eltern für alle!");
        Article a03 = new Article("Melina Borcak", "Keine Strafe hoch genug.");
        Article a04 = new Article("Melina Borcak", "Das weiße Band der Schande.");
        mock.add(a01);
        mock.add(a02);
        mock.add(a03);
        mock.add(a04);

        return mock;
    }




}
