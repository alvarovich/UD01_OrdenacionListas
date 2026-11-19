object QuickSort {

    // Ordena la lista in situ. Recibe una COPIA, nunca la original.
    fun <T : Comparable<T>> quickSort(
        lista: MutableList<T>,
        inicio: Int = 0,
        fin: Int = lista.size - 1
    ) {
        if (inicio < fin) {
            val posPivote = particionar(lista, inicio, fin)
            quickSort(lista, inicio, posPivote - 1)   // parte izquierda
            quickSort(lista, posPivote + 1, fin)      // parte derecha
        }
    }

    // Esquema de Lomuto: el pivote es el último elemento
    private fun <T : Comparable<T>> particionar(lista: MutableList<T>, inicio: Int, fin: Int): Int {
        val pivote = lista[fin]
        var i = inicio - 1
        for (j in inicio until fin) {
            if (lista[j] <= pivote) {
                i++
                intercambiar(lista, i, j)
            }
        }
        intercambiar(lista, i + 1, fin)
        return i + 1
    }

    private fun <T> intercambiar(lista: MutableList<T>, a: Int, b: Int) {
        val tmp = lista[a]
        lista[a] = lista[b]
        lista[b] = tmp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== QUICKSORT =====\n")

        // --- Vehículos ---
        val vehiculos = GenerarDatos.vehiculos.toMutableList()   // copia
        println("Vehículos originales:\n$vehiculos\n")
        var inicio = System.nanoTime()
        quickSort(vehiculos)
        var fin = System.nanoTime()
        println("Vehículos ordenados:\n$vehiculos")
        println("Tiempo: ${fin - inicio} ns\n")

        // --- Números ---
        val numeros = GenerarDatos.numeros.toMutableList()       // copia
        println("Números originales:\n$numeros\n")
        inicio = System.nanoTime()
        quickSort(numeros)
        fin = System.nanoTime()
        println("Números ordenados:\n$numeros")
        println("Tiempo: ${fin - inicio} ns")
    }
}