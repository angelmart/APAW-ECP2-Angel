package es.upm.miw.apaw.company.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.company.api.controllers.CompanyController;
import es.upm.miw.apaw.company.api.dtos.CompanyDto;
import es.upm.miw.apaw.company.api.resources.exceptions.CompanyIdNotFoundException;
import es.upm.miw.apaw.company.api.resources.exceptions.CompanyNameInvalidException;

public class CompanyResource {
    
    public static final String COMPANIES = "companies";

    public static final String ID = "/{id}";
    
    public List<CompanyDto> companyList() {
        
        return new CompanyController().companyList();
    }
        
    public void createCompany(String companyName) throws CompanyNameInvalidException {
        this.validateName(companyName);
        new CompanyController().createCompany(companyName);
    }
    
    public CompanyDto readCompany(int companyId) throws CompanyIdNotFoundException {
        Optional<CompanyDto> optional = new CompanyController().readCompany(companyId);
        return optional.orElseThrow(() -> new CompanyIdNotFoundException(Integer.toString(companyId)));
    }

    private void validateName(String name) throws CompanyNameInvalidException {
        if (name == null || name.isEmpty()) {
            throw new CompanyNameInvalidException(name);
        }
    }

    public void deleteCompany(int companyId) throws CompanyIdNotFoundException{
        if ( new CompanyController().deleteCompany(companyId) == false ) {
            throw new CompanyIdNotFoundException(Integer.toString(companyId));
        }
        
    }



}
