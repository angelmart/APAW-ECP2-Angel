package es.upm.miw.apaw.company.api.dtos;

import es.upm.miw.apaw.company.api.entities.Company;

public class CompanyDto {
    
    private int id;

    private String name;
    
    public CompanyDto( int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
    }

    public int getId() {
        return id;
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
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }


}
