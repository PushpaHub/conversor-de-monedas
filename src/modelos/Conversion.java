package modelos;

import exceptions.NoExisteMonedaDeCotizacionException;

import java.util.Map;

public class Conversion {

    private Map<String,Double> mapaDeConverciones;
    private Double conversion;
    private Double montoDeCotizacion;

    public Conversion(ConversionGson miConversion) {
        this.mapaDeConverciones = miConversion.conversion_rates();
    }

    public Map<String, Double> getMapaDeConverciones() {
        return mapaDeConverciones;
    }

    public Double getConversion() {
        return conversion;
    }

    public Double getMontoDeCotizacion() {
        return montoDeCotizacion;
    }

    public Double Convierte(String moneda, Double monto){

        try{
            if (!mapaDeConverciones.containsKey(moneda)){
                throw new NoExisteMonedaDeCotizacionException("NO EXISTE ESTA MONEDA DE COTIZACIÓN. Usa el código correcto.");
            } else{
                this.conversion = mapaDeConverciones.get(moneda);
                this.montoDeCotizacion = monto * getConversion();
                return montoDeCotizacion;
            }
        }catch (NoExisteMonedaDeCotizacionException e){
            System.out.println(e.getMessage());
            return (-1.0);
        }
    }

}
