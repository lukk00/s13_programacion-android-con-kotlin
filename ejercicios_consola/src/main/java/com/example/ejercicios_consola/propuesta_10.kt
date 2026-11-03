package com.example.ejercicios_consola

data class Tarea(val id: Int, val nombre: String)
fun buscarTarea(lista: List<Tarea>, palabraClave: String): List<Tarea> {
    return lista.filter { it.nombre.contains(palabraClave, ignoreCase = true) }
}
fun main() {
    val listaPendientes = listOf(
        Tarea(1, "Instalar Android Studio"),
        Tarea(2, "Aprender Kotlin"),
        Tarea(3, "Aprender a hacer reportes en VS Code y Android Studio")
    )
    val resultados = buscarTarea(listaPendientes, "Android")

    println("Tareas encontradas:")
    resultados.forEach { println("-> [ID: ${it.id}] ${it.nombre}") }
}