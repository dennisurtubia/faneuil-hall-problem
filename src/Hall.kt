import java.util.concurrent.Semaphore

class Hall {
  val noJudge = Semaphore(1);
  val confirmed = Semaphore(0);
  val checked = Semaphore(1);
  val allSignedIn = Semaphore(0);
  
  var immigrantsEntered = 0;
  var immigrantsChecked = 0;
  var judge = false;
}
