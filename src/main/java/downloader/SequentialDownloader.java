package downloader;

import at.ac.fhcampuswien.Exception.NewsAPIException;
import downloader.Downloader;

import java.util.List;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class SequentialDownloader extends Downloader {
    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException{ //vererbete Methode und die muss man immer neu Ausführen
        int count = 0; // 0 ist ein Intialwert, wir wollen wissen wie viele Datein ausgeführt wurde
        for (String url : urls) {
            try {
                String fileName = saveUrl2File(url); //es spreichert anhand der URL die Datei in Donwload Ordner
                if(fileName != null)
                    count++; //zählt dann wie viele Datei gedownloadet wurde
            } catch (NewsAPIException e){ //wenn estwas schief gelaufen ist, wenn das API in Fehlhafter zustand ist
                System.err.println(e.getMessage());
                throw new NewsAPIException(e.getMessage());
            } catch (Exception e){
                throw new NewsAPIException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }
        return count; //Rückgabe von Prozess, sprich: wie viele Dateien wurden Erfolgreich gedownloadet werde
    }
}