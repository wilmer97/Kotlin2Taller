package Kotlin16.`08`

import java.util.*
import kotlin.math.PI

fun main() {

    /* 1. Crear un programa que solicite al usuario los datos de su dirección,
    pidiendo el nombre de la calle, la ciudad, el estado o provincia, el país
     y el código postal. Imprimir en consola la dirección del usuario concatenada
     en una sola línea y separada por comas.


    val calle = solicitarEntreda("Ingrese el nombre de la calle: ")
    val ciudad = solicitarEntreda("Ingrese el nombre de la ciudad: ")
    val estado = solicitarEntreda("Ingrese el nombre de la estado: ")
    val pais = solicitarEntreda("Ingrese el nombre de la pais: ")
    val codigoPostal = solicitarEntreda("Ingrese el numero del codigoPostal: ")

    val direccion = "$calle, $ciudad, $estado, $pais, $codigoPostal"
    println("La direccion del usuario es: $direccion")
    */

    /*
    2. Crear un programa que solicite al usuario su salario mensual bruto y el porcentaje de
    impuestos que debe pagar por mes, imprimir en consola cuál será su salario neto (al mes y al año)
     y cuánto dinero debe pagar de impuestos (al mes y al año). Mostrar los datos de salida con un máximo
      de dos posiciones decimales.


    val salarioBruto = solicitarNumeroDecimal("Ingrese su salario bruto: ")
    val porcentajeImpuestos = solicitarNumeroDecimal("Ingrese el porcentaje de impuesto a pagar por mes: ")

    val salarioNetoMensual = calcularSalarioNetoMensual(salarioBruto, porcentajeImpuestos)
    val salarioNetoAnual = salarioNetoMensual * 12
    val impuestosMensuales = salarioBruto * (porcentajeImpuestos / 100)
    val impuestosAnules = impuestosMensuales * 12

    println("Salario neto mensual: \$${salarioNetoMensual.formatoDosDecimales()}")
    println("Salario neto anual: \$${salarioNetoAnual.formatoDosDecimales()}")
    println("Impuestos mensuales: \$${impuestosMensuales.formatoDosDecimales()}")
    println("Impuestos anuales: \$${impuestosAnules.formatoDosDecimales()}")
    */

    /*
    3. Crear un programa que calcule al área y el perímetro o circunferencia de un círculo, en base a lo siguiente:
    • El usuario debe ingresar solo el radio del círculo en centímetros.
    •El cálculo de los valores debe realizarse en funciones, una para el área y otra para la circunferencia.
    •Imprimir el resultado (área y circunferencia) en centímetros y en pulgadas con el mismo formato que se muestra
    en el ejemplo y con un máximo de dos posiciones decimales.


    val radio = solicitarNumeroDecimal("Ingrese el radio del circulo en centimetros: ")
    val area = calcularArea(radio)
    val circunferencia = calcularcircunferencia(radio)

    println("El area del circulo es: ${area.formatoDosDecimal()} cm² (${convertirACentimetros(area).formatoDosDecimal()} pulgadas²)")
    println("La circunferencia del circulo es: ${circunferencia.formatoDosDecimal()} cm (${convertirACentimetros(circunferencia).formatoDosDecimal()} pulgadas)")
     */

    /*
    Una empresa de transporte cobra una tarifa general de $2.25 por kilómetro de trayecto.
    Aplica una un descuento del 45% al total del viaje a personas de la tercera edad (60 años o más)
    siempre y cuando presenten una identificación que acredite su edad.
    La empresa necesita un programa en el cual el vendedor ingrese los kilómetros del trayecto,
    si se debe aplicar el descuento y que imprima el total que se debe cobrar, siempre redondeado y en números enteros.
    Hay que tener en cuenta que para agilizar el proceso, es obligatorio introducir los kilómetros del trayecto,
    pero el descuento es opcional, por lo que se puede dejar vacío.
    Se debe aplicar el descuento solo si el usuario ingresa un si o un 1 cuando se le pregunte si aplica el descuento.
     */

    val Kilometros = solicitarNumeroEntero("Ingrese la cantidad de kilometros del trayecto: ")
    val aplicaDescuento = solicitarDescuento()
    val total = calcularTotal(Kilometros, aplicaDescuento)
    println("El total a cobrar es: $total")

}

fun solicitarNumeroEntero(mensaje: String): Int {
    println(mensaje)
    return readln()?.toIntOrNull() ?: 0
}

fun solicitarDescuento(): Boolean {
    println("¿Se debe aplicar el descuento a personas de la tercera edad? (si/1 para aplicar, dejar vacio para no aplicar)")
    val respuesta = readln()

    return respuesta?.toLowerCase() == "si" || respuesta == "1"
}

fun calcularTotal(kilometros: Int, aplicaDescuento: Boolean): Int {
    val tarifa = 2.25
    val total = tarifa * kilometros

    return if (aplicaDescuento){
        val descuento = total * 0.45
        (total - descuento).toInt()
    } else{
        total.toInt()
    }
}

private fun Double.formatoDosDecimal(): String {
    return String.format("%2f")
}

fun calcularArea(radio: Double): Double {
    return PI * radio * radio
}

fun calcularcircunferencia(radio: Double): Double {
    return 2 * PI * radio
}

fun convertirACentimetros(Valor: Double): Double {
    return Valor / 2.54
}

private fun Double.formatoDosDecimales(): String {
    return String.format("%.2f", this)
}

private fun Double.formatoDosDecimales(mensaje: String): Double {
    println(mensaje)
    return readln()?.toDoubleOrNull() ?: 0.0
}

fun calcularSalarioNetoMensual(salarioBruto: Double, porcentajeImpuestos: Double): Double {
    val impuestos = salarioBruto * (porcentajeImpuestos / 100)
    return salarioBruto - impuestos
}

fun solicitarNumeroDecimal(mensaje: String): Double {
    println(mensaje)
    return readln()?.toDoubleOrNull()?: 0.0
}

fun solicitarEntreda(mensaje: String): Any {
    println(mensaje)
    return readln() ?: "" /*Este es el 1 punto*/
}







