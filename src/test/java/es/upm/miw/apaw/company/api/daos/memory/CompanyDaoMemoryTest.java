package es.upm.miw.apaw.company.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.company.api.entities.Company;

public class CompanyDaoMemoryTest {

    private Company company;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        company = new Company("company1");
        DaoFactory.getFactory().getCompanyDao().create(company);
    }

    @Test
    public void testReadCompany() {
        assertEquals("company1", DaoFactory.getFactory().getCompanyDao().read(1).getName());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getCompanyDao().read(2));
    }


}
