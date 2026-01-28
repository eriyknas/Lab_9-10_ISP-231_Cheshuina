import SystemLogger.logger
import modules.ModuleResult
import resources.OutpostResource
import resources.ResourceManager

fun handleModuleResult(result: ModuleResult){
    when (result){
        is ModuleResult.Success ->
            println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources -> println(
            "Недостаточно ресурса ${result.resourceName}. " +
                "Нужно: ${result.required}, есть: ${result.available}"
        )
        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}")
    }
}
object SystemLogger{
    val logger by lazy {
        SystemLogger
    }
    init {
        println("SystemLogger инициализирован")
    }
    fun log(message: String){
        println("[LOG] $message")
    }
}
fun main(){
    logger.log("Запуск базы")
    val manager = ResourceManager()
    val minerals = OutpostResource(1,"Minerals",300)
    val gas = OutpostResource(2,"Gas",100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amountInit = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")
    val loadedResources = FileStorage.load()
    loadedResources.forEach { manager.add(it) }
    if (loadedResources.isEmpty()){
        manager.add(OutpostResource(1,"Minerals",300))
        manager.add(OutpostResource(2,"Gas",100))
    }
    FileStorage.save(manager.getAll())
}