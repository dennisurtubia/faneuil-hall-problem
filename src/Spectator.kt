
class Spectator(val hall: Hall, val name: String): Runnable {

  override fun run() {
    hall.noJudge.acquire()

    enter()
    spectate()

    hall.noJudge.release()

    leave()
  }

  fun enter() {
    println("Spectator $name entered the hall!")
  }

  fun spectate() {
    println("Spectator $name left!");
  }

  fun leave() {
    println("Spectator $name left!");
  }
}
