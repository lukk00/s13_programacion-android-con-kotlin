package com.example.ejercicios_consola

fun main() {
  val texto = "Esto no es un número"
  val numero = texto.toIntOrNull()
  println(numero ?: "El dato no es válido")
}
