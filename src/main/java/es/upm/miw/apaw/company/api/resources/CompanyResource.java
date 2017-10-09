package es.upm.miw.apaw.company.api.resources;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.company.api.dtos.CompanyDto;
import es.upm.miw.apaw.company.api.resources.exceptions.CompanyIdNotFoundException;
import es.upm.miw.apaw.company.api.resources.exceptions.CompanyNameInvalidException;

public class CompanyResource {
    
    public static final String COMPANIES = "companies";

    public static final String ID = "/{id}";
    
    public List<CompanyDto> companyList() {
        List <CompanyDto> companyDtoList = new ArrayList<CompanyDto>();
        companyDtoList.add( new CompanyDto( 1, "company1") );
        return companyDtoList; 
    }
        
    public void createCompany(String companyName) throws CompanyNameInvalidException {
        this.validateName(companyName);
    }
    
    public CompanyDto readCompany(int companyId) throws CompanyIdNotFoundException {
        if ( companyId == 1 ) {
            return new CompanyDto(1, "company1");
        }else {
            throw new CompanyIdNotFoundException();
        }
    }
    
    private void validateName(String name) throws CompanyNameInvalidException {
        if (name == null || name.isEmpty()) {
            throw new CompanyNameInvalidException(name);
        }
    }

    public void deleteCompany(int companyId) throws CompanyIdNotFoundException{
        if ( companyId != 1 ){
            throw new CompanyIdNotFoundException(Integer.toString(companyId));
        }
        
    }



}
