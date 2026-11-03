package com.example.ejercicios_consola

fun evaluarStock(cantidad: Int): String {
    return when {
        cantidad in 1..99 -> "Stock normal (Válido)"
        cantidad == 100 -> "Almacén lleno (Límite)"
        cantidad <= 0 || cantidad > 100 -> "Fuera de rango (Inválido)"
        else -> "Error"
    }
}
fun main() {
    println("Prueba 1 (Válido - 50): ${evaluarStock(34)}")
    println("Prueba 2 (Límite - 100): ${evaluarStock(100)}")
    println("Prueba 3 (Inválido - -5): ${evaluarStock(-13)}")
}