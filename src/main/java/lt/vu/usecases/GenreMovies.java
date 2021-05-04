package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Genre;
import lt.vu.persistence.GenresDAO;
import lt.vu.persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class GenreMovies implements Serializable {
    @Inject
    private GenresDAO genresDAO;

    @Inject
    private MoviesDAO moviesDAO;

    @Getter
    @Setter
    private Genre genre;

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer genreId = Integer.parseInt(requestParameters.get("genreId"));
        this.genre = genresDAO.findOne(genreId);
    }
}
