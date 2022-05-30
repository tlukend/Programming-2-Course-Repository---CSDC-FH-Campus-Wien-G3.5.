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
        if (description == null) return "No description available";
        else return description;
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
        if (author == null) return "n.a.";
        else return author;
    }

    public String getTitle() {
        return title;
    }

    public int getDescriptionLength(){
        if (getDescription() == null)
            return 0;
       else  return getDescription().length();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\n" + "Author: " + getAuthor() +"\n" + "Decsription-Length: " + getDescriptionLength() + "\n" + "Description: " + getDescription() + "\n" + "Source:  " + getSource().getName();
    }



}