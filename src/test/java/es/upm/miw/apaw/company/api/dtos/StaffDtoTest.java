package es.upm.miw.apaw.company.api.dtos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.builder.StaffBuilder;
import es.upm.miw.apaw.company.api.entities.Staff;

public class StaffDtoTest {
    
    private Staff staff;
    private StaffDto staffDto;

    @Before
    public void Before() {
        
        staff = new StaffBuilder("García").id(3).country("Francia").build();
        staffDto = new StaffDto(staff);

    }
    
    @Test
    public void testGetId() {
        staffDto.setId(4);
        assertEquals(4, staffDto.getId());
    }

    @Test
    public void testGetName() {
        staffDto.setName("staffName");
        assertEquals("staffName", staffDto.getName());
    }

    @Test
    public void testToString() {
        staffDto.setName("staffDtoFourName");
        assertEquals("{\"name\":\"staffDtoFourName\"}",staffDto.toString());
    }


}
