
class Immigrant(val hall: Hall, val name: String) : Runnable {

  override fun run() {

    hall.noJudge.acquire()
    enter()
    hall.noJudge.release()

    hall.mutex.acquire()
    checkIn()

    if (hall.judge == 1 && hall.immigrantesEntered == hall.checked)
      hall.allSignedIn.release()
    else
      hall.mutex.release()

    sitDown()

    hall.confirmed.acquire()
    swear()
    getCertificate()

    hall.noJudge.acquire()
    leave()
    hall.noJudge.release()
  }

  fun enter() {
    hall.immigrantesEntered++
    println("Immigrant $name entered the hall!")
  }

  fun checkIn() {
    hall.checked++
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
