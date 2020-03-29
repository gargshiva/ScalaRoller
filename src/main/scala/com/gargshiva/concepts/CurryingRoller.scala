package com.gargshiva.concepts

/**
  * Currying is a technique to transform a function which take multiple args to function which takes single argument
  */
object CurryingRoller {

  def main(args: Array[String]): Unit = {
    add2(10, 12)

    add2c(10)(30)
    add3c(10)(20)(30)
  }

  // Non-curried function
  val add2: (Int, Int) => Int = (x, y) => x + y

  // Curried Function : Takes Single argument
  def add2c(x: Int): Int => Int = (y: Int) => x + y

  def add2curried = add2.curried

  def add3c(a: Int) = (b: Int) => (c: Int) => a + b + c

}
