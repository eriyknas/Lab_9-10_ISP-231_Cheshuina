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
fun main(){
    val manager = ResourceManager()
    val minerals = OutpostResource(1,"Minerals",300)
    val gas = OutpostResource(2,"Gas",100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amount = minerals.amount +50)
    println("Копия минералов с бонусом: $bonus")
}