package at.ac.fhcampuswien.Exception;

// Exception Handling:
//o Implementiert eine Custom Exception mit dem Namen NewsAPIException
//o Untersucht euer Programm und identifiziert jene Stellen, in denen Exceptions
//auftreten könnten
//o Implementiert das Exception Handling - überlegt an welchen Stellen in eurem
//Programm die Exceptions geworfen, propagiert und gehandelt (catching)
//werden sollen

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