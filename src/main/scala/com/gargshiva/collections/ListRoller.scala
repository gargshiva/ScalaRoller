package com.gargshiva.collections

/**
  * Recommended : foldLeft[B](acc:B)(fn:(B,A)=>B):B
  * Immutable
  * Covariant : A extend B , List[A] is subtype of List[B]
  */
object ListRoller {
  def main(args: Array[String]): Unit = {

    val li = (1 :: 2 :: 3 :: Nil) ::: (4 :: 5 :: Nil)
    println(li)

    val nums = List.tabulate(10)(x => x + x)
    val list1 = nums.foldLeft("acc")((a, b) => a + "," + b)
    println(list1)

    val sortedList1 = nums.sortWith((a, b) => a > b)
    println(sortedList1)

    val sortedList2 = nums.sorted
    println(sortedList2)


    val phone1 = Phone(10, "A")
    val phone2 = Phone(20, "B")

    val phoneList = List(phone1, phone2)

    val sortedPhoneList = phoneList.sortBy(phone => phone.phoneModel)
    println(s"Sorted using sortBy => ${sortedPhoneList}")

    implicit val ord1 = PhoneOrd2.ord
    println(s"Ascending Order => ${phoneList.sorted}")


    implicit object PhoneOrdering extends Ordering[Phone] {
      override def compare(x: Phone, y: Phone): Int = {
        y.age - x.age
      }
    }

    println(s"Descending Order => ${phoneList.sorted}")


  }
}

case class Phone(age: Int, phoneModel: String)

object PhoneOrd2 {
  implicit val ord = new Ordering[Phone] {
    override def compare(x: Phone, y: Phone): Int = {
      x.age - y.age
    }
  }
}