package principal;

import modelos.ConsultaConversion;
import modelos.Conversion;
import modelos.ConversionGson;
import modelos.Datos;

import java.io.IOException;

public class Principal{
    public static void main(String[] args) {

        ConversionGson mapaDeConversiones;
        Double montoDeCotizacion;

        while(true) {
            Datos datos = new Datos();
            datos.RecibeDatos();
            if (datos.getMontoBase() == -1.0){
                continue;
            }

            //Consultamos exchangerate.com y regresamos Gson
            ConsultaConversion consulta = new ConsultaConversion();
            mapaDeConversiones = consulta.BuscaConversiones(datos.getMonedaBase());
            if (mapaDeConversiones == null) {
                continue;

            } else {
                //Calculamos el monto de cotización
                Conversion conversion = new Conversion(mapaDeConversiones);
                montoDeCotizacion = conversion.Convierte(datos.getMonedaDeCotizacion(), datos.getMontoBase());
                if (montoDeCotizacion == -1.0){
                    continue;
                }
            }

            System.out.println(String.format("%.2f %s = %.2f %s", datos.getMontoBase(), datos.getMonedaBase(),
                    montoDeCotizacion, datos.getMonedaDeCotizacion()));

        }

    }
}
