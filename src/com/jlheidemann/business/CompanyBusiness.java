/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlheidemann.business;

import com.jlheidemann.database.Database;
import com.jlheidemann.entity.Company;
import com.jlheidemann.entity.Owner;
import java.util.List;

/**
 *
 * @author jean.heidemann
 */
public class CompanyBusiness {
    public Company getCompany(int id) {
        for (Company c : Database.getInstance().getCompanies()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    
    public List<Company> getCompanies() {
        return Database.getInstance().getCompanies();
    }
    
    public boolean editCompany(int id, Company company) {
        List<Company> companies = Database.getInstance().getCompanies();
        for (Company c : companies) {
            if (c.getId() == id) {
                companies.remove(c);
                break;
            }
        }
        company.setId(id);
        Database.getInstance().getCompanies().add(company);
        return true;
    }
    
    public boolean createCompany(Company company) {
        company.setId(Database.getInstance().getCompanyId());
        Database.getInstance().incrementComapnyId();
        Database.getInstance().getCompanies().add(company);
        return true;
    }
    
    public boolean deleteCompany(int id) {
        List<Company> companies = Database.getInstance().getCompanies();
        
        for (Company c : companies) {
            if (c.getId() == id) {
                companies.remove(c);
                break;
            }
        }
        return true;
    }
    
    public boolean addOwnerToCompany(int companyId, String ownerName) {
        List<Company> companies = Database.getInstance().getCompanies();
        for (Company c : companies) {
            if (c.getId() == companyId) {
                Owner owner = new Owner();
                owner.setName(ownerName);
                owner.setId(Database.getInstance().getOwnerId());
                
                Database.getInstance().incrementOwnerId();
                
                c.addOwner(owner);
                break;
            }
        }       
        return true;
    }
}
