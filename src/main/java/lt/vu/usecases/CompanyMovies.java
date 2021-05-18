package lt.vu.usecases;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Company;
import lt.vu.entities.Genre;
import lt.vu.entities.Movie;
import lt.vu.interceptor.Logged;
import lt.vu.persistence.CompaniesDAO;
import lt.vu.persistence.GenresDAO;
import lt.vu.persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;


@Model
public class CompanyMovies implements Serializable {

    @Inject
    private CompaniesDAO companiesDAO;

    @Inject
    private MoviesDAO moviesDAO;

    @Inject
    private GenresDAO genresDAO;

    @Getter
    @Setter
    private Company company;

    @Getter
    @Setter
    private Movie movieToCreate = new Movie();

    @Getter
    @Setter
    private List<Integer> genresIdsToAdd = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer companyId = Integer.parseInt(requestParameters.get("companyId"));
        this.company = companiesDAO.findOne(companyId);
    }

    @Logged
    @Transactional
    public String createMovie()
    {
        List<Genre> genreList = new ArrayList<>();
        List<Genre> allGenres = genresDAO.loadAll();
        for(Genre g : allGenres)
        {
            if(genresIdsToAdd.contains(g.getId()))
            {
                genreList.add(g);
            }
        }
        movieToCreate.setGenres(genreList);
        movieToCreate.setCompany(company);
        moviesDAO.persist(movieToCreate);
        return "movies?faces-redirect=true&companyId=" + this.company.getId();
    }

}
