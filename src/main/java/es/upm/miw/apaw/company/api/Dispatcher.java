package es.upm.miw.apaw.company.api;

import es.upm.miw.apaw.company.api.resources.CompanyResource;
import es.upm.miw.apaw.company.api.resources.StaffResource;
import es.upm.miw.apaw.company.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.company.http.HttpRequest;
import es.upm.miw.apaw.company.http.HttpResponse;
import es.upm.miw.apaw.company.http.HttpStatus;

public class Dispatcher {
    
    private CompanyResource companyResource = new CompanyResource();
    
    private StaffResource staffResource = new StaffResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        
        try {
            
            if (request.isEqualsPath(CompanyResource.COMPANIES)) {
                response.setBody(companyResource.companyList().toString());
            }else if ( request.isEqualsPath(CompanyResource.COMPANIES + CompanyResource.ID) ) {
                response.setBody(companyResource.readCompany(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath("staffs")) {
                response.setBody(staffResource.staffList().toString());
            }else if ( request.isEqualsPath("staffs" + "/{id}" ) ){
                response.setBody(staffResource.readStaff(Integer.valueOf(request.paths()[1])).toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
            

        } catch (Exception e) {
            responseError(response, e);
        }

    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            
            if ( request.isEqualsPath(CompanyResource.COMPANIES) ) {
                companyResource.createCompany( request.getBody() );
                response.setStatus(HttpStatus.CREATED);
                
            } else if (request.isEqualsPath("staffs")) {
                staffResource.createStaff(request.getBody());
                response.setStatus(HttpStatus.CREATED);

            }else {
                throw new RequestInvalidException(request.getPath());
            }

        } catch (Exception e) {
            responseError(response, e);
        }
        
        
        
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        try {
            
            if ( request.isEqualsPath(CompanyResource.COMPANIES + CompanyResource.ID) ){
                companyResource.deleteCompany(Integer.valueOf(request.paths()[1]));
                
            }else {
                throw new RequestInvalidException(request.getPath());
            }
            
        }catch (Exception e) {
            responseError(response, new RequestInvalidException(request.getPath()));
        }   
    }

}
