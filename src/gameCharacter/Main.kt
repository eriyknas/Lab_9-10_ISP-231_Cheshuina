package gameCharacter

fun main() {
    val hero = GameCharacter("Артур")
    println("--- Начальное состояние ---")
    hero.displayState()
    println("\n--- Меняем состояния ---")
    hero.changeState(CharacterState.Running)
    hero.displayState()
    hero.changeState(CharacterState.Attack(damage = 50))
    hero.displayState()
    hero.changeState(CharacterState.Dead(reason = "Поражён в бою"))
    hero.displayState()
    hero.changeState(CharacterState.Idle)
    hero.displayState()
}