object MergeSort {

    fun <T : Comparable<T>> mergeSort(
        lista: MutableList<T>,
        inicio: Int = 0,
        fin: Int = lista.size - 1
    ) {
        if (inicio >= fin) return                 // caso base: 0 o 1 elemento

        val medio = (inicio + fin) / 2
        mergeSort(lista, inicio, medio)           // ordena la mitad izquierda
        mergeSort(lista, medio + 1, fin)          // ordena la mitad derecha
        mezclar(lista, inicio, medio, fin)        // las combina
    }

    // Mezcla dos mitades ya ordenadas: [inicio..medio] y [medio+1..fin]
    private fun <T : Comparable<T>> mezclar(lista: MutableList<T>, inicio: Int, medio: Int, fin: Int) {
        val izquierda = lista.subList(inicio, medio + 1).toMutableList()
        val derecha = lista.subList(medio + 1, fin + 1).toMutableList()

        var i = 0
        var j = 0
        var k = inicio

        while (i < izquierda.size && j < derecha.size) {
            if (izquierda[i] <= derecha[j]) {
                lista[k] = izquierda[i]
                i++
            } else {
                lista[k] = derecha[j]
                j++
            }
            k++
        }
        // Copiar lo que quede en alguna de las dos mitades
        while (i < izquierda.size) {
            lista[k] = izquierda[i]
            i++
            k++
        }
        while (j < derecha.size) {
            lista[k] = derecha[j]
            j++
            k++
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== MERGESORT =====\n")

        // --- Vehículos ---
        val vehiculos = GenerarDatos.vehiculos.toMutableList()
        println("Vehículos originales:\n$vehiculos\n")
        var inicio = System.nanoTime()
        mergeSort(vehiculos)
        var fin = System.nanoTime()
        println("Vehículos ordenados:\n$vehiculos")
        println("Tiempo: ${fin - inicio} ns\n")

        // --- Números ---
        val numeros = GenerarDatos.numeros.toMutableList()
        println("Números originales:\n$numeros\n")
        inicio = System.nanoTime()
        mergeSort(numeros)
        fin = System.nanoTime()
        println("Números ordenados:\n$numeros")
        println("Tiempo: ${fin - inicio} ns")
    }
}