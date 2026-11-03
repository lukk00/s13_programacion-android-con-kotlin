package com.example.s13_kotlin_interfazprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// 1. LÓGICA ADAPTADA PARA PANTALLAS (Con State)
data class Producto(val id: Int, val nombre: String, val stock: Int)

class GestorInventario {
    // 2. Usamos mutableStateListOf para que la pantalla "escuche" cada vez que la lista cambia
    val productos = mutableStateListOf<Producto>()

    fun agregarProducto(id: Int, nombre: String, stock: Int): String {
        if (productos.any { it.id == id }) return "¡! Error: El ID $id ya existe."
        productos.add(Producto(id, nombre, stock)) // Compose detecta que se agregó algo nuevo
        return "✅ Producto ($nombre) agregado correctamente!"
    }

    fun retirarStock(id: Int, cantidadRestar: Int): String {
        // Buscamos la posición (índice) del producto en la lista
        val index = productos.indexOfFirst { it.id == id }
        if (index == -1) return "¡! Error: Producto con ID $id no encontrado."

        val producto = productos[index]
        if (producto.stock - cantidadRestar < 0) {
            return "¡! Límite excedido: Solo hay ${producto.stock} uds."
        }

        // 3. EL TRUCO: Reemplazamos el producto antiguo por uno nuevo usando .copy()
        // Al modificar el índice directamente, Compose se da cuenta y actualiza la UI
        productos[index] = producto.copy(stock = producto.stock - cantidadRestar)

        return "✅ Retiro exitoso: '${producto.nombre}' bajó a ${productos[index].stock} uds."
    }
}

// 2. INTERFAZ VISUAL COMPLETA
@Composable
fun PantallaInventarioCompleta(inventario: GestorInventario) {
    var mensajeConsola by remember { mutableStateOf("Bienvenido al sistema.") }

    // Variables temporales para lo que el usuario escribe en pantalla
    var inputIdAgregar by remember { mutableStateOf("") }
    var inputNombre by remember { mutableStateOf("") }
    var inputStock by remember { mutableStateOf("") }

    var inputIdRetirar by remember { mutableStateOf("") }
    var inputRetiro by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Text(text = "📦 Gestor de Inventario", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Estado: $mensajeConsola", color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(vertical = 8.dp))

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        // SECCIÓN: AGREGAR PRODUCTO
        Text(text = "➕ Agregar Producto", style = MaterialTheme.typography.titleMedium)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            OutlinedTextField(value = inputIdAgregar, onValueChange = { inputIdAgregar = it }, label = { Text("ID") }, modifier = Modifier.weight(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            OutlinedTextField(value = inputNombre, onValueChange = { inputNombre = it }, label = { Text("Nombre") }, modifier = Modifier.weight(2f))
            OutlinedTextField(value = inputStock, onValueChange = { inputStock = it }, label = { Text("Stock") }, modifier = Modifier.weight(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        Button(
            onClick = {
                val id = inputIdAgregar.toIntOrNull()
                val stock = inputStock.toIntOrNull()
                if (id != null && stock != null && inputNombre.isNotBlank()) {
                    mensajeConsola = inventario.agregarProducto(id, inputNombre, stock)
                    inputIdAgregar = ""; inputNombre = ""; inputStock = "" // Limpiar campos
                } else {
                    mensajeConsola = "¡! Error: Llena todos los campos correctamente."
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Registrar Producto")
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        // SECCIÓN: RETIRAR STOCK
        Text(text = "➖ Retirar Stock", style = MaterialTheme.typography.titleMedium)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            OutlinedTextField(value = inputIdRetirar, onValueChange = { inputIdRetirar = it }, label = { Text("ID Producto") }, modifier = Modifier.weight(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            OutlinedTextField(value = inputRetiro, onValueChange = { inputRetiro = it }, label = { Text("Cant. a retirar") }, modifier = Modifier.weight(1f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        }
        Button(
            onClick = {
                val id = inputIdRetirar.toIntOrNull()
                val cant = inputRetiro.toIntOrNull()
                if (id != null && cant != null && cant > 0) {
                    mensajeConsola = inventario.retirarStock(id, cant)
                    inputIdRetirar = ""; inputRetiro = "" // Limpiar campos
                } else {
                    mensajeConsola = "¡! Error: Ingresa un ID y cantidad válidos."
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Procesar Retiro")
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        // SECCIÓN: MOSTRAR INVENTARIO DINÁMICO
        Text(text = "📋 Inventario Actual", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
        // LazyColumn es el equivalente visual del "forEach" para listas
        LazyColumn {
            items(inventario.productos) { prod ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Text(text = "ID: ${prod.id} | ${prod.nombre} | Stock: ${prod.stock} uds.", modifier = Modifier.padding(12.dp))
                }
            }
        }
    }
}

// 3. EL PREVISUALIZADOR (Corregido con 'remember')
@Preview(showBackground = true)
@Composable
fun PreviewInventarioCompleto() {
    // Usamos remember para que el inventario sobreviva a los redibujados de pantalla
    val inventarioPrueba = remember {
        GestorInventario().apply {
            agregarProducto(1, "Laptop X", 10)
            agregarProducto(2, "Mouse Inalámbrico", 25)
        }
    }

    MaterialTheme {
        PantallaInventarioCompleta(inventario = inventarioPrueba)
    }
}

// 4. EL PUNTO DE ARRANQUE PARA EMULADOR (Corregido)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val miInventario = remember { GestorInventario() }
            MaterialTheme { PantallaInventarioCompleta(miInventario) }
        }
    }
}
