package outpostState

class ResourceObserver {
    fun onResourceChanged(resourceName: String, old: Int, new: Int) {
        println("Наблюдатель: Ресурс $resourceName изменён: $old -> $new")
    }
}