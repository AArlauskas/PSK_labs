package lt.vu.persistence;

import lt.vu.entities.Company;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CompaniesDAO {

    @Inject
    private EntityManager em;

    public List<Company> loadAll()
    {
        return em.createNamedQuery("Company.findAll", Company.class).getResultList();
    }

    public void setEm(EntityManager em)
    {
        this.em = em;
    }

    public void persist(Company company)
    {
        em.persist(company);
    }

    public Company findOne(Integer id)
    {
        return em.find(Company.class,id);
    }
    public Company update(Company company) {
        return em.merge(company);
    }

    public void delete(Company company) {
        em.remove(company);
    }
}
