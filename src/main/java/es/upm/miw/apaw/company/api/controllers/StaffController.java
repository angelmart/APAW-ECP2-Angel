package es.upm.miw.apaw.company.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.dtos.StaffDto;
import es.upm.miw.apaw.company.api.entities.Staff;

public class StaffController {

    public void createStaff(String staffFamilyName) {
        DaoFactory.getFactory().getStaffDao().create(new Staff(staffFamilyName));
    }
    
    public List<StaffDto> staffList() {
        List<StaffDto> staffDtoList = new ArrayList<>();
        List<Staff> staffs = DaoFactory.getFactory().getStaffDao().findAll();
        for (Staff staff : staffs) {
            staffDtoList.add(new StaffDto(staff));
        }
        return staffDtoList;
    }
    
    private boolean existStaffId(int staffId) {
        return DaoFactory.getFactory().getStaffDao().read(staffId) != null;
    }
    
    public Optional<StaffDto> readStaff(int staffId) {
        if (existStaffId(staffId)) {
             return Optional.of(new StaffDto(DaoFactory.getFactory().getStaffDao().read(staffId)));
         } else {
             return Optional.empty();
         }
     }
 
}

