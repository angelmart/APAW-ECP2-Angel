package es.upm.miw.apaw.company;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.company.http.HttpClientService;
import es.upm.miw.apaw.company.http.HttpException;
import es.upm.miw.apaw.company.http.HttpMethod;
import es.upm.miw.apaw.company.http.HttpRequest;
import es.upm.miw.apaw.company.http.HttpRequestBuilder;

public class StaffResourceFunctionalTesting {

    private HttpRequest request;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private void createStaffs() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("staffs").body("Pepito").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("staffs").body("Federico").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateStaff() {
        this.createStaffs();
    }
    
    @Test
    public void testCreateStaffNameEmpty() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("staffs").body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateStaffWithoutName() {
        exception.expect(HttpException.class);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("staffs").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testStaffList() {
        this.createStaffs();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path("staffs").build();
        assertEquals("[{\"name\":Pepito}, {\"name\":Federico}]",
                new HttpClientService().httpRequest(request).getBody());
    }


    
    

}
