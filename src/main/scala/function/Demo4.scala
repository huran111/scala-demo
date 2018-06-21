package main.scala.function

import javax.swing._
import java.awt.event._

/**
  * 在java中，不支持直接将函数传入一个方法作为参数 ，通常来说，唯一的办法就是定义一个实现了某个接口
  * 的类的对象，该对象有一个方法，而这些接口都只有单独的抽象方法，也就是SAM;
  * 由于scala是可以调用java代码的，因此当我们调用java代码的时候，可能就不得不创建SAM传递给方法
  * 非常麻烦，但是scala支持直接传递函数的，此时就可以使用scala提供的，在调用java方法的时候，使用的功能
  * SAM转换 ，将SAM转换为scala函数  ---  隐式转换
  */
object Demo4 {
  def main(args: Array[String]): Unit = {
    val button = new JButton("Client");
    button.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        println("check mail")
      }
    })

    implicit def getActionListener(actionProcessFun: (ActionEvent) => Unit) = new ActionListener {
      override def actionPerformed(event: ActionEvent): Unit = {
        actionProcessFun(event)
      }
    }

    button.addActionListener((event: ActionEvent) => println("check mail"))
  }

  /**
    * Curring函数 ，指的是，将原来两个参数的一个函数，转换为两个函数，
    * 第一个函数接受原来的第一个参数，然后返回  原先接受的原先第二个参数的第二个函数
    */
  def sum(a: Int, b: Int) = a + b

  sum(1, 2)

  def sum2(a: Int) = (b: Int) => a + b

  sum2(1)(4)

  def sum3(a: Int)(b: Int) = a + b

  /**
    * return函数
    * 在scala中 return用于匿名函数中返回值给 包含匿名函数逇带名函数，并作为函数的返回值
    */
  def greeting(name: String): Unit = {
    def sayHello(name: String): String = {
      return "hello," + name
    }

    sayHello(name)
  }
}
