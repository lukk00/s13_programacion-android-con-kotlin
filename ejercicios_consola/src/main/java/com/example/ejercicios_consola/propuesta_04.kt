package com.example.ejercicios_consola

fun mostrarInterfaz(dispositivo: String, tema: String, registros: Int) {
    if (dispositivo == "Teléfono") {
        println("[Vista Móvil]\n| Tema: $tema\n| Registros: $registros" +
                "\n---------------------")
    } else if (dispositivo == "Tableta") {
        println("[Vista Tableta]\n| Tema principal: $tema | Total de registros actuales: $registros |" +
                "\n-------------------------------------------------------------------")
    }
}
fun main() {
    val temaActual = "UI Adaptativa"
    val totalRegistros = 12

    mostrarInterfaz("Teléfono", temaActual, totalRegistros)
    println()
    mostrarInterfaz("Tableta", temaActual, totalRegistros)
}