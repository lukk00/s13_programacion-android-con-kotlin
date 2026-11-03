package com.example.ejercicios_consola

enum class EstadoRed { CARGANDO, EXITO, ERROR }
fun simularDescarga(dato: String?) {
    var estado = EstadoRed.CARGANDO
    println("1. Estado inicial: $estado...")
    try {
        val contenido = dato ?: throw IllegalArgumentException("No se recibió información")
        estado = EstadoRed.EXITO
        println("2. Estado final: $estado -> Dato: $contenido")
    } catch (e: Exception) {
        estado = EstadoRed.ERROR
        println("2. Estado final: $estado -> Motivo: ${e.message}")
    }
}
fun main() {
    println("--- Intento exitoso ---")
    simularDescarga("Paquete de datos al 100%")

    println("\n--- Intento fallido ---")
    simularDescarga(null)
}