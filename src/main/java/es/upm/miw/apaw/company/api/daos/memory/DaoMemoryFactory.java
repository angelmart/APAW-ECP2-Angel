package es.upm.miw.apaw.company.api.daos.memory;

import es.upm.miw.apaw.company.api.daos.CompanyDao;
import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.daos.StaffDao;

public class DaoMemoryFactory extends DaoFactory {
    
    private CompanyDao companyDao;
    
    private StaffDao staffDao;
    
    @Override
    public CompanyDao getCompanyDao() {
        if (companyDao == null) {
            companyDao = new CompanyDaoMemory();
        }
        return companyDao;
    }
    
    @Override
    public StaffDao getStaffDao() {
        if (staffDao == null) {
            staffDao = new StaffDaoMemory();
        }
        return staffDao;
    }


}
