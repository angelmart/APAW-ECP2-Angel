package es.upm.miw.apaw.company.api.dtos;

import es.upm.miw.apaw.company.api.entities.Staff;

public class StaffDto {
    
    private int id;
    private String name;
    
    public StaffDto(String name) {
        this.id = 0;
        this.name = name;
    }
    
    public StaffDto( Staff staff ) {
        this.id = staff.getId();
        this.name = staff.getFamilyName();
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\"}";
    }
}
