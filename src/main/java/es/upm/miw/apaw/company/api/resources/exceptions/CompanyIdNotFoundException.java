package es.upm.miw.apaw.company.api.resources.exceptions;

public class CompanyIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "La empresa con ese id no existe";

    public CompanyIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CompanyIdNotFoundException() {
        this("");
    }
}
