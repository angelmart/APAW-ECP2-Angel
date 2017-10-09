package es.upm.miw.apaw.company.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.company.api.daos.CompanyDao;
import es.upm.miw.apaw.company.api.entities.Company;

public class CompanyDaoMemory extends GenericDaoMemory<Company> implements CompanyDao {

    public CompanyDaoMemory() {
        this.setMap(new HashMap<Integer, Company>());
    }

    @Override
    protected Integer getId(Company entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Company entity, Integer id) {
        entity.setId(id);

    }

}
