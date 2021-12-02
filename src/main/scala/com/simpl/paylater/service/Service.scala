package com.simpl.paylater.service

import com.simpl.paylater.Command.Command
import com.simpl.paylater.entity.Entity

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
  val userService:Value=Value
  val merchantService:Value=Value
  val transactionService:Value=Value
  val reportingService:Value=Value
}


trait Service {
 def serveCommand(command: Command,entity: Entity):Option[Any]
}