package outpostState

class OutpostManager {
    private val res = mutableListOf<ObservableResource>()
    val resources: List<ObservableResource> by lazy {
        println("Менеджер ресурсов инициализирован.")
        res
    }
    fun addResource(resource: ObservableResource) {
        res.add(resource)
    }
    fun getResource(index: Int): ObservableResource = res[index]
}