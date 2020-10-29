import java.util.concurrent.Semaphore

class Hall {
  val noJudge = Semaphore(1);
  var immigrantesEntered = 0;
  var checked = 0;
  var judge = 0;
  val mutex = Semaphore(1);
  val confirmed = Semaphore(0);
  val allSignedIn = Semaphore(0);
}
