package es.upm.miw.apaw.company.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.entities.Staff;

public class StaffDaoMemoryTest {
    
    private Staff staff;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        staff = new Staff("Pepito");
        DaoFactory.getFactory().getStaffDao().create(staff);
    }

    @Test
    public void testReadStaff() {
        assertEquals("Pepito", DaoFactory.getFactory().getStaffDao().read(1).getFamilyName());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getCompanyDao().read(2));
    }


}
