package at.ac.fhcampuswien.Exception;

public class NewsAPIException extends Exception {

    private final static String DefaultErrorMessage = "Oops! Something went wrong with your wished request!";

    public NewsAPIException(Throwable cause) {
       super(DefaultErrorMessage, cause);
    }

    public NewsAPIException(String customMessage, Throwable cause){
        super(customMessage, cause);
    }
    public NewsAPIException(String customMessage){
        super(customMessage);
    }
}