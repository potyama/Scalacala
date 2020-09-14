class grid(val x: Int, val y: Int)

class Point2(val x: Int, val y: Int) {
  def -(p: grid): Point2 = {
    new Point2(x - p.x, y - p.y)
  }
  override def toString(): String = "(" + x + ", " + y + ")"
}
/*
scala> val p1 = new Point(1,1)
val p1: Point = (1, 1)

scala> val p1 = new Point(3,1)
val p1: Point = (3, 1)

 */

 class Multi {
  def mul(x: Int)(y: Int): Int = x * y
}

/*
scala> val multi = new Multi()
val multi: Multi = Multi@5698108e

scala> multi.mul(2)(10000)
val res0: Int = 20000

scala> val ok = multi.mul(3) _
val ok: Int => Int = $Lambda$6126/68367327@12d248b6

scala> ok(3)
val res1: Int = 9
 */

//抽象メンバー
abstract class XY {
  def a: Int
  def b: Int
}

//継承
class GenkaiPrinter() {
  def print(): Unit = {
    println("Genkai")
  }
}

class KasuPrinter() extends GenkaiPrinter{
  //継承するとき、overrideがないと動かない
  override def print(): Unit = {
    println("Kasu")
  }
}


/*
new GenkaiPrinter().printのprintに()を付けないと、
scala> new GenkaiPrinter().print
                           ^
       warning: Auto-application to `()` is deprecated. Supply the empty argument list `()` explicitly to invoke method print,
       or remove the empty argument list from its definition (Java-defined methods are exempt).
       In Scala 3, an unapplied method like this will be eta-expanded into a function.
Genkai
と表示される。
どうやら、javaのprintと間違えられるかららしい。

//以下実行結果
scala> new GenkaiPrinter().print()
Genkai


scala> new KasuPrinter().print()
Kasu
 */