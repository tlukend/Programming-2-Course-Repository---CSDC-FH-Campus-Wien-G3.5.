package at.ac.fhcampuswien;

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

    public int getArticleCount() {
        if (articles == null)
            return 0;
        else return articles.size();
    }

    public List<Article> getTopHeadlinesAustria() {
        if (articles == null) {
            return new ArrayList<Article>();
        }
        return articles;
    }

    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin", articles );
    }

    protected static List<Article> filterList(String query, List<Article> articles) {
        query = query.toLowerCase();
        String finalQuery = query;
        return articles.stream().filter(e -> e.getTitle().toLowerCase().contains(finalQuery)).collect(Collectors.toList());
    }
    // relativ neue Methode - filtert in eine liste, die gleichzeitig die Rückgabeliste ist
    // toLowerCase, damit Groß- und Kleinschreibung egal ist - deshalb alles in klein zum Vergleichen

    private static List<Article> generateMocklist() {
        ArrayList<Article> mock = new ArrayList<>();
        Article a01 = new Article("Margarete Stokowski", "Finger weg von den Frauen!");
        Article a02 = new Article("Melisa Erkurt", "Reiche Eltern für alle!");
        Article a03 = new Article("Melina Borcak", "Keine Strafe hoch genug");
        Article a04 = new Article("Melina Borcak", "Das weiße Band der Bitcoin");
        mock.add(a01);
        mock.add(a02);
        mock.add(a03);
        mock.add(a04);

        return mock;
    }


}
