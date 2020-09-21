/*
Scalaは通常、何も指定しなかった型パラメータはinvariant(非変)になる。
invariantは、型パラメータを持ったクラスG、型パラメータA,Bがあったとき、A = Bのときにのみ
val: G[A] = G[B]
というだいにゅが許される性質のこと。

covariant(共変)
型パラメータを持ったクラスG、型パラメータA,Bがあったとき、AがBを継承しているときのみ
val : G[B] = G[A]
というような代入が許される性質のこと。

class G[+A]
のように型パラメータの前に+をつけるとその型パラメータあるいはそのクラスは共変になる。
 */

class Pair2[+A, +B](val a: A, val b: B){
  override def toString(): String = "(" + a + "," + ")"
}

//演習
trait Stack[+A] {
  def push[E >: A](e: E): Stack[E]
  def top: A
  def pop: Stack[A]
  def isEmpty: Boolean
}

class NonEmptyStack[+A](private val first: A, private val rest: Stack[A]) extends Stack[A] {
  def push[E >: A](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def top: A = first
  def pop: Stack[A] = rest
  def isEmpty: Boolean = false
}

case object EmptyStack extends Stack[Nothing] {
  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def top: Nothing = throw new IllegalArgumentException("empty stack")
  def pop: Nothing = throw new IllegalArgumentException("empty stack")
  def isEmpty: Boolean = true
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}

