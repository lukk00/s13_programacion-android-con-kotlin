package com.example.ejercicios_consola

class Estudiante(val nombre: String, val edad: Int) {
    fun validarPerfil() {
        if (edad <= 0 || nombre.isBlank()) {
            println("Error de validación: El nombre no puede estar vacío y la edad debe ser mayor a 0.")
        } else {
            println("Perfil válido: $nombre, Edad: $edad años.")
        }
    }
}
fun main() {
    val estudianteValido = Estudiante("Karla", 20)
    val estudianteInvalido = Estudiante("", 18)

    println("Probando caso válido:")
    estudianteValido.validarPerfil()
    println("\nProbando caso inválido:")
    estudianteInvalido.validarPerfil()
}