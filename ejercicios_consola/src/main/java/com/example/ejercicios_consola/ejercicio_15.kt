package com.example.ejercicios_consola

fun main() {
    val tareas = listOf("Uno", "Dos", "Tres")
    tareas.forEachIndexed { i, t -> println("${i}. $t") }
}
