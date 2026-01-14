class ResearchLab: OutpostModule("Исследовательска лаборатория") {
    override fun performAction(manager: ResourceManager) {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
            println("Недостаточно минералов для исследования")
            return
        }
    }
}
fun main(){
    val manager = ResourceManager()
    manager.add(OutpostResource(1,"Minerals",120))
    manager.add(OutpostResource(2,"Gas",40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
}