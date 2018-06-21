package main.scala.function

/**
  * Scala常用高阶函数
  */
class Demo2 {
  //map:对传入的每个元素都进行映射，返回一个处理后的元素
  Array(1, 2, 3, 4, 5).map(2 * _)
  //foreach 对传入的每个元素都进行处理 但是没有返回值
  (1 to 9).filter(_ % 2 == 0)
  //reduceLeft从左侧开始，进行reduce操作
  (1 to 9).reduceLeft(_ * _)
  //sortWith对元素进行对比，排序
  Array(2, 3, 4, 6, 1, 89).sortWith(_ < _)

}
