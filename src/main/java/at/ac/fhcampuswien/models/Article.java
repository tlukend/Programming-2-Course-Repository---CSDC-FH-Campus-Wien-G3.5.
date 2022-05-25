package at.ac.fhcampuswien.models;

public class Article {
    private String author;
    private String title;
    private Source source;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public Article(String author, String title){
        this.author = author;
        this.title = title;
    }
    public Article(Source source){
        this.source = source;

    }
    public Article(String description){
        this.description = description;
    }

    public Source getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getDescriptionLength(){
        return getDescription().length();
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\n" + "Author: " + getAuthor() +"\n" + "Describbo: " + getDescription();
    }

}