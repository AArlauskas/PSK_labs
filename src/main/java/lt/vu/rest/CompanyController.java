package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Company;
import lt.vu.persistence.CompaniesDAO;

import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/company")
public class CompanyController {

    @Inject
    @Getter
    @Setter
    private CompaniesDAO companiesDAO;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        List<Company> companies = companiesDAO.loadAll();
        List<CompanyDTO> companiesDTO = companies.stream().map(company -> {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(company.getId());
            companyDTO.setName(company.getName());
            return  companyDTO;
        }).collect(Collectors.toList());
        return Response.ok(companiesDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") final Integer id)
    {
        Company company = companiesDAO.findOne(id);
        if(company == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        CompanyDTO companyDTO = new CompanyDTO();
        company.setId(company.getId());
        company.setName(company.getName());
        return Response.ok(companyDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CompanyDTO companyDTO)
    {
        Company company = new Company();
        company.setName(companyDTO.getName());
        companiesDAO.persist(company);
        companyDTO.setId(company.getId());

        return Response.ok(companyDTO).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(CompanyDTO companyDTO, @QueryParam("id") final Integer id)
    {
        try {
            Company company = companiesDAO.findOne(id);
            if(company == null)
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            company.setName(companyDTO.getName());
            companiesDAO.update(company);
            return  Response.ok().build();
        }
        catch (OptimisticLockException ex) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@QueryParam("id") final Integer id)
    {
        Company company = companiesDAO.findOne(id);
        if(company == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        companiesDAO.delete(company);
        return Response.ok().build();
    }
}
