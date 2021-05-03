package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Company;
import lt.vu.entities.Movie;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.CompaniesDAO;
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

    @Getter
    @Setter
    private Company company;

    @Getter
    @Setter
    private Movie movieToCreate = new Movie();

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer companyId = Integer.parseInt(requestParameters.get("companyId"));
        this.company = companiesDAO.findOne(companyId);
    }

    @Transactional
    @LoggedInvocation
    public String createMovie()
    {
        movieToCreate.setCompany(company);
        moviesDAO.persist(movieToCreate);
        return "movies?faces-redirect=true&companyId=" + this.company.getId();
    }

}
