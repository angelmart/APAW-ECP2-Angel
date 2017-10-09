package es.upm.miw.apaw.company;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.company.api.daos.DaoFactory;
import es.upm.miw.apaw.company.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.company.api.resources.StaffResource;
import es.upm.miw.apaw.company.http.HttpClientService;
import es.upm.miw.apaw.company.http.HttpException;
import es.upm.miw.apaw.company.http.HttpMethod;
import es.upm.miw.apaw.company.http.HttpRequest;
import es.upm.miw.apaw.company.http.HttpRequestBuilder;

public class StaffResourceFunctionalTesting {

    private HttpRequest request;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        request = new HttpRequest();
    }
    
    private void createStaffOne() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(StaffResource.STAFFS).body("Pepito").build();
        new HttpClientService().httpRequest(request);
    }
    
    private void createStaffTwo() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(StaffResource.STAFFS).body("Federico").build();
        new HttpClientService().httpRequest(request);
    }

    private void createStaffs() {
        this.createStaffOne();
        this.createStaffTwo();
        
    }
    
    @Test
    public void testCreateStaff() {
        this.createStaffs();
    }
    
    @Test
    public void testCreateStaffNameEmpty() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(StaffResource.STAFFS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateStaffWithoutName() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(StaffResource.STAFFS).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadStaff() {
        this.createStaffOne();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(StaffResource.STAFFS).path(StaffResource.ID)
                .expandPath("1").build();
        assertEquals("{\"name\":\"Pepito\"}", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test(expected = HttpException.class)
    public void testReadStaffStaffIdNotFound() {
        this.createStaffOne();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(StaffResource.STAFFS).path(StaffResource.ID)
                .expandPath("2").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testStaffList() {
        this.createStaffs();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(StaffResource.STAFFS).build();
        assertEquals("[{\"name\":\"Pepito\"}, {\"name\":\"Federico\"}]",
                new HttpClientService().httpRequest(request).getBody());
    }


    
    

}
