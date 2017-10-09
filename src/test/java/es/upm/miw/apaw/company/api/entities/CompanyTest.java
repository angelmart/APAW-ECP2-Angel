package es.upm.miw.apaw.company.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.builder.StaffBuilder;

public class CompanyTest {
    
    private Company company;

    @Before
    public void Before() {
        company = new Company("company1");
    }

    @Test
    public void testGetId() {
        company.setId( 2 );
        assertEquals( 2, company.getId() );
    }

    @Test
    public void testGetName() {
        company.setName( "Company SA");
        assertEquals( "Company SA", company.getName() );
    }


    @Test
    public void testGetAddress() {
        company.setAddress( "Company Address");
        assertEquals( "Company Address", company.getAddress() );
    }


    @Test
    public void testGetStaff() {
        Staff staff = new StaffBuilder("Santiago").country("Francia").build();
        company.addStaff( staff );
        assertEquals( "Santiago", company.getStaff().get(0).getFamilyName() );
    }

    @Test
    public void testGetSize() {
        company.setSize(Size.SMALL);
        assertEquals( Size.SMALL, company.getSize() );
    }


}
