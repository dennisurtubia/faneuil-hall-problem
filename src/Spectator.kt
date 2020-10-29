
class Spectator(val hall: Hall, val name: String) : Runnable {

  override fun run() {
    hall.noJudge.acquire()

    enter()

    hall.noJudge.release()

    spectate()
    leave()
  }

  fun enter() {
    println("Spectator $name entered the hall!")
  }

  fun spectate() {
    println("Spectator $name left!")
  }

  fun leave() {
    println("Spectator $name left!")
  }
}
