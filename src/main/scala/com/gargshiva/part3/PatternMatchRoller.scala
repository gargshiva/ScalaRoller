package com.gargshiva.part3

class PatternMatchRoller {
  def main(args: Array[String]): Unit = {

    // List
    val sampleList = 1 :: 2 :: 3 :: Nil
    val opList = sampleList match {
      case 1 :: Nil => s"List with only one element 1 "
      case 1 :: 2 :: rest => s"List starting with 1 and 2 and remaining List is $rest"
      case head :: tail => s"List starts with $head and tail is $tail"
      case s => s"List $s"
    }


    // Vector (Rest of seq)
    val sampleVector = Vector(1, 2, 4)
    val opVector = sampleVector match {
      case 1 +: 2 +: rest => s"Vector starting with 1 and 2 and remaining List is $rest"
      case Vector(1, 2, 3, rest@_*) => s"Vector starting with 1,2 and 3  and remaining List is $rest"
      case Vector(1) => s"Vector with only 1 element"
      case Vector() => s"Empty Vector"
      case s => s"Vector $s"
    }
  }
}