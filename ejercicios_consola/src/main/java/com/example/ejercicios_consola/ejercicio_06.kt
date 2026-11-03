package com.example.ejercicios_consola

fun main() {
  val registros = mutableListOf("A", "B")
  registros.add("C")
  registros.add(0,"prueba")
  println("$registros; total=${registros.size}")
}
