package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Company;
import lt.vu.persistence.CompaniesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Companies {

    @Inject
    private CompaniesDAO companiesDAO;

    @Getter
    @Setter
    private Company companyToCreate = new Company();

    @Getter
    private List<Company> allCompanies;

    @PostConstruct
    public void init()
    {
        loadAllCompanies();
    }

    @Transactional
    public String createCompany()
    {
        this.companiesDAO.persist(companyToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllCompanies() {
        allCompanies = companiesDAO.loadAll();
    }
}
