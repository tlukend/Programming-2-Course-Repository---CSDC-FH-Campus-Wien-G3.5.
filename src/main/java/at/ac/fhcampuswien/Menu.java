package at.ac.fhcampuswien;

import java.util.Scanner;
import java.sql.SQLOutput;

//WIRD NICHT GEBRAUCHT AM ENDE DA JAVA-FX implementiert: Diese ganze Klasse ist somit obsolet aber wir haben es zu Beginn so gemacht
public class Menu {
    //AppController soll hier nach der Validation aufgerufen werden

    static Scanner scan = new Scanner(System.in);
    AppController controller = new AppController();
    private static String input;
    private final static String INVALID_USER_INPUT_MESSAGE = "Incorrect! Please write a,b,y or q!";
    private final static String EXIT_MESSAGE = "Bye bye!";


    public void start(){}
    //„a“ soll eine statisch generierte Liste von Artikeln,
    // Bei „b“ alle Artikel, in denen das Keyword „bitcoin“ im Titel
    // „y“ gibt die Anzahl der Artikel der statischen Liste aus
    // „q“ gibt einen Verabschiedungstext aus und beendet das Programm

    public static void printMenu() {
        System.out.println("*****************************\n*   Welcome to NewsApp   *\n*****************************\nEnter what you wanna do:\na: Get top headlines austria\nb: Get all news about bitcoin\ny: Count articles\nq: Quit program");
        input = scan.next();
        switch (input) {
            case "a":
                System.out.println("Liste von Artikeln");
                break;
            case "b":
                System.out.println("bitcoinCheckMethodeaufrufenundPrinten");
                ;
                break;
            case "y":
                System.out.println("Number of articles: +Variable/methodeaufrufen");
                break;
            case "q":
                System.out.println(EXIT_MESSAGE);
                break;
            default:
                System.out.println(INVALID_USER_INPUT_MESSAGE);
        }
    }

    public static String getInput() {
        return input;
    }

    private void handleInput(String input) {
        //userInput = userInput.nextString();
        //input = getInput();
        //if (input = "a" || input == "b" || getInput() == "y" || getInput() == "q")){

        }
    public String articleCount (){
        return Integer.toString(controller.getArticleCount());
    }





    //die Menu Klasse ist für die Ausgabe des Konsolenmenüs, sowie die Usereingaben zuständig.
    // Wurden die Usereingaben validiert, werden diese an die entsprechenden AppController
    // Funktionen weitergegeben (dh. die konkrete Logik vom AppController wird aufgerufen).
    // Dementsprechend enthält die Klasse eine Membervariable von AppController.
    // Weiters zwei konstante Membervariablen für invalide Usereingaben
    // (INVALID_USER_INPUT_MESSAGE) und den Verabschiedungstext (EXIT_MESSAGE)
}
