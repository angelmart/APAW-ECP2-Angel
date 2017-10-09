package es.upm.miw.apaw.company.api.dtos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.company.api.builder.CompanyBuilder;
import es.upm.miw.apaw.company.api.entities.Company;

public class CompanyDtoTest {
    
    Company company;
    CompanyDto companyDto;
    
    @Before
    public void Before() {
        
        company = new CompanyBuilder("companyName").id(2).address("companyAddress").build();
        companyDto = new CompanyDto( company );

    }

    @Test
    public void testGetId() {
        companyDto.setId(2);
        assertEquals(2, companyDto.getId());
    }

    @Test
    public void testGetName() {
        companyDto.setName("companyDtoName");
        assertEquals("companyDtoName", companyDto.getName());
    }

    @Test
    public void testToString() {
        companyDto.setId(4);
        companyDto.setName("companyDtoFourName");
        assertEquals("{\"id\":4,\"name\":\"companyDtoFourName\"}",companyDto.toString());
    }

}
