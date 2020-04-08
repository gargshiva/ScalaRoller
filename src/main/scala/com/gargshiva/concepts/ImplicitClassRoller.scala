package com.gargshiva.concepts

import com.gargshiva.concepts.IntHelper._
import com.gargshiva.concepts.StringHelper._

import scala.language.implicitConversions

/**
  * https://dotty.epfl.ch/docs/reference/changed-features/implicit-conversions.html
  */
object ImplicitClassRoller {
  def main(args: Array[String]): Unit = {
    /**
      * Integer class doesn't have times method.
      * Scala look into implicit scope to check times method
      */
    5 times println("shiva")

    println("ShivaGarg".base64Encode())
  }
}


object IntHelper {

  implicit class IntExtension(n: Int) {
    def times(fn: => Unit): Unit = {
      for (_ <- 1 to n) fn
    }
  }

}

/**
  * Implicit class can be used to extend the functionality of existing class.
  * Ex : StringHelper is extending the functionality the String class by introducing base64Encode()
  */
object StringHelper {

  implicit class StringExtension(s: String) {
    def base64Encode(): String = {
      import java.util.Base64
      Base64.getEncoder.encode(s.getBytes()).toString
    }
  }

}

