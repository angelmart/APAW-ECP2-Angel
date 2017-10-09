package es.upm.miw.apaw.company.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.daos.memory.DaoMemoryFactory;

public class StaffControllerIT {

    private StaffController staffController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        staffController = new StaffController();
        staffController.createStaff("Federico");
    }
    
    @Test
    public void testReadStaff() {
       assertEquals("Federico",staffController.readStaff(1).get().getName());
    }
    
    @Test
    public void testReadStaffNonExistId() {
       assertFalse(staffController.readStaff(2).isPresent());
    }
    
    @Test
    public void testCreateAndStaffList() {
        staffController.createStaff("Diego");
        assertEquals(2, staffController.staffList().size());
        assertEquals("Federico", staffController.staffList().get(0).getName());
    }
    
}
