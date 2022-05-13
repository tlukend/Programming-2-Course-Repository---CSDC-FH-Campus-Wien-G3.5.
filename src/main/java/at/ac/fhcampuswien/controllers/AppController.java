package at.ac.fhcampuswien.controllers;

import at.ac.fhcampuswien.api.NewsApi;
import at.ac.fhcampuswien.enums.Country;
import at.ac.fhcampuswien.enums.Endpoint;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.NewsResponse;
import at.ac.fhcampuswien.models.Source;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;

    public AppController() {}

    public void setArticles(List<Article> articles){
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return articles;
    }

    /**
     * gets the size of last fetched articles
     * @return size of article list
     */
    public int getArticleCount(){
        if(articles != null) {
            return articles.size();
        }
        return 0;
    }

    /**
     * get the top headlines from austria via newsapi
     * @return article list
     */
    public List<Article> getTopHeadlinesAustria() {
        NewsApi api = new NewsApi("", Country.at, Endpoint.TOP_HEADLINES);
        NewsResponse response = api.requestData();

        if(response != null){
            articles = response.getArticles();
            return response.getArticles();
        }
        return new ArrayList<>();
    }

    /**
     * returns all articles that do contain "bitcoin"
     * in their title from newsapi
     * @return filtered list
     */
    public List<Article> getAllNewsBitcoin() {
        NewsApi api = new NewsApi("bitcoin", Endpoint.EVERYTHING);
        NewsResponse response = api.requestData();

        if(response != null) {
            articles = response.getArticles();
            return response.getArticles();
        }
        return new ArrayList<>();
    }

    public List<Article> getSourceWithMostArticles() { // unsure Are
        NewsApi api = new NewsApi(null,Endpoint.EVERYTHING);
        NewsResponse response = api.requestData();
        return new ArrayList<>();
    }

    public List<Article> getAuthorWithLongestName() {
        NewsApi api = new NewsApi("", Country.at, Endpoint.EVERYTHING);
        NewsResponse response = api.requestData();

        if(response != null){
            articles = response.getArticles();
            return response.getArticles();
        }
        return new ArrayList<>();
    }
    /*

    public List<Article> getAllHeadlinesWithLessThan15Signs(List<Article> articles){
        char titles =
        List<Article> under15 = getArticles().stream().filter(e -> toString().charAt(.getTitle()) < 15 ;)
    }

    //Are

    //Welcher Provider (= Source) liefert die meisten Artikel?
    //duplicat definieren / variable die das speichert und dann schauen wer am meisten hat

    public List<String> distinctElements = getTopHeadlinesAustria().stream()
            .distinct()
            .collect(Collectors.toList())


    public static void duplicate(AppController controller) {
    }
    public List duplicate (List <Source> sources){
        for (int i = 0; i<getArticleCount();i++){
            for (int j = i+1; j < getArticleCount(); j++) {
                if (sources.get(i) == sources.get(j)){
                    new ArrayList<Source>().add(sources.get(i));
                }
            }new ArrayList<Source>().size();
        }
        return sources;
    }
    List<Article> sourceWithMostArticles = articles.stream()
            .filter(source -> source.()
            .filter(name->name.startsWith("A"))
            .collect(Collectors.toList());
            System.out.println(sourceWithMostArticles);
           */
    /**
     * filters a given article list based on a query
     * @param query to filter by
     * @param articles  list to filter
     * @return filtered list
     */
    private static List<Article> filterList(String query, List<Article> articles){
        List<Article> filtered = new ArrayList<>();
        for(Article i : articles){
            if(i.getTitle().toLowerCase().contains(query)){
                filtered.add(i);
            }
        }
        return filtered;
    }
}
