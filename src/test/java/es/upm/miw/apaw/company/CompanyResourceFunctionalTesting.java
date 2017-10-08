package es.upm.miw.apaw.company;

import static org.junit.Assert.*;

import org.junit.Test;

import es.upm.miw.apaw.company.http.HttpClientService;
import es.upm.miw.apaw.company.http.HttpException;
import es.upm.miw.apaw.company.http.HttpMethod;
import es.upm.miw.apaw.company.http.HttpRequest;
import es.upm.miw.apaw.company.http.HttpRequestBuilder;

public class CompanyResourceFunctionalTesting {

    
    private void createCompany() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("companies").body("company1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateCompany() {
        this.createCompany();
    }

    @Test(expected = HttpException.class)
    public void testCreateCompanyNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("companies").body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutCompanyName() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("companies").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadCompany() {
        this.createCompany();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("companies").path("/{id}")
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"company1\"}", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test
    public void testCompanyList() {
        this.createCompany();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("companies").build();
        assertEquals("[{\"id\":1,\"name\":\"company1\"}]", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test
    public void testDeleteCompany() {
        this.createCompany();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path("companies").path("/{id}")
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testDeleteCompanyCompanyIdNotFoundException() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path("companies").path("/{id}")
                .expandPath("2").build();
        new HttpClientService().httpRequest(request);
    }

    

}
