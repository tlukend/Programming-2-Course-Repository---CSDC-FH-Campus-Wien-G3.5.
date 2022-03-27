package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> Articles;
    List<Article> TopHeadlinesAustria = new ArrayList<>();
    List<Article> filterList = new ArrayList<>();
    String query = "Bitcoin";

    private static List<Article> generateMocklist() {
        ArrayList<Article> mock = new ArrayList<>();
        Article a01 = new Article("Margarete Stokowski", "Finger weg von den Frauen!");
        Article a02 = new Article("Melisa Erkurt", "Reiche Eltern für alle!");
        Article a03 = new Article("Melina Borcak", "Keine Strafe hoch genug");
        Article a04 = new Article("Melina Borcak", "Das weiße Band der Schande");
        mock.add(a01);
        mock.add(a02);
        mock.add(a03);
        mock.add(a04);

        return mock;
    }


    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    public int getArticleCount() {
        if (Article.count >= 1)
            return Article.count;
        else return 0;
    }

    public List<Article> getTopHeadlinesAustria() {
        if (getTopHeadlinesAustria().isEmpty()) {
            Collections.emptyList();
        }
        return TopHeadlinesAustria;
    }

    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin", generateMocklist());
        //arbeiten
    }

//Hier stimmt was nicht
    protected static List<Article> filterList(String query, List<Article> articles) {
        query.toLowerCase();
        articles.stream().filter(c -> c.getTitle().toLowerCase().contains(query)).collect(Collectors.toList());
        return articles;

        //articles.stream().filter((b) -> articles.contains(query));
    }
}
