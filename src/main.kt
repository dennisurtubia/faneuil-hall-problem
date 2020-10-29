
fun main() {
  val hall = Hall()

  val judge = Judge(hall, "João")
  judge.run()

  val spectatorsName = arrayOf("Celina", "Jonata", "Sandro", "Ananda", "Ayesha", "Geovana", "Elton", "Aurea", "Jan", "Marlon")
  val immigrantsName = arrayOf("Emile V. Kruse", "Helena B. Eriksen", "Robert Biermann", "Karolin Schreiner", "Cecilie N. Lassen")

  for (x in 0..9) {
    Spectator(hall, spectatorsName.get(x)).run()
  }

  for (y in 0..4) {
    Immigrant(hall, immigrantsName.get(y)).run()
  }
}