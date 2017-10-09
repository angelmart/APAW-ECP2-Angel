package es.upm.miw.apaw.company.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.dtos.CompanyDto;
import es.upm.miw.apaw.company.api.entities.Company;
import es.upm.miw.apaw.company.api.resources.exceptions.CompanyIdNotFoundException;

public class CompanyController {
    
    public List<CompanyDto> companyList() {
        List<Company> companyList = DaoFactory.getFactory().getCompanyDao().findAll();
        List<CompanyDto> companyDtoList = new ArrayList<>();
        for (Company company : companyList) {
            companyDtoList.add(new CompanyDto(company));
        }
        return companyDtoList;
    }
    
    public void createCompany(String companyName) {
        DaoFactory.getFactory().getCompanyDao().create(new Company(companyName));
    }
    
    private boolean existCompanyId(int companyId) {
        return DaoFactory.getFactory().getCompanyDao().read(companyId) != null;
    }
    
    public Optional<CompanyDto> readCompany(int companyId) {
        if (existCompanyId(companyId)) {
             return Optional.of(new CompanyDto(DaoFactory.getFactory().getCompanyDao().read(companyId)));
         } else {
             return Optional.empty();
         }
     }

    public boolean deleteCompany(int companyId) {
        if (existCompanyId(companyId)) {
            DaoFactory.getFactory().getCompanyDao().deleteById(companyId);
            return true;
        } else {
            return false;
        }
        
        
        
    }

}
