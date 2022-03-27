package at.ac.fhcampuswien;

import javafx.scene.Node;

public class Article {
    private String author;
    private String title;
    public static int count;

    public Article(String author, String title) {
        this.author = author;
        this.title = title;
        count++;

    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Author: " + getAuthor() + ", Title: " + getTitle();
    }
}

