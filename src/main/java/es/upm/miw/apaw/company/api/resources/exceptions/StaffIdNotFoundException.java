package es.upm.miw.apaw.company.api.resources.exceptions;

public class StaffIdNotFoundException extends Exception{

    private static final long serialVersionUID = -451191564468834631L;
    
    public static final String DESCRIPTION = "El personal con ese id no existe";

    public StaffIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public StaffIdNotFoundException() {
        this("");
    }
}
