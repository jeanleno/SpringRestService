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
        if (isValidCompany(company)) {
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
        } else {
            return false;
        }
    }
    
    public boolean createCompany(Company company) {
        if (isValidCompany(company)) {
            company.setId(Database.getInstance().getCompanyId());
            Database.getInstance().incrementComapnyId();
            Database.getInstance().getCompanies().add(company);
            return true;
        } else {
            return false;
        }
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
        if (isValidOwner(companyId, ownerName)) {
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
        } else {
            return false;
        }
    }
    
    private boolean isValidCompany(Company company) {
        if (company.getName() == null || company.getName().trim().equalsIgnoreCase("") 
                || company.getAddress() == null || company.getAddress().trim().equalsIgnoreCase("")
                || company.getCity() == null || company.getCity().trim().equalsIgnoreCase("")
                || company.getCountry() == null || company.getCountry().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
    
    private boolean isValidOwner(int companyId, String ownerName) {
        if (companyId <= 1 || ownerName == null || ownerName.trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
}
