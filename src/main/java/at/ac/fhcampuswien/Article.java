package at.ac.fhcampuswien;

public class Article {
    String author;
    String title;

    public Article(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Author: " + this.author + ", Title: " + this.title;
    }
}
