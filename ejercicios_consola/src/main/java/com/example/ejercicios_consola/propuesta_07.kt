package com.example.ejercicios_consola

data class ConfiguracionApp(val temaOscuro: Boolean, val notificaciones: Boolean)
class GestorConfiguracion {
    private var guardado: ConfiguracionApp ?= null
    fun guardarDatos(config: ConfiguracionApp) {
        guardado = config
        println("Datos guardados exitosamente en la clase.")
    }
    fun recuperarDatos(): ConfiguracionApp {
        return guardado ?: ConfiguracionApp(temaOscuro = false, notificaciones = true)
    }
}
fun main() {
    val gestor = GestorConfiguracion()
    println("Recuperando sin guardar (Default): ${gestor.recuperarDatos()}")

    gestor.guardarDatos(ConfiguracionApp(true,false))
    println("Recuperando después de guardar: ${gestor.recuperarDatos()}")
}