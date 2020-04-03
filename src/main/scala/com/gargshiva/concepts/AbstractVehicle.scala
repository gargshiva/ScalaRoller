package com.gargshiva.concepts

/**
  * make -> Parametric fields (Public)
  * age -> Private field
  * Abstract methods rules : def can be overriden by val but not-vice versa since val is evaluated only once while def is evaluated each time its invoked(lazily).
  *
  * @param make
  * @param age
  */
abstract class AbstractVehicle(val make: String, age: Int) {
  override def toString: String = {
    s"""Vehicle make : $make,
       |Vehicle age : $age
     """.stripMargin
  }

  def isVintage: Unit
}

/**
  * make -> Public field but already described in super class , Subclass must override
  * model -> parametric field
  *
  * @param make
  * @param model
  */
class Car(override val make: String, val model: String) extends AbstractVehicle(make, 10) {
  // Optional : Can be marked override
  def isVintage: Unit = true
}

/**
  * make -> private field , so don't need to override the public field described in super class
  *
  * @param make
  * @param year
  *
  */
class Truck(make: String, year: Int) extends AbstractVehicle(make, year) {

  override val isVintage: Unit = false
}