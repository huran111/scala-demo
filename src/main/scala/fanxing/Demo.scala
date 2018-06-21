package main.scala.fanxing

/**
  * 泛型类
  */
object Demo {
  def main(args: Array[String]): Unit = {
    val leo = new Student[Int](111).getSchool(111)
    getCard[String]("hello world")

  }

  //泛型函数
  def getCard[T](content: T) = {
    if (content.isInstanceOf[Int])
      "card:001" + content
    else if (content.isInstanceOf[String])
      "card :this is your card" + content
    else "card:" + content
  }
}

//泛型类
class Student1[T](val localld: T) {
  def getSchool(o: T) = println("S-" + o + "-" + localld)
}


/**
  * 上边界Bounds
  */
//在排队上交朋友
class Person(val name: String) {
  def sayHello = println("hello,I'm" + name)

  def makeFriends(p: Person): Unit = {
    sayHello
    p.sayHello
  }
}

class Student(name: String) extends Person(name) {

  class Party[T <: Person](p1: T, p2: T) {
    def play = p1.makeFriends(p2)
  }
}

/**
  * 下边界Bounds
  * 泛型类型必须是某个类的父类
  */
class Father(val name:String){
}
class Child(name:String) extends Father(name){
  def getIDCard[R >: Child](person: R) {
    if (person.getClass == classOf[Child]) println("please tell us your parents' names.")
    else if (person.getClass == classOf[Father]) println("sign your name for your child's id card.")
    else println("sorry, you are not allowed to get id card.")
  }

}


