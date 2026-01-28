package gameCharacter

class GameCharacter(private var name: String) {
    private var currentState: CharacterState = CharacterState.Idle

    fun changeState(newState: CharacterState) {
        currentState = newState
        println("Персонаж '$name' сменил состояние.")
    }
    fun displayState() {
        when (currentState) {
            is CharacterState.Idle -> println("Состояние: Бездействие")
            is CharacterState.Running -> println("Состояние: Бег")
            is CharacterState.Attack -> {
                val attackState = currentState as CharacterState.Attack
                println("Состояние: Атака с уроном ${attackState.damage}")
            }
            is CharacterState.Dead -> {
                val deadState = currentState as CharacterState.Dead
                println("Состояние: Смерть. Причина: ${deadState.reason}")
            }
        }
    }
}