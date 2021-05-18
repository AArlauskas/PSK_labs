package lt.vu.usecases;

import lt.vu.reviewFinder.IReviewFinder;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Named
@ApplicationScoped
public class FindReview implements Serializable {
    @Inject
    private IReviewFinder reviewFinderComponent;

    @Inject
    MovieDetails movieDetails;

    private Integer movieId;

    private CompletableFuture<String> reviewFindTask = null;

    public void findReview() throws InterruptedException {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        movieId = Integer.parseInt(requestParameters.get("movieId"));

        reviewFindTask = reviewFinderComponent.findNewReviewAsync();
    }

    public boolean isFindingInProgress() {
        return reviewFindTask != null && !reviewFindTask.isDone();
    }

    public String getFindingRatingTaskStatus() throws ExecutionException, InterruptedException {
        if (reviewFindTask == null) {
            return null;
        } else if (!reviewFindTask.isDone()) {
            return "Finding a review";
        }

        String review = reviewFindTask.get();
        reviewFindTask = null;
        return "Review found! Review: " + review;
    }
}
