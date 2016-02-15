package com.jlheidemann.service;

import com.jlheidemann.entity.Company;
import com.jlheidemann.entity.Owner;
import java.util.ArrayList;
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

    private static final ArrayList<Company> companies = new ArrayList<>();
    private static final ArrayList<Owner> owners = new ArrayList<>();
    private static int companyId = 1;
    private static int ownerId = 1;


    @RequestMapping(value = "/getcompany/{id}", method = RequestMethod.GET)
    public Company getCompany(@PathVariable int id) {
        for (Company c : companies) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    
    @RequestMapping(value = "/getowner/{id}", method = RequestMethod.GET)
    public Owner getOwner(@PathVariable int id) {
        for (Owner o : owners) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    @RequestMapping(value = "/getallcompanies", method = RequestMethod.GET)
    public List<Company> getCompanies() {
        return companies;
    }
    
    @RequestMapping(value = "/getallowners", method = RequestMethod.GET)
    public List<Owner> getOwners() {
        return owners;
    }

    @RequestMapping(value = "editcompany/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean editCompany(@PathVariable int id, @RequestBody Company company) {
        for (Company c : companies) {
            if (c.getId() == id) {
                companies.remove(c);
                break;
            }
        }
        company.setId(id);
        companies.add(company);
        return true;
    }
    
    @RequestMapping(value = "editowner/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean editOwner(@PathVariable int id, @RequestBody Owner owner) {
        for (Owner o : owners) {
            if (o.getId() == id) {
                owners.remove(o);
                break;
            }
        }
        owner.setId(id);
        owners.add(owner);
        return true;
    }

    @RequestMapping(value = "createcompany", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createCompany(@RequestBody Company company) {
        company.setId(companyId);
        companyId++;
        companies.add(company);
        return true;
    }
    
    @RequestMapping(value = "createowner", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createOwner(@RequestBody Owner owner) {
        owner.setId(ownerId);
        ownerId++;
        owners.add(owner);
        return true;
    }

    @RequestMapping(value = "deletecompany/{id}")
    public boolean deleteCompany(@PathVariable int id) {
        for (Company c : companies) {
            if (c.getId() == id) {
                companies.remove(c);
                break;
            }
        }
        return true;
    }
    
    @RequestMapping(value = "deleteowner/{id}")
    public boolean deleteOwner(@PathVariable int id) {
        for (Owner o : owners) {
            if (o.getId() == id) {
                owners.remove(o);
                break;
            }
        }
        return true;
    }
}
