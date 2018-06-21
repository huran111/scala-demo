package main.scala.JiHe
import scala.collection.mutable.LinkedList
/**
  *集合
  */
object Demo1 {
  def main(args: Array[String]): Unit = {
    val list=List(1,2,3,4)
    //decorator(list,"a：")
   // linkedList();
   // linkedList2();
    setDemo()
  }

  /**
    * List代表一个不可变的列表
    * @param l
    * @param prefix
    */
  def decorator(l: List[Int], prefix: String): Unit = {
    //Nil标识是否是一个空的List
    if(l != Nil){
      println(prefix+l.head)
      println("------:"+l.tail)
      decorator(l.tail,prefix)

    }
  }

  /**
    * LinkedList是可变的列表
    * 使用while循环将LinkedList中的元素都乘以2
    */
  def linkedList(): Unit ={
    val linkedList=LinkedList(1,23,4,5,6);
    var currentList=linkedList
    while(currentList!=Nil){
      currentList.elem=currentList.elem*2
      currentList=currentList.next
    }
    println(linkedList)
  }

  /**
    * 使用while循环将LinkedList中，从第一个元素开始，每隔一个元素 乘以2
    */
  def linkedList2(): Unit ={
    val list=LinkedList(1,2,3,4,5,6,7,8,9,10)
    var currentList=list
    var first=true
    while (currentList!=Nil&&currentList.next!=Nil){
      if(first){
        currentList.elem=currentList.elem*2;
        first=false
      }
      currentList=currentList.next.next
      if(currentList!=Nil){
        currentList.elem=currentList.elem*2
      }
    }
    println(list)
  }

  /**
    * set代表没有重复圆元素的集合 乱序
    */
  import scala.collection.mutable.HashSet
  import scala.collection.mutable.LinkedHashSet
  import scala.collection.mutable.SortedSet
  def setDemo(): Unit ={
    val s=HashSet[Int]()
    s+=1
    s+=2
    s+=3
    println(s)
    //LinkedHashSet会用一个链表维护插入顺序
  val a=LinkedHashSet[Int]()
    a+=1
    a+=2
    a+=3
    println(a)
    val ss=SortedSet("orange","apple","banana")
    println(ss)
  }
}
