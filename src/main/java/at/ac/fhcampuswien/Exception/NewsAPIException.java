package at.ac.fhcampuswien.Exception;
import at.ac.fhcampuswien.models.Article;

import java.util.ArrayList;
import java.util.Scanner;

// Exception Handling:
//o Implementiert eine Custom Exception mit dem Namen NewsAPIException
//o Untersucht euer Programm und identifiziert jene Stellen, in denen Exceptions
//auftreten könnten
//o Implementiert das Exception Handling - überlegt an welchen Stellen in eurem
//Programm die Exceptions geworfen, propagiert und gehandelt (catching)
//werden sollen

public class NewsAPIException extends Exception {

    private final static String ErrorMessage = "Oops! Something went wrong with your wished request!";

    NewsAPIException() {
        super(ErrorMessage);
    }

    NewsAPIException(String customMessage){
        super(customMessage);
    }
}


//     Article {
   // NewsAPIException(String message) {
   //    super(message);
   //}



  /*  public static void Article(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Article");
        int NewsException = scan.nextInt();


        try {
            checkException(NewsException);
        } catch ( ) {
            System.out.println(.getMessage() );
        }
    }

    static void checkException(int exception) throws  {

    }*/
