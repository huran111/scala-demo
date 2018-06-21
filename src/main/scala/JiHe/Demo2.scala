package main.scala.JiHe
import scala.io.Source._
/**
  *函数式编程
  */
object Demo2 {
  def main(args: Array[String]): Unit = {
    //map案例实战，为List中每个元素都添加一个前缀
     val strings: List[String] = List("a","b","c","d").map("name is:"+_)
    //println(strings)
    //flatMap实战将List中的多行句子拆分成单词
    val strings1 = List("hello world","you me").flatMap(_.split(" "))
  //  println(strings1)
    //foreach案例实战：打印List中的每个单词
    val list=List("i","hava","bearfuil","house").foreach(println(_))
    //println(list)
    //使用io包将文本内容数据读取出来
    val lines01 = scala.io.Source.fromFile("E://a.txt").mkString
    val lines02 = scala.io.Source.fromFile("E://b.txt").mkString
    // 使用List的伴生对象，将多个文件内的内容创建为一个List
    val lines = List(lines01, lines02)
    //多个高阶函数的链式调用 以及大量下划线的使用
    val result=lines.flatMap(_.split(" "))
    //List(aa aa bb sdf sdf ss, bb bb)
    val result2=lines.flatMap(_.split(" ")).map((_,1))

    //println(result2)
    //List((aa aa bb sdf sdf ss,1), (bb bb,1))
    val result3=lines.flatMap(_.split(" ")).map((_,1)).map((_._2))
   // println(result3)
    //List((aa aa bb sdf sdf ss,1), (bb bb,1)) List(1, 1)
    val result4=lines.flatMap(_.split(" ")).map((_,1)).map((_._2)).reduceLeft(_+_)
    println(result4)

  }

}
