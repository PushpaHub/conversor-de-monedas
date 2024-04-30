package modelos;

import java.util.List;

// Clase Impresión está encargada de la impresión final.
public class Impresion {

    // Método Imprime obtiene dos parametros: la lista de strings que contienen
    // la fecha y la hora de las conversiones y la lista de los datos de cada
    // conversión que también son listas. El resultado es la impresión de todas
    // las conversiones con sus fechas y horas de realización.
    public void Imprime (List<String> fechasYHoras, List<List<Object>> conversiones){

        System.out.println("Gracias por usar nuestro conversor de monedas.");
        System.out.println();
        System.out.println("LA LISTA DE CONVERSIONES QUE REALIZASTE:");

        if (!fechasYHoras.isEmpty() && !conversiones.isEmpty()) {
            for (int i = 0; i < fechasYHoras.size(); i++) {
                System.out.print(fechasYHoras.get(i) + " ");
                System.out.println(String.format("%,.2f %s = %,.2f %s (Tasa de cambio: 1 %s = %,.4f %s)",
                        conversiones.get(i).get(1), // Monto base
                        conversiones.get(i).get(0), // Moneda base
                        conversiones.get(i).get(4), // Monto de cotización
                        conversiones.get(i).get(2), // Moneda de cotización
                        conversiones.get(i).get(0), // Moneda base (para la tasa de cambio)
                        conversiones.get(i).get(3), // Tasa de cambio
                        conversiones.get(i).get(2))); // Moneda de cotización (para la tasa de cambio)
            }
        } else {
            System.out.println("No realizaste ninguna conversión.");
        }

    }

}
