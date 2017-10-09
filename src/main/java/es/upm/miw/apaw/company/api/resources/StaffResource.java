package es.upm.miw.apaw.company.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.company.api.controllers.StaffController;
import es.upm.miw.apaw.company.api.dtos.StaffDto;
import es.upm.miw.apaw.company.api.resources.exceptions.StaffIdNotFoundException;
import es.upm.miw.apaw.company.api.resources.exceptions.StaffInvalidException;

public class StaffResource {
    
    public static final String STAFFS = "staffs";
    
    public static final String ID = "/{id}";

    public void createStaff(String staffName) throws StaffInvalidException{
        this.validateName(staffName);
        new StaffController().createStaff(staffName);
    }

    public List<StaffDto> staffList() {
        return new StaffController().staffList();
    }
    
    public StaffDto readStaff(int staffId) throws StaffIdNotFoundException {
        Optional<StaffDto> optional = new StaffController().readStaff(staffId);
        return optional.orElseThrow(() -> new StaffIdNotFoundException(Integer.toString(staffId)));
    }
    
    private void validateName(String name) throws StaffInvalidException {
        if (name == null || name.isEmpty()) {
            throw new StaffInvalidException(name);
        }
    }

}
