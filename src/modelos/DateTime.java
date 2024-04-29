package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public String Ahora(){
        // Obtiene la fecha y la hora actual
        LocalDateTime momentoActual = LocalDateTime.now();
        // Define el formato deseado para la fecha y la hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss - ");
        // Formatea la fecha y la hora utilizando el formatter definido
        String ahora = momentoActual.format(formatter);

        return ahora;
    }

}
