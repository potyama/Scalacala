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
  var result = "ryunen"

  result match {
    case "ryunen" => println("kasu")
    case "sinkyu" => println("pro")
  }

  var list = List("x", "y", "z")

  list match {
    case List("x", b, c) =>
      println("y = " + b)
      println("z = " + c)
    case _ =>
      println("nothing")
  }


}
