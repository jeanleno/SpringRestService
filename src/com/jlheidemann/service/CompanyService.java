package com.jlheidemann.service;

import com.jlheidemann.business.CompanyBusiness;
import com.jlheidemann.entity.Company;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jean
 */
@RestController
@RequestMapping("/companyservice")
public class CompanyService {

    private static final CompanyBusiness business = new CompanyBusiness();


    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
    public Company getCompany(@PathVariable int id) {
        return business.getCompany(id);
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public List<Company> getCompanies() {
        return business.getCompanies();
    }

    @RequestMapping(value = "companies/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean editCompany(@PathVariable int id, @RequestBody Company company) {
        return business.editCompany(id, company);
    }
    
    @RequestMapping(value = "companies", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createCompany(@RequestBody Company company) {
        return business.createCompany(company);
    }

    @RequestMapping(value = "companies/{id}", method = RequestMethod.DELETE)
    public boolean deleteCompany(@PathVariable int id) {
        return business.deleteCompany(id);
    }
    
    @RequestMapping(value = "companies/{companyId}/{ownerName}", method = RequestMethod.POST)
    public boolean addOwnerToCompany(@PathVariable int companyId, @PathVariable String ownerName) {
        return business.addOwnerToCompany(companyId, ownerName);
    }
}
