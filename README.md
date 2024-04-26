# Conversor de monedas

  <img src="ImagenPortada3B.jpg" alt="Imagen de portada - Cambio de divisas" style="width: 100%;">

Esta aplicación hace la conversión entre cualquieras dos monedas de la lista de ISO 4217 (Three Letter Currency Code) que los cubre exchangerate-api.com.

## Descripción del proyecto
Esta aplicación fué mi tarea en ONE (Oracle Next Eucation) en la parte de Java orientado a objetos. En este proyecto se incluyeron procesos muy importantes de programación en Java.

- Definición y uso de clases Modelos
- Definición y uso de una API para obtener datos
- Uso de Biblioteca Gson.jar
- Definición y uso de clase tipo record
- Manejo de errores/exceptiones
##
La aplicación está organizada en tres paquetes (package):
- principal
    - Principal.java
- modelos
    - Datos.java
    - ConsultaConversion.java
    - Conversion.java
    - ConversionGson.java
- exceptions
    - MonedasLetrasMayusculasException.java
    - ElMontoPositivoException.java
    - NoExisteMonedaBaseException.java
    - NoExisteMonedaDeCotizacionException.java
##
En la siguinte imagen UML se muestran los atributos y métodos de las clases y la conexión entre las clases:
![UML del proyecto](ConversorDeMonedasUML3.jpeg)

## Estado del proyecto
El proyecto está finalizado, pero se presta a incluir funcionalidades adicionales.

## Demostración de aplicación

<p align="left">
  <img src="Captura de pantalla (1452)A-1.png" alt="Descripción de la imagen 1" style="width: 45%;">
  <img src="Captura de pantalla (1456)A.png" alt="Descripción de la imagen 2" style="width: 45%;">
</p>
<p align="left">
  <img src="Captura de pantalla (1457)A-1.png" alt="Descripción de la imagen 1" style="width: 45%;">
  <img src="Captura de pantalla (1459)A-2.png" alt="Descripción de la imagen 2" style="width: 45%;">
</p>

## Tecnologías usadas
- La aplicación está hecha en Java ver 17
- Para desarollar el código usé IntelliJ.
- Para preparar la imagen UML me apoye con lucidchart.com

## Licencia
GNU General Public License v3.0
