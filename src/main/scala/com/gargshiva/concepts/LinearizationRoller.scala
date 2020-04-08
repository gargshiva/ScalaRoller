package com.gargshiva.concepts

/**
  * Concept : Scala doesn't decide Super at compile time;
  * It decides the super based on Mixing the trait.
  *
  * Or , Scala treats Super different in Compile and Runtime.
  */
object LinearizationRoller {
  def main(args: Array[String]): Unit = {
    println(new ClassicConvertible1("BMW", "Black"))
  }

}

abstract class MotorCar(maker: String) {
  val color: String

  def describe: String = s"$color $maker"

  override def toString: String = {
    s"$describe MotorCar"
  }
}

trait Classic extends MotorCar {
  def vintage: Int

  override def describe: String = {
    s"Vintage $vintage ${super.describe}"
  }
}

trait Convertible extends MotorCar {
  override def describe: String = {
    s"Convertible ${super.describe}"
  }
}

trait PoweredConvertible extends Convertible {
  override def describe: String = {
    s"Powered ${super.describe}"
  }
}

trait HardTopConvertible extends Convertible {
  override def describe: String = {
    s"HardTop ${super.describe}"
  }
}

/**
  * PoweredConvertible is super of Classic
  * @param maker
  * @param color
  */
class ClassicConvertible1(maker: String, val color: String) extends MotorCar(maker) with PoweredConvertible with Classic with HardTopConvertible {
  override def vintage: Int = 1920
}

/**
  * /**
  * * Class is super of PoweredConvertible
  * * @param maker
  * * @param color
  **/
  * @param maker
  * @param color
  */
class ClassicConvertible2(maker: String, val color: String) extends MotorCar(maker) with Classic with PoweredConvertible with HardTopConvertible {
  override def vintage: Int = 1920
}