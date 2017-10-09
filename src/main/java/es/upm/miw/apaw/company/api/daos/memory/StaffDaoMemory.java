package es.upm.miw.apaw.company.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.company.api.daos.StaffDao;
import es.upm.miw.apaw.company.api.entities.Staff;

public class StaffDaoMemory extends GenericDaoMemory<Staff> implements StaffDao {

    public StaffDaoMemory() {
        this.setMap(new HashMap<Integer, Staff>());
    }

    @Override
    protected Integer getId(Staff entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Staff entity, Integer id) {
        entity.setId(id);
    }

}
