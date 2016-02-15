/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlheidemann.database;

import com.jlheidemann.entity.Company;
import com.jlheidemann.entity.Owner;
import java.util.ArrayList;

/**
 *
 * @author jean.heidemann
 */
public final class Database {
    
    private static final Database instance = new Database();
    
    private final ArrayList<Company> companies = new ArrayList<>();
    private final ArrayList<Owner> owners = new ArrayList<>();
    private int companyId = 1;
    private int ownerId = 1;
    
    private Database() {
        
    }
    
    public static Database getInstance() {
        return instance;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getOwnerId() {
        return ownerId;
    }
    
    public void incrementComapnyId() {
        companyId++;
    }
    
    public void incrementOwnerId() {
        ownerId++;
    }
}
