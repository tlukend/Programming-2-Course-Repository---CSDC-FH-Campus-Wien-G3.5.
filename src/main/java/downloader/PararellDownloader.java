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
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(urls.size());
        List<Future<String>> futures = new ArrayList<>();

        for (String url : urls) {
            try {
                Callable<String> task = () -> saveUrl2File(url);
                Future<String> future = executorService.submit(() -> saveUrl2File(url));
                //futures.add(  executorService.submit(() ->saveUrl2File(url)));

                futures.add(executorService.submit(task));

            } catch (Exception e) {
                throw new NewsAPIException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }


        for (Future<String> result : futures) {
            try {
                if (result.get() != null) {
                    count++;
                }
            } catch (Exception ex) {

            }
        }

        executorService.shutdown();
        return count;
    }
}