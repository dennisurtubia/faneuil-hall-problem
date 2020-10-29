
class Judge(val hall: Hall, val name: String) : Runnable {

  override fun run() {
    hall.noJudge.acquire()
    hall.checked.acquire()
    enter()

    if (hall.immigrantsEntered > hall.immigrantsChecked) {
      hall.checked.release()
      hall.allSignedIn.acquire()
    }

    confirm()

    hall.confirmed.release(hall.immigrantsChecked)
    hall.immigrantsEntered = 0;
    hall.immigrantsChecked = 0;

    leave()

    hall.judge = false

    hall.checked.release()
    hall.noJudge.release()
  }

  fun enter() {
    hall.judge = true
    println("Judge $name entered the hall!")
    Thread.sleep(2000)
  }

  fun confirm() {
    println("Judge confirmed!")
    Thread.sleep(2000)
  }

  fun leave() {
    println("Judge leave the hall")
    Thread.sleep(2000)
  }
}
