//抽象メンバー
trait TraitA {
  val role: String
  def printRole(): Unit = println(role)
}
//クラスにしてnameを上書き
class ClassA(val role: String) extends TraitA

object  ObjectA {
  val a = new ClassA("kasu")

  val a2 = new TraitA { val role = "zako"}
}

trait TraitA2 {
  def greet(): Unit
}

trait TraitB extends TraitA2 {
  def greet():Unit = println("Good morning")
}

trait TraitC extends TraitA2 {
  def greet():Unit = println("Good evening")
}
//このままだと、TraitBとTraitCで競合するので2通りで解決する
//class A extends TraitB with TraitC

//override
class ClassA2 extends TraitB with TraitC {
  override def greet(): Unit = println("How are you?")
}

class ClassB2 extends TraitB with TraitC {
  override def greet(): Unit = super[TraitB].greet()
}

//両方呼び出したいとき
class ClassC2 extends TraitB with TraitC {
  override def greet(): Unit = {
    super[TraitB].greet()
    super[TraitC].greet()
    println("come on!!")
  }
}
/*
scala> (new ClassA2).greet()
How are you?

scala> (new ClassB2).greet()
Good morning

scala> (new ClassC2).greet()
Good morning
Good evening
come on!!
 */

trait TraitB2 extends TraitA2 {
  override def greet():Unit = println("Good morning")
}

trait TraitC2 extends TraitA2 {
  override def greet():Unit = println("Good evening")
}

//後からミックスインしたTraitが優先される
class ClassA3 extends TraitB2 with TraitC2
class ClassA4 extends TraitC2 with TraitB2
/*
scala> (new ClassA3).greet()
Good evening

scala> (new ClassA4).greet()
Good morning
 */

//親トレイとを使うこともできる
trait TraitA3 {
  def greet(): Unit = println("genkai")
}

trait TraitB3 extends TraitA3{
  override def greet(): Unit = {
    super.greet()
    println("kasu")
  }
}

trait TraitC3 extends TraitA3{
  override def greet(): Unit = {
    super.greet()
    println("pro")
  }
}

class ClassA5 extends TraitB3 with TraitC3
class ClassA6 extends TraitC3 with TraitB3
/*
scala> (new ClassA5).greet()
genkai
kasu
pro

scala> (new ClassA6).greet()
genkai
pro
kasu
 */


//だめな場合
trait A{
  val foo: String
}

trait B extends A {
  val bar = foo + "World"
}

class C extends B {
  val foo = "Hello"

  def printbar(): Unit = println(bar)
}
/*
scala> (new C).printbar()
nullWorld

今回は
C -> B -> A
と継承している。
Aでfooが宣言され(中身は宣言されてないからNULL)、その後、barが宣言される(=中身がNULLのfooと文字列"World"を連結し、barが表示されることから、以上のようになる。
 */

//正しい場合①
trait NewA{
  val foo1: String
}

trait NewB extends NewA {
  lazy val bar1 = foo1 + "World"
}

class NewC extends NewB {
  val foo1 = "Hello"

  def printbar1(): Unit = println(bar1)
}

/*
scala> (new NewC).printbar1()
HelloWorld

lazy valを使ってbarの初期化を遅延する。
 */

//正しい場合② (あまり使われない)
trait NewA2{
  val foo2: String
}

trait NewB3 extends NewA2 {
  val bar2 = foo2 + "World!"
}

class NewC2 extends{
  val foo2 = "Hello!"
} with NewB3 {
  def printbar2(): Unit = println(bar2)
}

/*
scala> (new NewC2).printbar2()
HelloWorld

事前定義する方法
トレイとの初期問題は基本トレイと側で解決した方がいいので、これはあまり見ることはない。
 */