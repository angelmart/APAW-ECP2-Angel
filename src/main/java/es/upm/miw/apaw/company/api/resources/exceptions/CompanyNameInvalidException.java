package es.upm.miw.apaw.company.api.resources.exceptions;

public class CompanyNameInvalidException extends Exception{
    
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre de la empresa incorrecto";

    public CompanyNameInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CompanyNameInvalidException() {
        this("");
    }

}

