package com.example.ejercicios_consola

// CONCEPTO 1: Clases (Modelado de datos)
data class Producto(val id: Int, val nombre: String, var stock: Int)

class GestorInventario {
    // CONCEPTO 2: Colecciones (Lista mutable para almacenar el inventario)
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
        println("Producto (${producto.nombre}) agregado correctamente!")
    }

    // CONCEPTO 3: Funciones, Excepciones y Null Safety
    fun mostrarInventario() {
        println("\nInventario Actual:")
        productos.forEach { println(" - [${it.id}] ${it.nombre}: ${it.stock} uds.") }
    }

    fun retirarStock(id: Int, cantidadRestar: Int) {
        // Uso de null safety: find devuelve el producto o null si no existe
        val producto = productos.find { it.id == id }

        if (producto == null) {
            println("¡! Error: Producto con ID $id no encontrado.")
            return
        }

        // Validación de caso límite (evitar stock negativo)
        if (producto.stock - cantidadRestar < 0) {
            println("¡! Límite excedido: No hay suficiente stock de '${producto.nombre}'. Stock actual: ${producto.stock}")
        } else {
            producto.stock -= cantidadRestar
            println("\nRetiro exitoso: '${producto.nombre}' bajó a ${producto.stock} unidades.")
        }
    }
}

fun main() {
    val inventario = GestorInventario()
    inventario.agregarProducto(Producto(1, "Laptop X", 10))
    inventario.agregarProducto(Producto(2, "Mouse Inalámbrico", 25))

    println("--- CASO NORMAL ---")
    inventario.mostrarInventario()
    inventario.retirarStock(2, 5) // Retira 5 mouses correctamente
    inventario.mostrarInventario()

    println("\n--- CASOS LÍMITE Y ERROR ---")
    inventario.retirarStock(1, 15) //Intenta retirar más laptops de las que hay (Caso Límite)
    inventario.retirarStock(99, 1) // Intenta retirar un ID inexistente (Null Safety)
}