package com.gargshiva.part3


import scala.util.{Failure, Success}

object FutureRoller {

  def main(args: Array[String]): Unit = {

    import scala.concurrent._
    import ExecutionContext.Implicits.global

    // Non-blocking operations on Future (Map/Filter/transform,collect)

    val mathCalculation: Future[Int] = Future {
      Thread.sleep(5000)
      10 * 100
    }

    val multiplierF: Future[Int] = mathCalculation.map(i => i * 2)
    val filterF: Future[Boolean] = multiplierF.map(i => i > 500)
    println(s"Main thread is non-blocking =>  ${filterF.value}")

    Thread.sleep(6000)

    println(filterF.value)
    //----------------------------------------------------------------
    val mathCalculationFailure: Future[Int] = Future {
      Thread.sleep(3000)
      throw new RuntimeException("Failure in calculation !")
    }

    val failureFuture = mathCalculationFailure.map(i => i * 3)
    Thread.sleep(5000)
    println(failureFuture.value)

    //-------------------------------------------------------------
    // transform -> success + failure fn literals
    val mathF = Future {
      Thread.sleep(100)
      100
    }

    val transformedFuture: Future[String] = mathF.transform(x => s"Success  Part : $x", x => {
      println("Failure part")
      x
    })

    Thread.sleep(1000)

    println(transformedFuture.value)

    //---------------------------------------------------------------
    // collect -> Partial function on future
    val mathFuture = Future {
      Thread.sleep(100)
      100
    }

    val collectSuccessFuture: Future[String] = mathF.collect {
      case x if x <= 100 => "Result <= 100"
    }

    val collectFailureFuture: Future[String] = mathF.collect {
      case x if x > 100 => "Result <= 100"
    }

    Thread.sleep(1000)

    println(collectSuccessFuture.value)
    println(collectFailureFuture.value)
    //---------------------------------------------------------------

    // Event handling using Futures (onComplete)
    val dbOperation = Future(10)
    dbOperation onComplete {
      case Success(value) => value
      case Failure(ex) =>
    }

    // Recover from Future Failures

    val f = Future.failed(new IllegalAccessException(""))

    f.fallbackTo(Future.successful(10))

    f.recover {
      case _: IllegalAccessException =>
    }

    f.recoverWith {
      case _: IllegalAccessException => Future.successful(10)
    }


  }
}
