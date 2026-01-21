package modules

import handleModuleResult
import resources.OutpostResource
import resources.ResourceManager

class ResearchLab: OutpostModule("Исследовательска лаборатория") {
    override fun performAction(manager: ResourceManager): ModuleResult {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
            return ModuleResult.NotEnoughResources(
                resourceName = "Minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        }
        minerals.amount -= 30
        return ModuleResult.Success("Исследование завершено")
    }
}
fun main(){
    val manager = ResourceManager()
    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
}