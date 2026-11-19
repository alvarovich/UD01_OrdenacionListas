# UD01 - Ordenación de listas en Kotlin

Actividad de **Programación Multimedia y Dispositivos Móviles (PMDM)** de ILERNA, curso 2026/27.

Implementación, prueba y comparación de cinco algoritmos de ordenación en Kotlin, sin usar `sort()`, `sorted()`, `sortBy()` ni funciones equivalentes. Todos los algoritmos trabajan sobre los mismos datos y miden su tiempo de ejecución con `System.nanoTime()`.

**Autor:** [Nombre Apellido]

## Algoritmos implementados

| Nº | Algoritmo | Fichero | Tipo |
|----|-----------|---------|------|
| 1 | QuickSort | `01_QuickSort.kt` | Obligatorio |
| 2 | Pancake Sort | `02_PancakeSort.kt` | Obligatorio |
| 3 | MergeSort | `03_MergeSort.kt` | Obligatorio |
| 4 | HeapSort | `04_AlgoritmoLibre.kt` | Libre |
| 5 | ShellSort | `05_AlgoritmoLibre.kt` | Libre |

## Datos de prueba

`GenerarDatos.kt` genera dos listas con una semilla fija (`2026`), de modo que son idénticas en todas las ejecuciones y en todos los algoritmos:

- **Vehículos:** `MutableList<String>` con 44 nombres distintos, desordenados.
- **Números:** `MutableList<Int>` con 100 enteros aleatorios entre 1 y 10000, sin repetir y desordenados.

Cada algoritmo trabaja sobre una **copia** de las listas originales para no modificar los datos de los demás.

## Estructura del proyecto

```
UD01_OrdenacionListas/
├── README.md
├── UD01_OrdenacionListas_NombreApellido.pdf
└── src/
    └── main/
        └── kotlin/
            ├── GenerarDatos.kt
            ├── 01_QuickSort.kt
            ├── 02_PancakeSort.kt
            ├── 03_MergeSort.kt
            ├── 04_AlgoritmoLibre.kt
            └── 05_AlgoritmoLibre.kt
```

## Requisitos

- JDK 17 o superior
- IntelliJ IDEA (recomendado) con el plugin de Kotlin
- Kotlin [versión usada, por ejemplo 2.0.x]

## Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone [URL del repositorio]
   ```
2. Abre la carpeta del proyecto en IntelliJ IDEA.
3. Abre el fichero del algoritmo que quieras probar (por ejemplo `01_QuickSort.kt`).
4. Pulsa el botón verde junto a `fun main` y selecciona *Run*.
5. Repite el proceso con cada fichero. Cada algoritmo es un programa independiente.

No es necesario ejecutar `GenerarDatos.kt` antes: los algoritmos leen las listas directamente de él. Su propio `main` solo sirve para mostrar los datos generados.

## Qué muestra cada programa

1. La lista original (vehículos y números).
2. La lista ordenada (A-Z y de menor a mayor).
3. El tiempo de ejecución en nanosegundos.

## Resultados

Los tiempos obtenidos, las capturas de las ejecuciones y la comparación completa están en el informe PDF incluido en este repositorio.

## Informe

El informe técnico es [`UD01_OrdenacionListas_NombreApellido.pdf`](UD01_OrdenacionListas_NombreApellido.pdf) e incluye la explicación de cada algoritmo, la implementación, los resultados, las conclusiones y la bibliografía.
