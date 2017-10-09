package es.upm.miw.apaw.company.api.resources.exceptions;

public class StaffInvalidException extends Exception {
    private static final long serialVersionUID = -5173361541880534566L;

    public static final String DESCRIPTION = "Nombre del personal incorrecto";

    public StaffInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public StaffInvalidException() {
        this("");
    }

}
