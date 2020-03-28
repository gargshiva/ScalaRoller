package com.gargshiva.concepts

/**
  * Partial Function are defined only for some of the arguments.
  * Complete Functions are defined for all of the arguments.
  *
  * Ex : Scala Match , Catch block use Partial Functions
  */
object PartialFunctionRoller {
  def main(args: Array[String]): Unit = {
    readFile("hello")

    /**
      * isDefinedAt automatically
      */
    readFile.isDefinedAt("PDF")
    readFile.isDefinedAt("CSV")

    val formats = "CSV" :: "PDF" :: "JSON" :: Nil

    /**
      * Collect require partial function to do Map + Filter
      */
    println(formats.collect(readFile))
  }

  /**
    * Partial Function which supports only CSV,JSON file type.
    * Scala Match Error if case doesn't match
    * Ex : Scala Match , Catch block use Partial Functions
    */
  val readFile: PartialFunction[String, String] = {
    case "JSON" => "JSON is supported"
    case "CSV" => "CSV is supported"
  }

}