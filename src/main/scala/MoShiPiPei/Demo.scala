package main.scala.MoShiPiPei

/**
  * 但是Scala的模式匹配的功能比Java的swich case语法的功能要强大地多，
  * Java的swich case语法只能对值进行匹配。但是Scala的模式匹配除了可以对值进行匹配之外，
  * 还可以对类型进行匹配、对Array和List的元素情况进行匹配、
  * 对case class进行匹配、甚至对有值或没值（Option）进行匹配。
  */
object Demo {
  def main(args: Array[String]): Unit = {
    judgeGrade("a")
  }

  def judgeGrade(grade: String): Unit = {
    grade match {
      case "a" => println("excellent")
      case "b" => println("good")
      case "c" => println("just so so")
      case "d" => println("you need work harder")
    }
  }

  //Scala的模式匹配语法，有一个特点在于，可以在case后的条件判断中，
  // 不仅仅只是提供一个值，而是可以在值后面再加一个if守卫，进行双重过滤
  def judgeGrade(name: String, grade: String): Unit = {
    grade match {
      case "A" => println(name + ", you are excellent")
      case "B" => println(name + ", you are good")
      case "C" => println(name + ", you are just so so")
      case _ if name == "leo" => println(name + ",you are a good body,come on")
      case _ => println("you need to work harder")
    }
  }

  //可以将模式匹配的默认情况，下划线，替换为一个变量名，
  // 此时模式匹配语法就会将要匹配的值赋值给这个变量，
  // 从而可以在后面的处理语句中使用要匹配的值
  def judgeGrade2(name: String, grade: String) {
    grade match {
      case "A" => println(name + ", you are excellent")
      case "B" => println(name + ", you are good")
      case "C" => println(name + ", you are just so so")
      case _grade if name == "leo" => println(name + ", you are a good boy, come on, your grade is " + _grade)
      case _grade => println("you need to work harder, your grade is " + _grade)
    }
  }

  /**
    * 对类型进行匹配
    */

  import java.io._

  def processException(e: Exception): Unit = {
    e match {
      case e1: IllegalArgumentException => println("you have illegal arguments! exception is: " + e1)
      case e2: FileNotFoundException => println("cannot find the file you need read or write!, exception is: " + e2)
      case e3: IOException => println("you got an error while you were doing IO operation! exception is: " + e3)
      case _: Exception => println("cannot know which exception you have!")
    }
  }

  /**
    * 对Array和List进行模式匹配
    */
  def greeting(arr: Array[String]): Unit = {
    arr match {
      case Array("Leo") => println("Hi, Leo!")
      case Array(girl1, girl2, girl3) => println("Hi, girls, nice to meet you. " + girl1 + " and " + girl2 + " and " + girl3)
      case Array("Leo", _*) => println("Hi, Leo, please introduce your friends to me.")
      case _ => println("hey, who are you?")
    }
  }

  def greeting(list: List[String]) {
    list match {
      case "Leo" :: Nil => println("Hi, Leo!")
      case girl1 :: girl2 :: girl3 :: Nil => println("Hi, girls, nice to meet you. " + girl1 + " and " + girl2 + " and " + girl3)
      case "Leo" :: tail => println("Hi, Leo, please introduce your friends to me.")
      case _ => println("hey, who are you?")
    }

  }

  // 案例：学校门禁
  class Person

  case class Teacher(name: String, subject: String) extends Person

  case class Student(name: String, classroom: String) extends Person

  def judgeIdentify(p: Person) {
    p match {
      case Teacher(name, subject) => println("Teacher, name is " + name + ", subject is " + subject)
      case Student(name, classroom) => println("Student, name is " + name + ", classroom is " + classroom)
      case _ => println("Illegal access, please go out of the school!")
    }
  }

  // Scala有一种特殊的类型，叫做Option。Option有两种值，一种是Some，表示有值，一种是None，表示没有值。
  // Option通常会用于模式匹配中，用于判断某个变量是有值还是没有值，这比null来的更加简洁明了
  // Option的用法必须掌握，因为Spark源码中大量地使用了Option，比如Some(a)、None这种语法，因此必须看得懂Option模式匹配，才能够读懂spark源码。

  // 案例：成绩查询
  val grades = Map("Leo" -> "A", "Jack" -> "B", "Jen" -> "C")

  def getGrade(name: String) {
    val grade = grades.get(name)
    grade match {
      case Some(grade) => println("your grade is " + grade)
      case None => println("Sorry, your grade information is not in the system")
    }
  }

}
