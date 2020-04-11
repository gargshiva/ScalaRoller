package com.gargshiva.concepts

object TraitRoller {
  def main(args: Array[String]): Unit = {
    /**
      * Instance is created first before assigning value;
      * vals are lazily initialized.
      */
    val s1 = new PointC {
      override val x: Int = 100
      override val y: Int = 200
    }

    println(s1.point)

    /**
      * Variables are intialized first then Instance is created;
      */
    val s2 = new {
      val x: Int = 100
      val y: Int = 200
    } with PointC

    println(s2.point)
  }
}

trait PointC {
  val x: Int
  val y: Int
  // Val is calculated from other vals in Trait
  val point: (Int, Int) = (x + 1, y + 1)
}

/**
  * Other solution :
  *
  * Vals which are cacluated from other vals in trait ; Make them lazy
  */
trait PointD {
  val x: Int
  val y: Int
  // Val is calculated from other vals in Trai lazily;
  lazy val point: (Int, Int) = (x + 1, y + 1)
}
