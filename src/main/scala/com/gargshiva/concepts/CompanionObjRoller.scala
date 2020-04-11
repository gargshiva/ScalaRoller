package com.gargshiva.concepts


object CompanionObjRoller {

  def main(args: Array[String]): Unit = {

    //new ShippingContainer[String](List(""))
    val ob = ShippingContainer[String]("A", "B")
    ShippingContainer.containerFull(ob)
  }

}


/**
  * Private constructor ; Forced to use Factory methods
  * private[gargshiva] : Class can be used within gargshiva package
  *
  * @param items
  * @tparam T
  */
private[gargshiva] class ShippingContainer[T] private(val items: Seq[T]) {
  /**
    * Scope specific to instance; Can't be accessed by the companion object, other instances
    */
  private[this] val maxCapacity: Int = 100

  private def isFull: Boolean = {
    items.length == maxCapacity
  }

  override def toString: String = {
    "Shipping Container"
  }
}

object ShippingContainer {
  def apply[T](items: T*): ShippingContainer[T] = new ShippingContainer[T](items)

  /**
    * Can't access private[this]
    *
    * @param container
    * @return
    */
  def maxItems(container: ShippingContainer[_]): Int = {
    // container.maxCapacity
    10
  }

  /**
    * Can access private members
    *
    * @param container
    * @return
    */
  def containerFull(container: ShippingContainer[_]): Boolean = {
    {
      import CurryingRoller.add2
      import PackageObjectRoller.greeting
      println(add2(10, 2))
      println(greeting)
    }
    container.isFull
  }
}