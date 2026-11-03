package com.example.ejercicios_consola

class Servicio { fun ejecutar(entrada: String) = entrada.trim().lowercase() }
fun main() = println(Servicio().ejecutar("cOleCCiONes"))
