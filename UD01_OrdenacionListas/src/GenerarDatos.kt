import kotlin.random.Random

object GenerarDatos {

    // Semilla fija: todos los algoritmos trabajan con los mismos datos
    private const val SEMILLA = 2026
    private val random = Random(SEMILLA)

    // Lista de vehículos: 44 nombres distintos, mezclados (desordenados)
    val vehiculos: MutableList<String> = mutableListOf(
        "Moto", "Camión", "Bicicleta", "Tractor", "Autobús", "Furgoneta",
        "Patinete", "Taxi", "Ambulancia", "Helicóptero", "Tranvía", "Metro",
        "Barco", "Yate", "Velero", "Avioneta", "Scooter", "Quad",
        "Caravana", "Remolque", "Bulldozer", "Grúa", "Excavadora", "Monopatín",
        "Coche", "Limusina", "Descapotable", "Todoterreno", "Pickup", "Minibús",
        "Trineo", "Globo", "Zeppelin", "Tren", "Monociclo", "Segway",
        "Kayak", "Canoa", "Submarino", "Hidropedal", "Carroza", "Rickshaw",
        "Autocaravana", "Cuatriciclo"
    ).also { it.shuffle(random) }

    // Lista numérica: 100 enteros entre 1 y 10000, sin repetir y desordenados
    val numeros: MutableList<Int> = (1..10000)
        .shuffled(random)
        .take(100)
        .toMutableList()

    @JvmStatic
    fun main(args: Array<String>) {
        println("Vehículos (${vehiculos.size}):\n$vehiculos\n")
        println("Números (${numeros.size}):\n$numeros")
    }
}