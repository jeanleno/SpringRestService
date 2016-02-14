package com.jlheidemann.service;

import com.jlheidemann.entity.Company;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Jean
 */
@RestController
@RequestMapping("/companyservice")
public class CompanyService {
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getTeste(@PathVariable String name) {
		String result = "Hello, " + name;
		return result;
	}
        
        @RequestMapping(value = "/getcompany", method = RequestMethod.GET)
        public Company getCompany(@RequestParam(value = "id") int id) {
            Company c = new Company();
            c.setId(id);
            c.setName("Company 1");
            
            return c;
        }
	
}
