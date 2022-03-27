package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController <E> {
        public List<Article> Articles = new ArrayList<Article>();
        List<E> TopHeadlinesAustria = new ArrayList<>();
        List<E> filterList = new ArrayList<>();
        String query = "Bitcoin";

        public static void generateMocklist(List<Article> art){

           Article a01 = new Article("Margarete Stokowski", "Finger weg von den Frauen!");
           Article a02 = new Article("Melisa Erkurt", "Reiche Eltern für alle!");
           Article a03 = new Article("Melina Borcak", "Keine Strafe hoch genug");
           Article a04 = new Article("Melina Borcak", "Das weiße Band der Schande");

            art.add(a01);
            art.add(a02);
            art.add(a03);
            art.add(a04);

        }


        public void setArticles(List<Article> articles) {
            Articles = articles;
       }

        public int getArticleCount(){
            if (Article.count >= 1)
                return Article.count;
            else return 0;
        }

        public boolean getAllNewsBitcoin(){
            boolean bitcoinfound = Articles.contains(query);
            if (bitcoinfound==true) {
                return bitcoinfound;
            }
            return false;
            //return filteredArticle; // arbeiten
        }
        //filterList("Bitcoin", Articles) = filteredArticle;
        //return filteredArticle; // arbeiten
        //public List<E> getAllNewsBitcoin(List <E> filteredArticle){
            //filterList("Bitcoin", Articles) = filteredArticle;
            //return filteredArticle;
        //}

        public List<E> getTopHeadlinesAustria() {
            if (getTopHeadlinesAustria().isEmpty()) {
                Collections.emptyList();
            }
            return TopHeadlinesAustria;
        }

        public List<E> filterList(String query, List<Article> articles){
        articles.stream().filter((b) -> articles.contains(query));
                return filterList;
                //arbeiten
        }


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
