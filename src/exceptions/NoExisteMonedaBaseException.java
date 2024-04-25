package exceptions;

public class NoExisteMonedaBaseException extends RuntimeException {

    private String mensaje;
    public NoExisteMonedaBaseException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }

}
