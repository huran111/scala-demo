package main.scala.function


/**
  * Scala中的函数是一等公民  ，可以独立定义，独立存在，而且可以直接将函数作为值复制给变量
  */
object Demo {
  def main(args: Array[String]): Unit = {
    val sayHelloFunction = sayHelo _
    sayHelloFunction("a")
    System.out.print("--------------------------------------")
    /**
      * 匿名函数 可以直接定义函数之后 将函数赋值给某个变量，也可以将 你匿名函数传入其他函数中
      * 在spark源码中 有大量的匿名语法
      */
    val sayHelloFun = (name: String) => println("hello" + name);
    sayHelloFun("3")
    System.out.print("--------------------------------------")

    /**
      * 接受其他函数作为参数的函数，称为高阶函数
      */
    val salHelloF = (name: String) => println("hello" + name)

    def greeting(func: (String) => Unit, name: String) {
      func(name)
    }

    greeting(salHelloF, "a")
    val list = Array(1, 2, 3, 4, 5).map((num: Int) => num * num).toList
    println(list.toString())

    /**
      * 高阶函数作的另外一个功能是将函数作为返回值
      */
    def getGreetingFun(msg: String) = (name: String) => println(msg + ":" + name)

    val greetingFunc = getGreetingFun("hello")
    greetingFunc("leo")
    tripe(3 * _)

    /**
      * 高阶函数的类型解析  可以自动推断出类型的 而不需要写声明，而且对于一个只有一个参数
      * 的函数，还可以省去小括号，如果仅有一个和参数在右侧的函数只使用一次，则还可以将接受参数
      * 省略，并将参数用_替代
      */

    greeting((name: String) => println("Hello" + name), "a")
    greeting((name) => println("hello" + name), "a")
    greeting(name => println("hello" + name), "b")

  }

  def tripe(func: (Int) => Int) = {
    func(3)
  }

  def sayHelo(name: String) {
    println("hello" + name)
  }

  def greeting(funn: (String) => Unit, name: String) {
    funn(name)
  }

}


