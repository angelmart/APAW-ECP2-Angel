package es.upm.miw.apaw.company.api.resources;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.company.api.dtos.StaffDto;
import es.upm.miw.apaw.company.api.resources.exceptions.StaffInvalidException;

public class StaffResource {
    
    public static final String STAFFS = "staffs";

    public void createStaff(String staffName) throws StaffInvalidException{
        this.validateName(staffName);
    }

    public List<StaffDto> staffList() {
        List<StaffDto> staffDtoList = new ArrayList<>();
        staffDtoList.add( new StaffDto( "Pepito" ));
        staffDtoList.add( new StaffDto( "Federico" ));
        
        return staffDtoList;
    }
    
    private void validateName(String name) throws StaffInvalidException {
        if (name == null || name.isEmpty()) {
            throw new StaffInvalidException(name);
        }
    }

}
