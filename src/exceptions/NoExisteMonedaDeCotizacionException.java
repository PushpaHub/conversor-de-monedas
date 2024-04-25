package exceptions;

public class NoExisteMonedaDeCotizacionException extends RuntimeException {

    private String mensaje;
    public NoExisteMonedaDeCotizacionException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
