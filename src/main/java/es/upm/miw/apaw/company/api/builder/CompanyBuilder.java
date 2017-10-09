package es.upm.miw.apaw.company.api.builder;

import es.upm.miw.apaw.company.api.entities.Company;
import es.upm.miw.apaw.company.api.entities.Size;
import es.upm.miw.apaw.company.api.entities.Staff;

public class CompanyBuilder {
    
    private Company company;
    
    public CompanyBuilder( String name ) {
        this.company = new Company(name);
    }
    
    public CompanyBuilder staff( Staff staff ) {
        this.company.addStaff( staff );
        return this;
    }
    
    public CompanyBuilder id(int id) {
        this.company.setId( id );
        return this;
    }
    
    public CompanyBuilder name( String name ) {
        this.company.setName( name );
        return this;
    }
    
    public CompanyBuilder address( String address ) {
        this.company.setAddress( address );
        return this;
    }
    
    public CompanyBuilder size( Size size ) {
        this.company.setSize( size );
        return this;
    }
    
    public Company build() {
        return this.company;
    }

    
}