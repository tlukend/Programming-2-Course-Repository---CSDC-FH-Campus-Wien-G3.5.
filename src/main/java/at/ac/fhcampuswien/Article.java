package at.ac.fhcampuswien;

import javafx.scene.Node;

public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
    private Source source;




    //sorce? soll es drinnen sein oder nicht? - siehe unten als inner class

    public Article(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, Source source) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;
    }

    public String getAuthor() {
        if (author == null){
            return "not found";
        }return author;
    }

    public String getTitle() {
        if (title == null) {
            return "not found";
        }return title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        if (description == null) {
            return "not found";}
            return description;
        }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        if (url == null) {
            return "not found";}
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        if (urlToImage == null) {
            return "not found";}
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        if (publishedAt == null) {
            return "not found";}
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        if (content == null) {
            return "not found";}
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

     private class Source{
        private final String id;
        private final String name;

        public Source(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            if (id == null) {
                return "not found";}
            return id;
        }

        public String getName() {
            if (name == null) {
                return "not found";}
            return name;
        }

        @Override
        public String toString() {
            return "Source: " + System.lineSeparator() + "Id: " + getId() + ", Name: " + getName();
        }

        //noch nicht sicher ob man sich die quelle unabhängig anzeigen lassen soll

    }


    @Override
    public String toString() {
        return "Author: " + getAuthor() + ", Title: " + getTitle() + System.lineSeparator() +"Description: "
                + getDescription() + System.lineSeparator() + "Url: " + getUrl() + "Url to Image: " + getUrlToImage()
                + System.lineSeparator() + "Published at: " + getPublishedAt() + System.lineSeparator() + "Content: " + getContent();
    }
}

