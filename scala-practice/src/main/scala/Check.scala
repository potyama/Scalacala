
object Main extends App{

  //if
  var age: Int = 5
  var isSchoolStarted: Boolean = false

  if (age <= 6 && !isSchoolStarted) {
    println("youji")
  } else {
    println("No youji")
  }

  //while
  def loopFrom0to9(): Unit = {
    var i = 0
    do {
      println(i)
      i += 1
    } while (i < 10)
  }
  loopFrom0to9()

  //for
  def triangle(): Unit = {
    for (a <- 1 to 1000; b <- 1 to 1000; c <- 1 to 1000 if a * a == b * b + c * c) {
      println ((a, b, c) )
    }
  }
  //triangle()

  //match
  val result = "ryunen"

  result match {
    case "ryunen" => println("kasu")
    case "sinkyu" => println("pro")
  }
//パターンマッチ
  val list = List("x", "y", "z")

  list match {
    case List("x", b, c) =>
      println("y = " + b)
      println("z = " + c)
    case _ =>
      println("nothing")
  }
  //パターンマッチ2
  list match {
    case List("x", b, c) if b != "y" =>
      println("y = " + b)
      println("z = " + c)
    case _ =>
      println("nothing")
  }
//2要素からなるlistのパターンマッチ
  val listList = List(List("x, a"), List("y", "z"))

  listList match {
    case List(a@List("x, a"), x) =>
      println(a)
      println(x)
    case _ => println("nothing")
  }

  for(i <- 1 to 10) {
    val s = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match {
      case List(a, b, _, d, _) => List(a, b, a, d, a)
    }
    println(s)
  }
}
