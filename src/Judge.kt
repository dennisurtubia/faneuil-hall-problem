
class Judge(val hall: Hall, val name: String) : Runnable {

  override fun run() {
    while (true) {
      hall.noJudge.acquire()
      enter()
      hall.mutex.acquire()

      if (hall.immigrantesEntered > hall.checked) {
        hall.mutex.release()
        hall.allSignedIn.acquire()
      }

      confirm()

      hall.confirmed.release(hall.checked)
      hall.checked = 0
      hall.immigrantesEntered = 0

      leave()

      hall.judge = 0

      hall.mutex.release()
      hall.noJudge.release()
    }
  }

  fun enter() {
    hall.judge = 1
    println("Judge $name entered the hall!")
  }

  fun confirm() {
    println("Judge confirmed!")
  }

  fun leave() {
    println("Judge leave the hall")
  }
}
