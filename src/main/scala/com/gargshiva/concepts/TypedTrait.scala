package com.gargshiva.concepts

object TypedTrait {
  def main(args: Array[String]): Unit = {
    val person1 = Person("Ten", 10)
    val person2 = Person("Thirteen", 13)
    println(getOlder(person1, person2))
  }

  def getOlder[T <: CompareAge[T]](obj1: T, obj2: T): T = {
    obj1.older(obj2)
  }
}

trait CompareAge[T] {
  def older(other: T): T
}

case class Person(name: String, age: Int) extends CompareAge[Person] {
  override def older(other: Person): Person = {
    if (this.age < other.age) other
    else this
  }
}
