package com.gargshiva.part3

class SealedClassRoller {

}

/**
  * Sealed keyword to make sure classes in the current file can extend the Sealed class
  */
sealed abstract class Account

case class Savings(acctNo: String) extends Account

case class Current(accNo: String) extends Account