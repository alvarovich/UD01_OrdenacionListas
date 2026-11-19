object ShellSort {

    fun <T : Comparable<T>> shellSort(lista: MutableList<T>) {
        val n = lista.size
        var salto = n / 2                       // secuencia de Shell: n/2, n/4, ... 1

        while (salto > 0) {
            // Inserción con saltos
            for (i in salto until n) {
                val actual = lista[i]
                var j = i
                while (j >= salto && lista[j - salto] > actual) {
                    lista[j] = lista[j - salto]
                    j -= salto
                }
                lista[j] = actual
            }
            salto /= 2
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== SHELLSORT =====\n")

        // --- Vehículos ---
        val vehiculos = GenerarDatos.vehiculos.toMutableList()
        println("Vehículos originales:\n$vehiculos\n")
        var inicio = System.nanoTime()
        shellSort(vehiculos)
        var fin = System.nanoTime()
        println("Vehículos ordenados:\n$vehiculos")
        println("Tiempo: ${fin - inicio} ns\n")

        // --- Números ---
        val numeros = GenerarDatos.numeros.toMutableList()
        println("Números originales:\n$numeros\n")
        inicio = System.nanoTime()
        shellSort(numeros)
        fin = System.nanoTime()
        println("Números ordenados:\n$numeros")
        println("Tiempo: ${fin - inicio} ns")
    }
}