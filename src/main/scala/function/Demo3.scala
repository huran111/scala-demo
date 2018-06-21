package main.scala.function

/**
  * 闭包：函数在变量不处于其他有效作用域的时候，还能够被访问 即为闭包
  */
class Demo3 {
  def main(args: Array[String]): Unit = {

  }

  def getGreetingFunc(msg: String) = (name: String) => println(msg + name)

  val greetingFuncHelo = getGreetingFunc("hello")
  val greetingFuncHi = getGreetingFunc("Hi")
  //两次调用  getGreetingFunc 函数 传入不同的msg,并创建不同的函数返回
  /**
    * 然而，msg只是一个局部变量，缺在getGreetingFunc执行完毕后，还可以继续存在创建的函数之中 ，msg保留在了函数体内部，
    * 可以反复使用，这种变量超出了其作用域，就是闭包
    * scala通过为每个函数创建对象来实现闭包，因此每个函数用有不用的msg
    */

}
