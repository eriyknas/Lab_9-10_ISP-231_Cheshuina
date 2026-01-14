package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop(){
        println("Останавливаемся...")
    }
}
class Car(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 600
    override fun move() {
        println("Летим на самолёте со скоростью $speed км/ч")
    }

    override fun stop() = println("Приземляемся...")
}
fun travel(obj: Movable) = obj.move()
interface Worker {
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name: String): Worker, Student {
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")
}
interface VideoPlayer{
    fun play() = println("Play video")
}
interface AudioPlayer{
    fun play() = println("Play audio")
}
class MediaPlayer : VideoPlayer, AudioPlayer {
    override fun play() {
        println("Start playing")
        super<VideoPlayer>.play()
        super<AudioPlayer>.play()
    }
}
fun main() {
    val car = Car("LADA","134LAD")
    val aircraft = Aircraft("Boeing","737")
    travel(obj = car)
    travel(obj = aircraft)
    val pavel = WorkingStudent("Pavel")
    pavel.work()
    pavel.study()
    aircraft.move()
    aircraft.stop()
    val player = MediaPlayer()
    player.play()
}
