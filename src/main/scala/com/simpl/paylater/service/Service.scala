package com.simpl.paylater.service

object ServiceFactory
{
  def getCommandService[A >: Service](serviceType:ServiceEnum.Value):Option[A]={
    val result=serviceType match {
      case userService => Some(new UserService)
      case merchantService => Some(new MerchantService)
      case transactionService => Some(new TransactionService)
      case reportingService => Some(new ReportingService)
      case _ => None
    }
    result
  }

}
object ServiceEnum extends Enumeration{
  type serviceEnum=Value
  val userService=Value
  val merchantService=Value
  val transactionService=Value
  val reportingService=Value
}


trait Service {

}