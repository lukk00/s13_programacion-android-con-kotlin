# Módulo 12: Programación Android con Kotlin 🚀

**Autor:** Karla Guadalupe Flores Lara  
**Entorno de desarrollo:** Android Studio  

Este repositorio contiene la solución completa al Cuaderno de Laboratorios del **Módulo 12**, enfocado en los fundamentos de Kotlin y el desarrollo de aplicaciones móviles. Se aplica la metodología de "aprender haciendo" mediante la ejecución, modificación y análisis de código.

---

## 📁 Estructura del Proyecto

El proyecto está dividido de forma modular para separar la lógica pura de la interfaz gráfica:

1. **Módulo `ejercicios_consola` (Kotlin Puro):**
   - Contiene los **15 ejercicios resueltos** base, los cuales fueron analizados y modificados para comprobar reglas lógicas.
   - Contiene los **10 ejercicios propuestos** desarrollados desde cero, aplicando buenas prácticas (Clean Code).
   - Incluye la versión lógica por consola del Mini-proyecto integrador (`MiniProyecto.kt`).

2. **Módulo `app` (Interfaz Visual - Jetpack Compose):**
   - Contiene la evolución visual del Mini-proyecto integrador (`MainActivity.kt`). 
   - Aplica `mutableStateListOf` y persistencia de estado con `remember` para crear una interfaz interactiva.

---

## ⚙️ Instrucciones de Ejecución

Para evaluar el código correctamente en Android Studio, sigue estas indicaciones dependiendo del módulo:

### Para los ejercicios de consola (`ejercicios_consola`)
1. Despliega la ruta: `ejercicios_consola > src > main > java > com.example...`
2. Abre cualquier archivo `.kt` (ej. `ejercicio_01.kt`).
3. Haz clic derecho sobre el ícono verde de "Play" junto a la función `fun main()` y selecciona **Run with Coverage** (para obtener una consola limpia) o **Run**.
4. El resultado se visualizará en la pestaña de herramientas inferior (Run).

### Para el Mini-proyecto Visual (`app/MainActivity.kt`)
No es estrictamente necesario lanzar un emulador pesado. Se puede probar directamente en el editor:
1. Abre el archivo `MainActivity.kt` dentro del módulo `app`.
2. En la esquina superior derecha del editor, selecciona la vista **Split** para abrir el previsualizador (Preview) de Jetpack Compose.
3. Haz clic en el ícono de **Interactive Mode** (el dedo tocando un cuadro) encima de la vista del teléfono.
4. Interactúa con los campos de texto y botones simulando un dispositivo real.

---

## 📦 Mini-Proyecto Integrador: Gestor de Inventario

Como proyecto final, se desarrolló un simulador de control de inventarios que integra los tres pilares solicitados en la rúbrica:
- **Clases (Modelado de datos):** Uso de `data class` para definir la estructura de los productos.
- **Colecciones:** Implementación de `mutableListOf` (consola) y `mutableStateListOf` (Compose) para almacenamiento dinámico.
- **Excepciones y Null Safety:** Uso de `find {}`, validación de nulos y control de límites lógicos.

### Casos de prueba documentados:
- **Caso Normal:** Retiro de stock exitoso con actualización en la colección.
- **Caso Límite:** Intento de retirar más unidades de las existentes (evita stock negativo).
- **Caso de Error:** Búsqueda de un ID inexistente (captura segura de nulos sin colapsar la app).

---
