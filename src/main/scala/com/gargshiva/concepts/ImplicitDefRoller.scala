package com.gargshiva.concepts



object ImplicitDefRoller {
  def main(args: Array[String]): Unit = {
    /**
      * Expression of Integer is needed, But found Double.
      * Scala looks into implicit scope to auto convert Double to Int
      */
    val x: Int = 23.0
    println(x)

    val y: Double = 10
    println(y)
  }

  implicit def doubleToInteger(x: Double): Int = {
    println("Using impilcit converstion")
    (x - 2).toInt
  }
}