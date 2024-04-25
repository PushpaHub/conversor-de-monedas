package modelos;

import com.sun.jdi.IntegerValue;
import exceptions.ElMontoPositivoException;
import exceptions.MonedasLetrasMayusculasException;
import exceptions.NoExisteMonedaDeCotizacionException;

import java.util.Scanner;

public class Datos {

    private String monedaBase;
    private String monedaDeCotizacion;
    private Double montoBase;

    String patron = "[A-Z]{3}"; //3 letras mayusculas
    private String numeroString;

    Scanner teclado = new Scanner(System.in);
    String menu = """
            ********************************************************
            COVIERTE LAS MONEDAS USANDO CÓDIGOS DE MONEDAS
            (codigos de estándar ISO 4217, tres letras mayusculas)
            Termina escribiendo letra x y precionar Enter
            ********************************************************""";

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaDeCotizacion() {
        return monedaDeCotizacion;
    }

    public Double getMontoBase() {
        return montoBase;
    }

    public String getNumeroString() {
        return numeroString;
    }

    public void RecibeDatos (){
        System.out.println(menu);

        try{
            System.out.println("Ingresa moneda base:");
            this.monedaBase = teclado.nextLine();
            if (getMonedaBase().equals("x") || getMonedaBase().equals("X")){
                System.out.println("Gracias por usar nuestro conversor de monedas.");
                System.exit(0);
            } else if (!this.monedaBase.matches(patron) ){
                throw new MonedasLetrasMayusculasException("MONEDAS DEBEN TENER 3 LETRAS MAYUSCULAS.");
            }

            System.out.println("Ingresa moneda de cotización:");
            this.monedaDeCotizacion = teclado.nextLine();
            if (getMonedaDeCotizacion().equals("x") || getMonedaDeCotizacion().equals("X")){
                System.out.println("Gracias por usar nuestro conversor de monedas.");
                System.exit(0);
            } else if (!getMonedaDeCotizacion().matches(patron)){
                throw new MonedasLetrasMayusculasException("MONEDAS DEBEN TENER 3 LETRAS MAYUSCULAS.");
            }

            System.out.println("Ingresa el monto que deseas convertir:");
            if (teclado.hasNextDouble()){
                this.montoBase = teclado.nextDouble();
                if (getMontoBase() <= 0){
                    throw new ElMontoPositivoException("EL MONTO DEBE SER NÚMERO POSITIVO.");
                }
            } else {
                this.numeroString = teclado.nextLine();
                if (getNumeroString().equals("x") || getNumeroString().equals("X")){
                    System.out.println("Gracias por usar nuestro conversor de monedas.");
                    System.exit(0);
                } else{
                    throw new ElMontoPositivoException("EL MONTO DEBE SER NÚMERO POSITIVO.");
                }
            }
        } catch (MonedasLetrasMayusculasException e){
            System.out.println(e.getMessage());
            this.montoBase = -1.0;
        } catch (ElMontoPositivoException e){
            System.out.println(e.getMessage());
            this.montoBase = -1.0;
        }

    }
}
