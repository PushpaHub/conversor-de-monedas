package modelos;

import exceptions.NoExisteMonedaDeCotizacionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Conversion {

    private String monedaBase;
    private Double montoBase;
    private String monedaDeCotizacion;
    private Double montoDeCotizacion;
    private Map<String,Double> mapaDeTasas;
    private Double tasaDeCambio;

    private String ahora; //fecha y hora presente en un string formateado
    private List<Object> nuevaConversion = new ArrayList<>();

    public String getMonedaBase() {
        return monedaBase;
    }

    public Double getMontoBase() {
        return montoBase;
    }

    public String getMonedaDeCotizacion() {
        return monedaDeCotizacion;
    }

    public Double getMontoDeCotizacion() {
        return montoDeCotizacion;
    }

    public Map<String, Double> getMapaDeTasas() {
        return mapaDeTasas;
    }

    public Double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public String getAhora() {
        return ahora;
    }

    public List<Object> getNuevaConversion() {
        return nuevaConversion;
    }

    public void Convierte(String monedaBase, Double montoBase,
                          String monedaDeCotizacion, Map<String,Double> mapaDeTasas){

        try{
            if (!mapaDeTasas.containsKey(monedaDeCotizacion)){
                throw new NoExisteMonedaDeCotizacionException("NO EXISTE ESTA MONEDA DE COTIZACIÓN. Usa el código correcto.");
            } else{
                this.tasaDeCambio = mapaDeTasas.get(monedaDeCotizacion);
                this.montoDeCotizacion = montoBase * tasaDeCambio;

                // Preparamos el siguiente String de fecha y hora
                DateTime dateTime = new DateTime();
                this.ahora = dateTime.Ahora();

                // Preparamos la siguiente conversión hecha
                nuevaConversion.add(monedaBase);
                nuevaConversion.add(montoBase);
                nuevaConversion.add(monedaDeCotizacion);
                nuevaConversion.add(tasaDeCambio);
                nuevaConversion.add(montoDeCotizacion);

                System.out.println(String.format("%,.2f %s = %,.2f %s (Tasa de cambio: 1 %s = %,.4f %s)",
                        nuevaConversion.get(1), // Monto base
                        nuevaConversion.get(0), // Moneda base
                        nuevaConversion.get(4), // Monto de cotización
                        nuevaConversion.get(2), // Moneda de cotización
                        nuevaConversion.get(0), // Moneda base (para la tasa de cambio)
                        nuevaConversion.get(3), // Tasa de cambio
                        nuevaConversion.get(2))); // Moneda de cotización (para la tasa de cambio)
            }
        }catch (NoExisteMonedaDeCotizacionException e){
            System.out.println(e.getMessage());
        }
    }

}
