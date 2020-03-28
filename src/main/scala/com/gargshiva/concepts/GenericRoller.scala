package com.gargshiva.concepts

import java.io.File

import scala.io.Source

object GenericRoller {

  /**
    * Generic + HOF
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val inpFile = new File(getClass.getResource("/inputfiles/GenericRoller").toURI)

    // is first Line a question ?
    println(performOperationOnFile(inpFile, line => line.trim.endsWith("?"), defaultValue = false))

    // Covert first line to Upper case
    println(performOperationOnFile(inpFile, line => line.toUpperCase(), defaultValue = ""))

    // Most common letter in the first line
    val op = performOperationOnFile(inpFile, line => {
      val lineWithoutSpace: String = line.trim.filter(_ != ' ')
      val letters: Map[Char, String] = lineWithoutSpace.groupBy(identity)
      val characterCount: (Char, String) = letters.maxBy(pair => pair._2.toSeq.length)
      characterCount._1
    }, "")

    println("Most Common Char => " + op)
  }


  // Doing some operation on First Line of File
  def isFirstLineAQuestion(inputFile: File): Boolean = {
    val bufferedSource = Source.fromFile(inputFile)
    try {
      bufferedSource.getLines().toSeq.headOption.map(line => {
        line.trim.endsWith("?")
      }).getOrElse(false)
    } finally bufferedSource.close();
  }

  // Doing some operation on First Line of File
  def convertFirstLineToUpperCase(inputFile: File): String = {
    val bufferedSource = Source.fromFile(inputFile)
    try {
      bufferedSource.getLines().toSeq.headOption.map(line => {
        line.toUpperCase()
      }).getOrElse("")
    } finally bufferedSource.close()
  }

  // Generic Function
  def performOperationOnFile[T](inpFile: File, operation: String => T, defaultValue: T): T = {
    val bufferedSource = Source.fromFile(inpFile)
    try {
      bufferedSource.getLines().toSeq.headOption
        .map(operation)
        .getOrElse(defaultValue)
    } finally bufferedSource.close()
  }

}



