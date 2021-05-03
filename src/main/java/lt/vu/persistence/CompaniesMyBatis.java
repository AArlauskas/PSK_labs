package lt.vu.persistence;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.CompanyMapper;
import lt.vu.mybatis.model.Company;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@Model
public class CompaniesMyBatis {

    @Inject
    private CompanyMapper companyMapper;

    @Getter
    private List<Company> allCompanies;

    @Getter
    @Setter
    private Company companyToCreate = new Company();

    @PostConstruct
    public void init()
    {
        loadAllCompanies();
    }

    private void loadAllCompanies() {
        allCompanies = companyMapper.selectAll();
    }

    @Transactional
    public String createCompany()
    {
        companyMapper.insert(companyToCreate);
        return "/myBatis/companies?faces-redirect=true";
    }

    @Transactional
    public String deleteCompany(Integer companyId)
    {
        companyMapper.deleteByPrimaryKey(companyId);
        return "/myBatis/companies?faces-redirect=true";
    }
}
