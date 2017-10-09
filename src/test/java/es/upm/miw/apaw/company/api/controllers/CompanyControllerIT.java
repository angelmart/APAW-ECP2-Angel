package es.upm.miw.apaw.company.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.daos.memory.DaoMemoryFactory;

public class CompanyControllerIT {
    
    private CompanyController companyController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        companyController = new CompanyController();
        companyController.createCompany("company1");
    }
    
    @Test
    public void testReadCompany() {
       assertEquals("company1",companyController.readCompany(1).get().getName());
    }
    
    @Test
    public void testReadCompanyNonExistId() {
       assertFalse(companyController.readCompany(2).isPresent());
    }
    
    @Test
    public void testCreateAndCompanyList() {
        companyController.createCompany("company2");
        assertEquals(2, companyController.companyList().size());
        assertEquals("company1", companyController.companyList().get(0).getName());
        assertEquals("company2", companyController.companyList().get(1).getName());
    }
    
    @Test
    public void testDeleteCompany() {
        companyController.createCompany("company2");
        assertEquals(2, companyController.companyList().size());
        companyController.deleteCompany(2);
        assertEquals(1, companyController.companyList().size());
        
    }
    
    

    

}
