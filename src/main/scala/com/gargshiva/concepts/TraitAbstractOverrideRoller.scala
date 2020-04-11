package com.gargshiva.concepts

class TraitAbstractOverrideRoller {

}

abstract class Bike {
  def describe: String
}

/**
  * describe calling abstract super method; Need to use Abstract Override
  *
  */

trait MotorBike extends Bike {
  abstract override def describe: String = {
    s" ${super.describe}"
  }
}