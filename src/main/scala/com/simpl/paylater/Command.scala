package com.simpl.paylater

/**
  * Enumeration Object holding commands supported in paylater app.
  */
object Command extends Enumeration {
  type Command = Value
  val adduser =Value
  val paybackuser =Value
  val addmerchant =Value
  val transcation = Value
  val updateuserCL =Value
  val updatemerchantdiscount =Value
  val discountbymerchant =Value
  val userswithCL =Value
  val totaldues = Value
  val wrongCommand=Value
}