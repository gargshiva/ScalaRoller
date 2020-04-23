package com.gargshiva.part3

import scala.concurrent.Future
import scala.util.{Failure, Success}

object FutureRoller {
  def main(args: Array[String]): Unit = {

    // Non-blocking operations on Future (Map/Filter/transform,collect)


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
