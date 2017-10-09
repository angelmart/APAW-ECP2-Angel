package es.upm.miw.apaw.company.api.builder;

import es.upm.miw.apaw.company.api.entities.Staff;

public class StaffBuilder {
    
    private Staff staff;
    
    public StaffBuilder( String familyName ) {
        this.staff = new Staff( familyName );
    }
    
    public StaffBuilder id( int id ) {
        this.staff.setId( id );
        return this;
    }
    
    
    public StaffBuilder familyName( String familyName ) {
        this.staff.setFamilyName( familyName );
        return this;
    }
    
    public StaffBuilder country( String country ) {
        this.staff.setCountry( country );
        return this;
    }

    public Staff build() {
        return this.staff;
    }
}
