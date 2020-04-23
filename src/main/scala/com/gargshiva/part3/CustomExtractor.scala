package com.gargshiva.part3

object CustomExtractor {
  def main(args: Array[String]): Unit = {
    val user: User = new PremiumUser("Shiva")

    /**
      * FreeUser.unapply method should be defined which take instanceOf(user) as a type.
      * Ex: RandomUser.unapply(user:User) is not defined , so RandomUser cannot be used
      */
    println(
      user match {
      //  case RandomUser(_) => s"Random User "
       // case FreeUser(name) => "Hello " + name
        case PremiumUser("Shiva") => "Welcome back, dear"
        case PremiumUser(name) => "Welcome back, dear " + name
      })
  }
}

class Shiva

trait User {
  def name: String
}

class FreeUser(val name: String) extends User

object FreeUser {
  def unapply(user: Person): Option[String] = {
    println("Unapply Freeuser")
    Some("")
  }

  def unapply(user: String): Option[String] = {
    println("Unapply Freeuser")
    Some("")
  }
}


class PremiumUser(val name: String) extends User

object PremiumUser {
  def unapply(user: PremiumUser): Option[String] = {
    println(s"Unapply Premium ${user.name}")
    Some(user.name)
  }
}

class RandomUser(val name: String)

object RandomUser {
  def unapply(arg: Double): Option[String] = {
    println("RandomUser unapply")
    Some("")
  }

 /* def unapply(arg: RandomUser): Option[String] = {
    println("RandomUser unapply")
    Some("")
  }*/
}


class Person


