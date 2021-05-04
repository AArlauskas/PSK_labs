package lt.vu.persistence;

import lt.vu.entities.Company;
import lt.vu.entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GenresDAO {

    @Inject
    private EntityManager em;

    public List<Genre> loadAll()
    {
        ArrayList all = (ArrayList) em.createNamedQuery("Genre.findAll", Genre.class).getResultList();
        return  all;
    }

    public void setEm(EntityManager em)
    {
        this.em = em;
    }

    public void persist(Genre genre)
    {
        em.persist(genre);
    }

    public Genre findOne(Integer id)
    {
        return em.find(Genre.class,id);
    }
}