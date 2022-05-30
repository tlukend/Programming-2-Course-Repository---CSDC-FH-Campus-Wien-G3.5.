package at.ac.fhcampuswien.controllers;
import at.ac.fhcampuswien.api.NewsApi;
import at.ac.fhcampuswien.enums.Country;
import at.ac.fhcampuswien.enums.Endpoint;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.NewsResponse;
import at.ac.fhcampuswien.models.Source;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.*;

public class AppController {
    private List<Article> articles;

    public AppController() {
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    /**
     * gets the size of last fetched articles
     *
     * @return size of article list
     */
    public int getArticleCount() {
        if (articles != null) {
            return articles.size();
        }
        return 0;
    }

    /**
     * get the top headlines from austria via newsapi
     *
     * @return article list
     */
    public List<Article> getTopHeadlinesAustria() {
        NewsApi api = new NewsApi("", Country.at, Endpoint.TOP_HEADLINES);
        NewsResponse response = api.requestData();

        if (response != null) {
            articles = response.getArticles();
            return response.getArticles();
        }
        return new ArrayList<>();
    }

    /**
     * returns all articles that do contain "bitcoin"
     * in their title from newsapi
     *
     * @return filtered list
     */
    public List<Article> getAllNewsBitcoin() {
        NewsApi api = new NewsApi("bitcoin", Endpoint.EVERYTHING);
        NewsResponse response = api.requestData();

        if (response != null) {
            articles = response.getArticles();
            return response.getArticles();
        }
        return new ArrayList<>();
    }
    /*public String getAuthorWithLongestName ( ArrayList<Article> articles) {


    }*/

    public String getSourceWithMostArticles() { // done :)
        if (articles == null) {
            return "no articles found";
        } else {
            return articles
                    .stream()
                    .map(article -> article.getSource().getName())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get().getKey();

            //collect.(Collectors.groupingBy())


                //    .max(Comparator.comparing(article -> article.getSource().getName()))
                //    .get().getSource().getName();
        }
    }


      //welcher Provider und welcher Autor hat den nächsten Namen haben wir gelöst
    public String getAuthorWithLongestName() {
        if (articles == null) {
            return "no authors found";
        } else {
            return (String) articles
                    .stream()
                    .max(Comparator.comparing(article -> article.getAuthor().length()))
                    .get().getAuthor();
        }
    }

    public int getNewYorkTimesArticleCount() {
        if (articles == null) {
            return 0;
        } else {
            return (int) articles
                    .stream()
                    .filter(article -> article
                            .getSource()
                            .getName()
                            .toLowerCase()
                            .contains("new york times"))
                    .count();
        }
    }


    public List<Article> getArticlesUnder15() {
        if (articles == null){
            return new ArrayList<>();
        }
        else {
            return articles
                    .stream()
                    .filter(article -> article
                            .getTitle()
                            .length() < 15).collect(Collectors.toList());
        }

    }


    public List<Article> getSortedArticles() {
        removeNull();

        // dieser Code wäre es gewesen, wenn wir nur die Länge sortiert hätten
        return articles.stream()
                    .sorted(Comparator.comparingInt((Article a) -> a.getDescription().length())
                    .thenComparing(Article :: getDescription))
                    .collect(Collectors.toList());



           /* return articles.stream()
                    .sorted((o1, o2) -> {
                        if (o1.getDescription().length() == o2.getDescription().length())     //getDescriptionLength ist eine neu geschriebene Methode, um direkt integer Länge zu haben
                            return o1.getDescription().compareTo(o2.getDescription());  // wenn sie gleich lang sind, returne nach alphabetischer Reihenfolge
                        else if (o1.getDescription().length() > o2.getDescription().length())     //wenn eins größer ist als das andere
                            return 1;  //returnen wir eine positive nummer, die besagt, dass ein element größer ist als das andere
                        else return -1; // wenn wir negative zahl returnen, heißt das ein element kleiner als das andere ist
                    })
                            .collect(Collectors.toList());
        }*/
        }


private void removeNull(){
    for (Article a : articles){
        if(a.getDescription() == null){
            a.setDescription("");
        }
    }
}

    /**
     * filters a given article list based on a query
     *
     * @param query    to filter by
     * @param articles list to filter
     * @return filtered list
     */
        private static List<Article> filterList (String query, List < Article > articles){
            List<Article> filtered = new ArrayList<>();
            for (Article i : articles) {
                if (i.getTitle().toLowerCase().contains(query)) {
                    filtered.add(i);
                }
            }
            return filtered;
        }
    }



