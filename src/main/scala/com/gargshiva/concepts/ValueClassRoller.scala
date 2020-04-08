package com.gargshiva.concepts

object ValueClassRoller {
  def main(args: Array[String]): Unit = {
    User(UserId(10), UserName("Ten"))
    Twitter(TweetId(10),"I am value class - for optimizations")
  }
}

case class User(id: UserId, name: UserName)

case class Twitter(id: TweetId, content: String)


// Avoid boxing - dynamically creating objects
case class UserId(id: Int) extends AnyVal

case class UserName(name: String) extends AnyVal

case class TweetId(id: Int)