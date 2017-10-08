package es.upm.miw.apaw.company.api;

import es.upm.miw.apaw.company.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.company.http.HttpRequest;
import es.upm.miw.apaw.company.http.HttpResponse;
import es.upm.miw.apaw.company.http.HttpStatus;

public class Dispatcher {

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        
        try {
            
            if (request.isEqualsPath("companies")) {
                response.setBody("[{\"id\":1,\"name\":\"company1\"}]");
            }else if ( request.isEqualsPath("companies" + "/{id}") ) {
                
                if ( Integer.valueOf(request.paths()[1]) == 1 ) {
                    response.setBody("{\"id\":1,\"name\":\"company1\"}");
                }else {
                    throw new Exception();
                }
            } else {
                throw new RequestInvalidException(request.getPath());
            }
            

        } catch (Exception e) {
            responseError(response, e);
        }

    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            
            if ( request.isEqualsPath("companies") ) {
                
                if ( request.getBody().isEmpty() || request.getBody() == null ) {
                    throw new Exception();
                }else {
                    response.setStatus(HttpStatus.CREATED);
                }                
                
            
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
            
            if ( request.isEqualsPath("companies" + "/{id}") ){
                
                if ( Integer.valueOf(request.paths()[1]) != 1 ) {
                    throw new Exception();
                }
                
            }else {
                throw new RequestInvalidException(request.getPath());
            }
            
        }catch (Exception e) {
            responseError(response, new RequestInvalidException(request.getPath()));
        }   
    }

}
