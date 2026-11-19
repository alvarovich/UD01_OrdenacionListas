object HeapSort {

    fun <T : Comparable<T>> heapSort(lista: MutableList<T>) {
        val n = lista.size

        // 1) Construir el montículo máximo (max-heap), desde el último nodo con hijos
        for (i in n / 2 - 1 downTo 0) {
            hundir(lista, n, i)
        }

        // 2) Extraer el máximo (raíz) y colocarlo al final, reduciendo el montículo
        for (fin in n - 1 downTo 1) {
            intercambiar(lista, 0, fin)
            hundir(lista, fin, 0)
        }
    }

    // Hunde el elemento de la posición "raiz" hasta que se cumpla la propiedad del montículo
    private fun <T : Comparable<T>> hundir(lista: MutableList<T>, tamanio: Int, raiz: Int) {
        var padre = raiz
        while (true) {
            val izq = 2 * padre + 1
            val der = 2 * padre + 2
            var mayor = padre

            if (izq < tamanio && lista[izq] > lista[mayor]) mayor = izq
            if (der < tamanio && lista[der] > lista[mayor]) mayor = der

            if (mayor == padre) return        // ya cumple la propiedad
            intercambiar(lista, padre, mayor)
            padre = mayor
        }
    }

    private fun <T> intercambiar(lista: MutableList<T>, a: Int, b: Int) {
        val tmp = lista[a]
        lista[a] = lista[b]
        lista[b] = tmp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== HEAPSORT =====\n")

        // --- Vehículos ---
        val vehiculos = GenerarDatos.vehiculos.toMutableList()
        println("Vehículos originales:\n$vehiculos\n")
        var inicio = System.nanoTime()
        heapSort(vehiculos)
        var fin = System.nanoTime()
        println("Vehículos ordenados:\n$vehiculos")
        println("Tiempo: ${fin - inicio} ns\n")

        // --- Números ---
        val numeros = GenerarDatos.numeros.toMutableList()
        println("Números originales:\n$numeros\n")
        inicio = System.nanoTime()
        heapSort(numeros)
        fin = System.nanoTime()
        println("Números ordenados:\n$numeros")
        println("Tiempo: ${fin - inicio} ns")
    }
}