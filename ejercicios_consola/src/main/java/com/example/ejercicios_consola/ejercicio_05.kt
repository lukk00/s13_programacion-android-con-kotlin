package com.example.ejercicios_consola

fun esValido(valor: String) = valor.isNotBlank()
fun main() { listOf("muestra", "   ", "").forEach { println(esValido(it)) } }
