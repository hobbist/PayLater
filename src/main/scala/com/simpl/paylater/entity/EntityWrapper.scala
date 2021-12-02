package com.simpl.paylater.entity

class EntityWrapper(args:Array[String]) {
  def wrapUser:User=new User(name = args(1), email = args(2), creditLimit = args(3).toInt)
  def wrapUserPayback=new User(name=args(1),payBack = args(2).toInt)
  def wrapUserCreditLimit=new User(name=args(1),creditLimit = args(2).toInt)
  def wrapMerchant:Merchant= new Merchant(name = args(1), email = args(2), discount = args(3).toInt)
  def wrapMerchantDiscount:Merchant= new Merchant(name = args(1), discount = args(2).toInt)
  def wrapTransaction:Transaction=new Transaction(userId = args(1), merchantId = args(2), amount = args(3).toInt)
  def wrapReport:Report=null
}