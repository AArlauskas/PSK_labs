package lt.vu.reviewFinder;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@SessionScoped
public class ReviewFinderComponent implements Serializable, IReviewFinder {
    private final List<String> mockExternalData = new ArrayList<String>() {
        {
            add("A very interesting movie");
            add("Could be better");
            add("I was expecting more");
            add("Best movie I have ever seen!");
            add("Would pay money to watch again");
        }
    };

    public CompletableFuture<String> findNewReviewAsync() throws InterruptedException {
        Random rand = new Random();
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(4000);
            int index = rand.nextInt(mockExternalData.size());
            completableFuture.complete(mockExternalData.get(index));
            return null;
        });

        return completableFuture;
    }
}
