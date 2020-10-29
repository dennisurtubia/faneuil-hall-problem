
class Immigrant(val hall: Hall, val name: String) : Runnable {

  override fun run() {
    hall.noJudge.acquire()
    enter()
    hall.immigrantsEntered++
    hall.noJudge.release()

    hall.checked.acquire()
    checkIn()

    if (hall.judge == true && hall.immigrantsEntered == hall.immigrantsChecked)
      hall.allSignedIn.release()
    else
      hall.checked.release()

    sitDown()
    hall.confirmed.acquire()

    swear()
    getCertificate()

    hall.noJudge.acquire()
    leave()
    hall.noJudge.release()
  }

  fun enter() {
    hall.immigrantsEntered++
    println("Immigrant $name entered the hall!")
    Thread.sleep(2000)
  }

  fun checkIn() {
    hall.immigrantsChecked++
    println("Immigrant $name checked in!")
  }

  fun sitDown() {
   println("Immigrant $name sat!")
  }

  fun swear() {
    println("Immigrant $name swore!")
  }

  fun getCertificate() {
    println("Immigrant $name get the certified!")
  }

  fun leave() {
    println("Immigrant $name has left!")
  }
}
