package example

import com.sun.nio.sctp.HandlerResult
import javax.sound.midi.MetaMessage

sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}
sealed class OrderStatus{
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}
fun handleOrder(status: OrderStatus){
    when (status){
        OrderStatus.Created -> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Отменен: ${status.reason}")
    }
}
fun handlerResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> {
            println("Успех: ${result.data}")
        }
        is NetworkResult.Error -> {
            println("Ошибка ${result.code}: ${result.message}")
        }
        NetworkResult.Loading -> {
            println("Загрузка...")
        }
    }
}
fun main() {
//    val success = NetworkResult.Success("Данные получены")
//    val error = NetworkResult.Error("Сервер не отвечает",500)
//    val loading = NetworkResult.Loading
//    handlerResult(success)
//    handlerResult(error)
//    handlerResult(loading)

    handleOrder(OrderStatus.Created)
    handleOrder(OrderStatus.Paid)
    handleOrder(OrderStatus.Shipped)
    handleOrder(OrderStatus.Cancelled("Нет товара на складе"))
}