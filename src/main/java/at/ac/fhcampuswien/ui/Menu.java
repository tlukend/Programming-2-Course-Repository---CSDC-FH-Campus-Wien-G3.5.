package at.ac.fhcampuswien.ui;

import at.ac.fhcampuswien.controllers.AppController;
import at.ac.fhcampuswien.enums.*;
import at.ac.fhcampuswien.models.Article;

import java.text.Normalizer;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    private static final String INVALID_INPUT_MESSAGE = "No valid input. Try again";
    private static final String EXIT_MESSAGE = "Bye bye!";
    private AppController controller;

    public void start() {
        String input;
        controller = new AppController();

        do {
            System.out.println(getMenuText());
            input = readLine();
            handleInput(input);
        } while (!input.equals("q"));

    }

    private void handleInput(String input) {
        switch (input) {
            case "a" -> getTopHeadlinesAustria(controller);
            case "b" -> getAllNewsBitcoin(controller);
            case "c" -> getSourceWithMostArticles(controller); //unsure Are
            case "d" -> getAuthorWithLongestName(controller);
            case "e" -> getNewYorkTimesArticleCount(controller);
            case "f" -> getArticlesUnder15(controller);
            case "g" -> getSortedArticles(controller);
            case "h" -> download(controller);
            case "i"-> search(controller);
            case "y" -> getArticleCount(controller);
            case "q" -> printExitMessage();
            default -> printInvalidInputMessage();
        }
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

    private void download(AppController controller) {
        List<Article> articleList = controller.getTopHeadlinesAustria();
        Article articel = articleList.get(1);
        if (articel.getContent() == null) {
            articel = articleList.get(2);
        }

        articel.download(getURLSlug(articel.getTitle()));
    }

    private void getArticleCount(AppController controller) {
        System.out.println("Number of articles: " + controller.getArticleCount());
    }

    private void search(AppController controller) {
        // country,sortby, endpoint,category,language
        String searchword;
        System.out.print("searchword :");
        searchword  = readLine()     ;

        String country;
        System.out.print("contry :");
        country   = readLine()     ;

        String sortby;
        System.out.print("sortby :");
        sortby   = readLine()     ;

        String endpoint;
        System.out.print("endpoint :");
          endpoint= readLine()     ;

        String category;
        System.out.print("category:");
        category= readLine()     ;

        String language;
        System.out.print("language :");
        language= readLine()     ;


        System.out.println(controller.getsearchArticle(
                searchword, Country.valueOf(country), Endpoint.valueOf(endpoint), SortBy.valueOf(sortby), Category.valueOf(category),Language.valueOf(language)
        ));
    }


    private void getTopHeadlinesAustria(AppController controller) {
        List<Article> articleList = controller.getTopHeadlinesAustria();

        for (Article a : articleList) {
            System.out.println(a);
        }
    }

    private void getAllNewsBitcoin(AppController controller) {
        System.out.println(controller.getAllNewsBitcoin());
    }

    private void getSourceWithMostArticles(AppController controller) {
        System.out.println(controller.getSourceWithMostArticles());
    }

    private void getAuthorWithLongestName(AppController controller) {
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
                h: Download 1st article
                i: Search
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
