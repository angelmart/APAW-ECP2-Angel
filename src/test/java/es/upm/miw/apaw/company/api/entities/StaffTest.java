package es.upm.miw.apaw.company.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.builder.StaffBuilder;

public class StaffTest {
    
    private Staff staff;

    @Before
    public void Before() {
        staff = new StaffBuilder("Diego").country("Alemania").build();
    }

    @Test
    public void testGetId() {
        staff.setId(2);
        assertEquals(2, staff.getId());
    }

    @Test
    public void testGetFamilyName() {
        staff.setFamilyName("Francisca");
        assertEquals("Francisca", staff.getFamilyName());
    }

    @Test
    public void testGetCountry() {
        staff.setCountry("Portugal");
        assertEquals("Portugal", staff.getCountry());
    }

    @Test
    public void testToString() {
        staff = new StaffBuilder("Isidra").id(3).country("Italia").build();
        assertEquals( "Staff [id=" + 3 + ", familyName=" + "Isidra" + ", country=" + "Italia" + "]", staff.toString() );
    }

}
