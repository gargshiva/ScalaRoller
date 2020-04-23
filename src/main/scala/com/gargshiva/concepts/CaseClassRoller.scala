package com.gargshiva.concepts

/**
  * Case class provides :
  * Equals and hashcode
  * Public Parametric field
  * Factory methods
  * Pattern match
  * Copy method - Modify the case class (by default)
  */
object CaseClassRoller {
  def main(args: Array[String]): Unit = {
    val transactionEvent: TransactionEvent = TransactionEvent(10, "Ten")
    val newTxnEvent = transactionEvent.copy(name = "Shiva")
    println(newTxnEvent)

    /**
      * Val ia pattern match
      */
    val TransactionEvent(number, "Ten") = transactionEvent
    println(number)

    val (a, b, c) = (10, "hello", 10.2)
    println(a + "," + b + "," + c)

    /**
      * for loop is a pattern match
      */

    val li: Seq[Int] = 1 :: 2 :: Nil
    val op: Seq[Int] = for (element <- li) yield {
      if (element > 10) element
      else 0
    }

    println(op)

    val op1 = for {
      TransactionEvent(number, _) <- List(transactionEvent)
    } yield number

    println(op1)
  }
}

case class TransactionEvent(seqNum: Int, name: String)