package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.Exception.NewsAPIException;

import java.net.URL;

//making check, methods and if true/false - exception handling?
public class ApiCheckMethods {

    public static boolean CheckURL (String url){
        return url.contains("top-headlines") || url.contains("everything");
    }

}
