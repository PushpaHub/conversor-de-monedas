package modelos;

import com.sun.jdi.IntegerValue;
import exceptions.ElMontoPositivoException;
import exceptions.MonedasLetrasMayusculasException;
import exceptions.NoExisteMonedaDeCotizacionException;

import java.util.Scanner;

public class Datos {
// Clase Datos se encarga de proporcionar datos para converción

    private String monedaBase;
    private String monedaDeCotizacion;
    private Double montoBase;
    private boolean errorEnDatos = false;
    private boolean exit = false;

    String patron = "[A-Z]{3}"; //3 letras mayusculas

    Scanner teclado = new Scanner(System.in);
    String menu = """
            ********************************************************
            COVIERTE LAS MONEDAS USANDO CÓDIGOS DE MONEDAS
            (codigos de estándar ISO 4217, tres letras mayusculas)
            Termina precionando Enter sin escribir nada
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

    public boolean isErrorEnDatos() {
        return errorEnDatos;
    }

    public boolean isExit() {
        return exit;
    }

    // Método RecibeDatos() lee datos ingresados del teclado y nos proporciona:
    // moneda base, moneda de cotizacion y monto para convertir
    // En caso de error de teclado regresa valor errorEnDatos = true y
    // la clase Principal (main) retoma el proceso desde inicio
    public void RecibeDatos (){
        System.out.println(menu);

        try {
            System.out.println("Ingresa moneda base:");
            this.monedaBase = teclado.nextLine();
            if (getMonedaBase().isEmpty()) {
                this.exit = true;
            } else if (!this.monedaBase.matches(patron) ){
                throw new MonedasLetrasMayusculasException("MONEDAS DEBEN TENER 3 LETRAS MAYUSCULAS.");
            } else {

                System.out.println("Ingresa moneda de cotización:");
                this.monedaDeCotizacion = teclado.nextLine();
                if (getMonedaDeCotizacion().isEmpty()){
                    this.exit = true;
                } else if (!getMonedaDeCotizacion().matches(patron)){
                    throw new MonedasLetrasMayusculasException("MONEDAS DEBEN TENER 3 LETRAS MAYUSCULAS.");
                } else {

                    System.out.println("Ingresa el monto que deseas convertir:");
                    String entrada = teclado.nextLine();
                    if (entrada.isEmpty()) {
                        this.exit = true;
                    } else {
                        // Convertir la entrada a un número Double, si no es, catch (NumberFormatException e)
                        this.montoBase = Double.parseDouble(entrada);
                        if (getMontoBase() <= 0){
                            throw new ElMontoPositivoException("EL MONTO DEBE SER NÚMERO POSITIVO.");
                        }
                    }
                }
            }
        } catch (MonedasLetrasMayusculasException e) {
            System.out.println(e.getMessage());
            this.errorEnDatos = true;
        } catch (NumberFormatException e) {
            System.out.println("EL MONTO DEBE SER NÚMERO POSITIVO.");
            this.errorEnDatos = true;
        } catch (ElMontoPositivoException e){
            System.out.println(e.getMessage());
            this.errorEnDatos = true;
        }

    }
}
