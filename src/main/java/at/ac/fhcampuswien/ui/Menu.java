package at.ac.fhcampuswien.ui;

import at.ac.fhcampuswien.Exception.NewsAPIException;
import at.ac.fhcampuswien.controllers.AppController;
import at.ac.fhcampuswien.enums.*;
import at.ac.fhcampuswien.models.Article;
import downloader.Downloader;
import downloader.PararellDownloader;
import downloader.SequentialDownloader;

import java.text.Normalizer;
import java.util.*;
import java.util.regex.Pattern;

public class Menu {
    private static final String INVALID_INPUT_MESSAGE = "No valid input. Try again";
    private static final String EXIT_MESSAGE = "Bye bye!";
    private AppController controller;
    private static final Menu instance = new Menu();

    private Menu() {
    }

    public static Menu getInstance() {
        return instance;
    }

    public void start() {
        String input;
        controller = AppController.getInstance();

        do {
            System.out.println(getMenuText());
            input = readLine();
            handleInput(input);
        } while (!input.equals("q"));

    }

    private void handleInput(String input) {
        try {

            switch (input) {
                case "a" -> getTopHeadlinesAustria(controller);
                case "b" -> getAllNewsBitcoin(controller);
                case "c" -> getSourceWithMostArticles(controller); //unsure Are
                case "d" -> getAuthorWithLongestName(controller);
                case "e" -> getNewYorkTimesArticleCount(controller);
                case "f" -> getArticlesUnder15(controller);
                case "g" -> getSortedArticles(controller);
                case "h" -> { getRandomArticle(controller);
                    System.out.println("Type \"next\" for the next article");}
                case "i" -> download(controller);
                case "j" -> search(controller);
                case "k" -> downloadURLs(controller);
                case "y" -> getArticleCount(controller);
                case "q" -> printExitMessage();
                case "next" -> getNextIteratedArticle(controller);
                default -> printInvalidInputMessage();
            }
        } catch (NewsAPIException ex) {
            System.err.println(System.lineSeparator() + ex.getMessage() + System.lineSeparator());
        } catch (Exception ex) {
            System.err.println("An error happened while executing your command!");
        }
    }

    public static Article getRandomArticle (AppController controller) throws NewsAPIException {
        List<Article> headlinesAustria = controller.getTopHeadlinesAustria();

        Random random = new Random();
        Article a = headlinesAustria.get(random.nextInt(headlinesAustria.size()));
        System.out.println(a);
        return a;
    }

    public static Article getNextIteratedArticle ( AppController controller) throws NewsAPIException {

        Iterator<Article> it = getRandomArticle(controller).iterator();
        return it.next();

    }


    //gefunden in Internet für gültige Dateinamen,gibt Dateinamen zurück anhand des Artikels Titels
    public static String getURLSlug(String phrase) {
        if (phrase == null || phrase.trim().length() == 0)
            return "";

        String nonWhitespace = Pattern.compile("[^\\w-]").matcher(phrase).replaceAll("-");
        String normalized = Normalizer.normalize(nonWhitespace, Normalizer.Form.NFD);
        String slug = Pattern.compile("[\\s]").matcher(normalized).replaceAll("");

        return slug.toLowerCase();
    }

    private void downloadURLs(AppController controller) throws NewsAPIException {
        controller.downloadURLs();
    }

    private void download(AppController controller) throws NewsAPIException {
        List<Article> articleList = controller.getTopHeadlinesAustria();
        if (articleList == null || articleList.isEmpty()) {
            throw new NewsAPIException("The request returned an empty or invalid article list!");
        }

        Article articel = articleList.get(0);
        if (articel.getContent() == null) {
            articel = articleList.get(1);
        }

        articel.download(getURLSlug(articel.getTitle()));
    }

    private void getArticleCount(AppController controller) {
        System.out.println("Number of articles: " + controller.getArticleCount());
    }

    private void search(AppController controller) throws NewsAPIException {
        // country,sortby, endpoint,category,language
        String searchword;
        System.out.print("searchword :");
        searchword = readLine();

        String country;
        System.out.print("contry :");
        country = readLine();

        String sortby;
        System.out.print("sortby :");
        sortby = readLine();

        String endpoint;
        System.out.print("endpoint :");
        endpoint = readLine();

        String category;
        System.out.print("category:");
        category = readLine();

        String language;
        System.out.print("language :");
        language = readLine();

        try {
            System.out.println(controller.getSearchArticle(
                    searchword, Country.valueOf(country), Endpoint.valueOf(endpoint), SortBy.valueOf(sortby), Category.valueOf(category), Language.valueOf(language)
            ));
        } catch (IllegalArgumentException ex) {
            throw new NewsAPIException("Search input was invalid!", ex);
        }
    }


    private void getTopHeadlinesAustria(AppController controller) throws NewsAPIException {
        List<Article> articleList = controller.getTopHeadlinesAustria();

        for (Article a : articleList) {
            System.out.println(a);
        }
    }

    private void getAllNewsBitcoin(AppController controller) throws NewsAPIException {
        System.out.println(controller.getAllNewsBitcoin());
    }

    private void getSourceWithMostArticles(AppController controller) throws NewsAPIException {
        System.out.println(controller.getSourceWithMostArticles());
    }

    private void getAuthorWithLongestName(AppController controller) throws NewsAPIException {
        System.out.println(controller.getAuthorWithLongestName());
    }

    private void getNewYorkTimesArticleCount(AppController controller) {
        System.out.println(controller.getNewYorkTimesArticleCount());
    }

    private void getArticlesUnder15(AppController controller) {
        System.out.println(controller.getArticlesUnder15().toString());
    }

    private void getSortedArticles(AppController controller) {
        System.out.println(controller.getSortedArticles().toString());

    }

    public static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    public static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static String getMenuText() {
        return """
                *****************************
                *   Welcome to NewsApp   *
                *****************************
                Enter what you wanna do:
                a: Get top headlines austria
                b: Get all news about bitcoin
                c: Get provider with most articles
                d: Get longest author name
                e: Count articles from NY Times
                f: Get articles with short title
                g: Sort articles by content length
                h: Get a random article from Top Headlines
                ___________________________________
                i: Download 1st article
                j: Search
                k: Download URLs
                ___________________________________
                y: Count articles
                q: Quit program
                """;
    }

    private static String readLine() {
        String value;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        return value.trim();
    }

}
