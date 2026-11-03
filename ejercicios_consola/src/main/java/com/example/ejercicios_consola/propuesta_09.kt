package com.example.ejercicios_consola

fun main() {
    val cantidadDeUsuariosRegistrados = 150
    val estaElSistemaActivo = false

    val mensajeDeEstado = if (estaElSistemaActivo) {
        "[EN LÍNEA] El sistema está operando con $cantidadDeUsuariosRegistrados usuarios."
    } else {
        "[CAÍDO] El sistema se encuentra actualmente en mantenimiento."
    }
    println(mensajeDeEstado)
}