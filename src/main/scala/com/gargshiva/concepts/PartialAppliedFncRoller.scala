package com.gargshiva.concepts

/**
  * Partial Applied Functions : Less args are supplied than required.
  * Function Literal : Anonymous Function
  * Closure : Function literal + state apart from args passed.
  */
object PartialAppliedFncRoller {
  val z = 100

  def main(args: Array[String]): Unit = {
    println(helloGreetings("Shiva"))
  }

  def greetingMsg(name: String, msg: String): String = {
    msg + ", " + name + "!"
  }

  /**
    * Partial applied function
    */
  val helloGreetings = greetingMsg(_: String, "Hello")
  val morningGreetings = greetingMsg(_: String, "Good Morning")

  /**
    * Function Literal
    */
  val multBy2 = (x: Int) => x * 2
  /**
    * Closure
    */
  val multByz = (x: Int) => x * z

}
