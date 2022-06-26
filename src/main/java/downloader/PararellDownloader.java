package downloader;

import at.ac.fhcampuswien.Exception.NewsAPIException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class PararellDownloader extends Downloader {

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException {
        int count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(urls.size()); //erstellt ein pool von Threads
        List<Future<String>> futures = new ArrayList<>(); // in Futures wollen wir die Pools als Liste ablegen

        for (String url : urls) { //die Schleife von URLS wird durchlaufen
            try {
                Callable<String> task = () -> saveUrl2File(url); // callable ist eine Variable die als Funktion auf Ausführung wartet, wird positioniert (callable)
                //Future<String> future = executorService.submit(() -> saveUrl2File(url));
                //futures.add(  executorService.submit(() ->saveUrl2File(url)));

                futures.add(executorService.submit(task)); //submit(abgeschickt) ist das Befehl ich schmeiß es in ein Thread, und zwar callable
                //future ist eine Liste, dieser Prozess wird in die Liste eingetragen
            } catch (Exception e) {
                throw new NewsAPIException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }


        for (Future<String> result : futures) { // die Rückgabe von Save gibt einen Datei Namen zurück, der wird dort gespeichert
            try {
                if (result.get() != null) { //gibt Datei Namen zuück falls vorhanden; wenn ein Fehler bei speichern passiert wird nicht's zurück gegeben, bzw.null
                    count++; //wenn es gut gelaufen ist, wird count immer hoch gezählt
                }
            } catch (Exception ex) {
                throw new NewsAPIException("Failed to get result!", ex);
            }
        }

        executorService.shutdown();
        return count; //muss count immer zurück gegeben
    }
}