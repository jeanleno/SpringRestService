/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import com.jlheidemann.business.CompanyBusiness;
import com.jlheidemann.entity.Company;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jean.heidemann
 */
public class CompanyBusinessTest {
    
    CompanyBusiness business;
    Company company;
    
    public CompanyBusinessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        business = new CompanyBusiness();
        company = new Company();
        company.setName("Company 1");
        company.setAddress("Address 1");
        company.setCity("City 1");
        company.setCountry("Country 1");
    }
    
    @After
    public void tearDown() {
        business = null;
    }

    @Test
    public void testCreateCompany() {
        boolean result = business.createCompany(company);
        boolean expectedResult = true;
        
        Assert.assertEquals(result, expectedResult);
        
    }
    
    @Test
    public void testEditCompany() {
        
        boolean result = business.editCompany(1, company);
        boolean expectedResult = true;
        
        Assert.assertEquals(result, expectedResult);
        
    }
    
    @Test
    public void testDeleteCompany() {
        
        boolean result = business.deleteCompany(1);
        boolean expectedResult = true;
        
        Assert.assertEquals(result, expectedResult);
        
    }
}
