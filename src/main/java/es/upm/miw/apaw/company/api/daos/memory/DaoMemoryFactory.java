package es.upm.miw.apaw.company.api.daos.memory;

import es.upm.miw.apaw.company.api.daos.CompanyDao;
import es.upm.miw.apaw.company.api.daos.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {
    
    private CompanyDao companyDao;
    
    @Override
    public CompanyDao getCompanyDao() {
        if (companyDao == null) {
            companyDao = new CompanyDaoMemory();
        }
        return companyDao;
    }


}
