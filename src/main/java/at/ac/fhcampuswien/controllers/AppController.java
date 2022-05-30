package at.ac.fhcampuswien.controllers;
import at.ac.fhcampuswien.Exception.NewsAPIException;
import at.ac.fhcampuswien.api.NewsApi;
import at.ac.fhcampuswien.enums.*;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.NewsResponse;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        try {
            NewsResponse response = api.requestData();

            if (response != null) {
                articles = response.getArticles();
                return response.getArticles();
            }
        } catch (NewsAPIException e) {
            System.err.println("There was an error with your request! (Error message: " + e.getMessage() + ")");
        }
        return new ArrayList<>();
    }

    public List<Article> getsearchArticle(String q, Country country, Endpoint endpoint, SortBy sortby, Category category, Language language) {
        NewsApi api = new NewsApi(q,country, endpoint,sortby,category,language);
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
        try {
            NewsResponse response = api.requestData();

            if (response != null) {
                articles = response.getArticles();
                return response.getArticles();
            }
        } catch (NewsAPIException e) {
            System.err.println("There was an error with your request! (Error message: " + e.getMessage() + ")");
        }
        return new ArrayList<>();
    }

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
        }
    }


    //welcher Provider und welcher Autor hat den nächsten Namen haben wir gelöst
    public String getAuthorWithLongestName() {
        if (articles == null) {
            return "no authors found";
        } else {
            return articles
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
        if (articles == null) {
            return new ArrayList<>();
        } else {
            return articles
                    .stream()
                    .filter(article -> article
                            .getTitle()
                            .length() < 15).collect(Collectors.toList());
        }

    }


    public List<Article> getSortedArticles() {
        return articles.stream()
                .sorted(Comparator.comparingInt((Article a) -> a.getDescription() == null ? 0 : a.getDescription().length())
                        .thenComparing(Article::getDescription))
                .collect(Collectors.toList());
    }

    /**
     * filters a given article list based on a query
     *
     * @param query    to filter by
     * @param articles list to filter
     * @return filtered list
     */
    private static List<Article> filterList(String query, List<Article> articles) {
        List<Article> filtered = new ArrayList<>();
        for (Article i : articles) {
            if (i.getTitle().toLowerCase().contains(query)) {
                filtered.add(i);
            }
        }
        return filtered;
    }
}



