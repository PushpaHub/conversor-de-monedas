package principal;

import modelos.*;
//import modelos.Conversion;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Conversor hace varias conversiones de monedas, datos ingresados desde teclado
// En el final imprime todas las conversiones hechas con fecha y hora de realización
public class Principal{
    public static void main(String[] args) {

        Boolean repetirConversiones = true;
        Map<String,Double> mapaDeTasas;
        // ArrayList para almacenar fechas y horas de conversiones hechas
        List<String> fechasYHoras = new ArrayList<>();
        // ArrayList para almacenar las conversiones hechas
        List<List<Object>> conversiones = new ArrayList<>();

        while(repetirConversiones) {
            Datos datos = new Datos();
            datos.RecibeDatos();
            if (datos.isErrorEnDatos()){
                continue;
            } else if (!datos.isExit()) {

                // Consultamos exchangerate-api.com y regresamos Map de tasas de cambio
                ConsultaTasas consulta = new ConsultaTasas();
                consulta.EncuentraTasas(datos.getMonedaBase());
                mapaDeTasas = consulta.getMapaDeTasas();
                if (!(mapaDeTasas == null)) {

                    // Encontramos la tasa de cambio y calculamos el monto de cotisación
                    Conversion conversion = new Conversion();
                    conversion.Convierte(datos.getMonedaBase(), datos.getMontoBase(),
                            datos.getMonedaDeCotizacion(), mapaDeTasas);

                    if(!(conversion.getAhora() == null) && !(conversion.getNuevaConversion() == null)){
                        fechasYHoras.add(conversion.getAhora());
                        conversiones.add(conversion.getNuevaConversion());
                    }
                }

            } else {
                Impresion impresion = new Impresion();
                impresion.Imprime(fechasYHoras, conversiones);
                repetirConversiones = false;
            }

        }

    }
}
