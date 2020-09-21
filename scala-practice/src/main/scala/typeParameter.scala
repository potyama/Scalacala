class Cell[A](var value: A){
  def put(newValue: A): Unit = {
    value = newValue
  }

  def get(): A = value
}

//型パラメータを2つ取るクラス
class Pair[A,B](val a:A, val b: B){
  override def toString(): String = "(" + a + "," + b + ")"

}


