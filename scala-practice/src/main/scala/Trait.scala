trait TraiaA {
  val role: String
  def printRole(): Unit = println(role)
}

class ClassA(val role: String) extends TraiaA

object  ObjectA{
  val a = new ClassA("kasu")

  val a2 = new TraiaA { val role = "zako"}
}