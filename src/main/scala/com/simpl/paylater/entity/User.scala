package com.simpl.paylater.entity


class User(val name:String,val email:String="",val creditLimit:Int=0,val payBack:Int=0) extends Entity {
  override def toString: String = {
    s"name=$name \n email= $email \n creditLimit=$creditLimit \n payBack= $payBack"
  }
}
