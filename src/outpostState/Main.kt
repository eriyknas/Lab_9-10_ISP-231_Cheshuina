package outpostState

fun main() {
    val manager by lazy { OutpostManager() }
    manager.apply {
        addResource(ObservableResource("Minerals", 100, ResourceObserver()))
        addResource(ObservableResource("Gas", 50, ResourceObserver()))
    }
    manager.resources[0].amount = 120
    manager.resources[1].amount = 30
    StateStorage.save(manager.resources)
    val loaded = StateStorage.load()
    println("\nЗагруженные ресурсы:")
    loaded.forEach { println("${it.name}: ${it.amount}") }
}