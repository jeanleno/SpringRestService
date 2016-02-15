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
    }
    
    @After
    public void tearDown() {
        business = null;
    }

    @Test
    public void testGetCompany() {
        boolean result = business.createCompany(new Company());
        boolean expectedResult = true;
        
        Assert.assertEquals(result, expectedResult);
        
    }
}
