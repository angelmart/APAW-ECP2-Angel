package es.upm.miw.apaw.company.api.entities;

import java.util.ArrayList;
import java.util.List;

public class Company {
    
    private int id;
    private String name;
    private String address;
    private List <Staff> staffs;
    private Size size;
    
    public Company( String companyName ) {
        this.id = 0;
        this.name = companyName;
        this.staffs = new ArrayList<>();
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public List<Staff> getStaff(){
        return this.staffs;
    }
    
    public void addStaff(Staff staff) {
        this.staffs.add(staff);
    }
    
    public Size getSize() {
        return this.size;
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", address=" + address
                + ", staff=" + staffs + ", size=" + size + "]";
    }
}
