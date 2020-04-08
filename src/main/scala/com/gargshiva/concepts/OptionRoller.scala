package com.gargshiva.concepts

/**
  * #1: Use Pattern match with Option
  * #2 : Use getOrElse
  */
object OptionRoller {
  val numWords: Map[Int, String] = Map(
    1 -> "One",
    2 -> "Two",
    3 -> "Three"
  )

  def main(args: Array[String]): Unit = {
    // Return String or Throw NoSuchElementException
    numWords(1)

    //Recommended : Use get. It returns the option
    // #1: Use Pattern match with Option
    val optionWord: Option[String] = numWords.get(5)
    optionWord match {
      case Some(word) => println(word)
      case None => println("Not present in Map !")
    }

    // #2 : Use getOrElse
    println(numWords.getOrElse(100, "Not present in Map !"))


    println(fourthLetter(3))
    println(fourthLetter(2))

  }

  def fourthLetter(i: Int): Option[Char] = {
    for {
      word <- numWords.get(i)
      ch <- word.drop(3).headOption
    } yield ch
  }

  /**
    * Option with toSeq is recommended ; Some : Return Non-Empty list ; None : Empty List
    *
    * @param i
    * @return
    */
  def fetchFourthLetter(i: Int): Seq[Char] = {
    for {
      word <- numWords.get(i).toSeq
      ch <- word.drop(3).headOption.toSeq
    } yield ch
  }

}
