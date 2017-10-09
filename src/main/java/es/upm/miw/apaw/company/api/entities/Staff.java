package es.upm.miw.apaw.company.api.entities;

public class Staff {
    
    private int id;
    private String familyName;
    private String country;
    
    public Staff( String familyName ) {
        this.id = 0;
        this.familyName = familyName;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFamilyName() {
        return this.familyName;
    }
    
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Staff [id=" + id + ", familyName=" + familyName + ", country=" + country + "]";
    }
    
    

}
