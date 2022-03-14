package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController <E> {
        List<E> Articles = new ArrayList<E>();
        List<E> TopHeadlinesAustria = new ArrayList<>();

        public static void generateMocklist(){

        }

        public void setArticles(List<E> articles) {
            Articles = articles;
        }

        public int getArticleCount(){
            if (Article.count >= 1)
                return Article.count;
            else return 0;
        }

        public List<E> getTopHeadlinesAustria() {
            return TopHeadlinesAustria;
        }

    /*public List<E> filterList(String query, List<Article> articles){
        articles.stream().filter((b) -> articles.contains(query);
                return
    }*/


//
        //der AppController beinhaltet eine Liste aus Artikeln, welche durch die statische Methode
        // generateMockList() erstmals mit Dummy-Werten befüllt wird.
        // Weiters sollen folgende Methoden implementiert werden:
        //- setArticles(): Setter für die Artikel Liste
        //- getArticleCount(): gibt die Anzahl der Artikel der Liste zurück.
        //Ist die Liste null, soll 0 zurückgegeben werden
        //- getTopHeadlinesAustria(): wird noch nicht konkret implementiert.
        // Soll nur die Liste der Artikel zurückgeben. Ist die Liste null soll eine leere Liste
        // zurückgegeben werden
        //- filterList(String query, List<Article> articles): der Funktion wird ein Suchstring (query)
        // und eine Liste übergeben. Es wird eine Liste von jenen Artikeln zurückgegeben, in denen das Query
        // im Title vorkommt. Groß- und Kleinschreibung soll nicht beachtet werden.
        //- getAllNewsBitcoin(): die Funktion ruft die filterList() Funktion mit dem query „bitcoin“ auf
        //
        //Der AppController wird in zukünftigen Exercises das Herzstück der Applikation bilden.
        // .In dieser Exercise geht es darum, einige Unittests für die Funktionen zu schreiben.

    }
