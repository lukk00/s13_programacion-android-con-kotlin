package com.example.ejercicios_consola

fun procesarDatoNumerico(entrada: String): Int? {
    return entrada.toIntOrNull()
}
fun main() {
    val textosAProbar = listOf("42", "código invalido", "150,99", "")

    textosAProbar.forEach { texto ->
        val resultadoSeguro = procesarDatoNumerico(texto)
        println("Entrada: '$texto' -> Resultado: ${resultadoSeguro ?: "El dato no es un número válido"}")
    }
}