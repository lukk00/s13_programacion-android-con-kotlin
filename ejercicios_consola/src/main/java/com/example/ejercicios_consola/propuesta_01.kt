package com.example.ejercicios_consola

fun main() {
    val listaCasos = mutableListOf("Caso inicial A", "Caso inicial B", "Caso inicial C")
    listaCasos.add("Caso adicional D")
    listaCasos.add("Caso adicional E")

    println("--- Lista de casos actualizada ---")
    listaCasos.forEachIndexed { i, caso -> println("${i + 1}: $caso")
    }
}
