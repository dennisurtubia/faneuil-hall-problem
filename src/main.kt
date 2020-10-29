
fun main() {
  val hall = Hall()

  Thread(Judge(hall, "João")).start()

  Thread(Immigrant(hall, "Marcia")).start()

  Thread(Spectator(hall, "Celina")).start()

  Thread(Immigrant(hall, "Maria")).start()
}
