package at.ac.fhcampuswien.controllers;

import at.ac.fhcampuswien.Exception.NewsAPIException;
import at.ac.fhcampuswien.api.Builder;
import at.ac.fhcampuswien.api.NewsApi;
import at.ac.fhcampuswien.enums.*;
import at.ac.fhcampuswien.models.Article;
import at.ac.fhcampuswien.models.NewsResponse;
import downloader.Downloader;
import downloader.PararellDownloader;
import downloader.SequentialDownloader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AppController {
    private List<Article> articles;
    private static final AppController instance = new AppController();

    private AppController() {
    }

    public static AppController getInstance() {
        return instance;
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
    public List<Article> getTopHeadlinesAustria() throws NewsAPIException {
        Builder builder = new Builder("", Endpoint.TOP_HEADLINES)
                .country(Country.at);
        NewsApi api = new NewsApi(builder);

        NewsResponse response = api.requestData();

        if (response != null) {
            articles = response.getArticles();
            return response.getArticles();
        }

        return new ArrayList<>();
    }

    public List<Article> getSearchArticle(String q, Country country, Endpoint endpoint, SortBy sortby, Category category, Language language) throws NewsAPIException {
        Builder builder = new Builder(q, endpoint)
                .country(country)
                .sortBy(sortby)
                .category(category)
                .language(language);
        NewsApi api = new NewsApi(builder);

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
    public List<Article> getAllNewsBitcoin() throws NewsAPIException {
        Builder builder = new Builder("bitcoin", Endpoint.EVERYTHING);
        NewsApi api = new NewsApi(builder);
        NewsResponse response = api.requestData();

        if (response != null) {
            articles = response.getArticles();
            return response.getArticles();
        }

        return new ArrayList<>();
    }

    public String getSourceWithMostArticles() throws NewsAPIException { // done :)
        if (articles == null) {
            throw new NewsAPIException("No articles found!");
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
    public String getAuthorWithLongestName() throws NewsAPIException {
        if (articles == null) {
            throw new NewsAPIException("No articles found!");
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


    public void downloadURLs() throws NewsAPIException {
        List<Article> articleList = getTopHeadlinesAustria();
        if (articleList == null || articleList.isEmpty()) {
            throw new NewsAPIException("The request returned an empty or invalid article list!");
        }

        List<String> urls = articleList.stream().map(Article::getUrl).collect(Collectors.toList());
        // Article urls werden mit Hilfe von Streams extrahiert


        System.out.println("Downloading files...");
        long startSeq = System.currentTimeMillis();
        Downloader seqDowloader = new SequentialDownloader();
        int countSeq = seqDowloader.process(urls);
        long stopSeq = System.currentTimeMillis();
        System.out.println("Sequentieldownloader Articales: "+countSeq+" files. Download duration: " + (stopSeq - startSeq) + " ms");
        // Sequ Downloader wird aufgerufen und Verarbeitet

        long startPara = System.currentTimeMillis();
        Downloader paraDowloader = new PararellDownloader();
        long countPara = paraDowloader.process(urls);
        long stopPara= System.currentTimeMillis();
        System.out.println("Paralleldownloader Articales: "+countPara+" files. Download duration: " + (stopPara - startPara) + " ms");
//     wird der Paralleldownloader aufgerufen und verarbeitet
    }
}



