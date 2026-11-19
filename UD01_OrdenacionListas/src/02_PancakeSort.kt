object PancakeSort {

    // Invierte los elementos de la posición 0 hasta k (incluida): "dar la vuelta a la espátula"
    private fun <T> voltear(lista: MutableList<T>, k: Int) {
        var i = 0
        var j = k
        while (i < j) {
            val tmp = lista[i]
            lista[i] = lista[j]
            lista[j] = tmp
            i++
            j--
        }
    }

    // Posición del mayor elemento entre 0 y limite (incluido)
    private fun <T : Comparable<T>> posicionMaximo(lista: List<T>, limite: Int): Int {
        var posMax = 0
        for (i in 1..limite) {
            if (lista[i] > lista[posMax]) posMax = i
        }
        return posMax
    }

    fun <T : Comparable<T>> pancakeSort(lista: MutableList<T>) {
        // tamaño va reduciéndose: la parte final ya queda ordenada
        for (tamanio in lista.size downTo 2) {
            val posMax = posicionMaximo(lista, tamanio - 1)
            if (posMax != tamanio - 1) {
                if (posMax != 0) voltear(lista, posMax)   // 1) llevar el máximo al principio
                voltear(lista, tamanio - 1)               // 2) llevarlo a su posición final
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== PANCAKE SORT =====\n")

        // --- Vehículos ---
        val vehiculos = GenerarDatos.vehiculos.toMutableList()
        println("Vehículos originales:\n$vehiculos\n")
        var inicio = System.nanoTime()
        pancakeSort(vehiculos)
        var fin = System.nanoTime()
        println("Vehículos ordenados:\n$vehiculos")
        println("Tiempo: ${fin - inicio} ns\n")

        // --- Números ---
        val numeros = GenerarDatos.numeros.toMutableList()
        println("Números originales:\n$numeros\n")
        inicio = System.nanoTime()
        pancakeSort(numeros)
        fin = System.nanoTime()
        println("Números ordenados:\n$numeros")
        println("Tiempo: ${fin - inicio} ns")
    }
}