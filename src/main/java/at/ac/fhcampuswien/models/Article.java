package at.ac.fhcampuswien.models;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


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
//wo wir das Speichern wollen, nenen hier Datei filnename wo wir das abspeichern wollen
    // Files ist die Methode und gibt uns an das wir speichern wollen, erst wenn es aufgerufen wird
    //ist es gespeichert
    //Path file:ist der Ort wo wir gespeichert wollen
    //content: ist der Inhalt der gespeichert werden soll
    public void download(String filename){

        Path filePath = Paths.get(filename + ".txt");
        System.out.println("Artikel download");
        try {
            Files.writeString(filePath, content, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
