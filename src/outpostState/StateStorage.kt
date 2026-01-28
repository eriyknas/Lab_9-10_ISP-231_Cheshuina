package outpostState
import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpost_state.txt"

    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        val lines = resources.map { "${it.name};${it.amount}" }
        file.writeText(lines.joinToString("\n"))
        println("Состояние сохранено в файл $FILE_NAME")
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            println("Файл состояния не найден.")
            return emptyList()
        }
        val lines = file.readLines()
        val resources = lines.map { line ->
            val (name, amount) = line.split(";")
            ObservableResource(name, amount.toInt())
        }
        println("Состояние загружено из файла $FILE_NAME")
        return resources
    }
}