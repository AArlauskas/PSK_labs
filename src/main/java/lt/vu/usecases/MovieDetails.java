package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.ErrorComponent;
import lt.vu.entities.Movie;
import lt.vu.persistence.MoviesDAO;
import lt.vu.ratingAssigner.IRatingAssigner;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class MovieDetails implements Serializable {

    @Inject
    private MoviesDAO moviesDAO;

    @Getter
    @Setter
    private Movie movie;

    @Inject
    private ErrorComponent errorComponent;

    @Inject
    private IRatingAssigner ratingAssigner;

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer companyId = Integer.parseInt(requestParameters.get("movieId"));
        this.movie = moviesDAO.findOne(companyId);
    }

    @Transactional
    public void updateMovieTitle(Boolean sleep)
    {
        moviesDAO.update(movie);
        errorComponent.setShowErrorMessage(false);
        if (sleep) {
            try {
                Thread.sleep(5000);
                moviesDAO.flush();
            } catch (OptimisticLockException e) {
                errorComponent.setShowErrorMessage(true);
            } catch (Exception ignored) { }
        }
    }

    @Transactional
    public void assignRating()
    {
        movie.setRating(ratingAssigner.getRating());
        moviesDAO.update(movie);
    }
}
