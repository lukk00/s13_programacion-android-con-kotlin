package com.example.ejercicios_consola

fun main() {
    val lenguajes = listOf("Kotlin", "Java", "Python", "C++", "JavaScript")
    println("Colección completa (${lenguajes.size} elementos): $lenguajes")

    val lenguajesCortos = lenguajes.filter { it.length <= 4 }
    println("Lenguajes con 4 letras o menos: $lenguajesCortos")
}