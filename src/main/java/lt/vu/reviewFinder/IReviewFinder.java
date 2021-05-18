package lt.vu.reviewFinder;

import java.util.concurrent.CompletableFuture;

public interface IReviewFinder {
    CompletableFuture<String> findNewReviewAsync() throws InterruptedException;
}
