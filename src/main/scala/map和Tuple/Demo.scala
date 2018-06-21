package main.scala.map和Tuple

import scala.collection.mutable

/**
  */
object Demo {
  def main(args: Array[String]): Unit = {
    //创建一个不可变的map
    val ages = Map("leo" -> 30, "jen" -> 28, "hur" -> 23)
    //创建一个可变的map
    val ages2 = scala.collection.mutable.Map("leo" -> 30, "jen" -> 25, "jack" -> 23)
    ages2("leo") = 23
    //使用另一种方式定义Map元素
    val ages3 = Map(("leo", 30), ("jen", 32), ("java", 43))
    //创建一个空的HashMap
    val ages4 = new mutable.HashMap[String, Int]()
  }
}
