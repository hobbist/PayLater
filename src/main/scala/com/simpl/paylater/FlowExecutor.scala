package com.simpl.paylater

import com.simpl.paylater.entity.EntityWrapper
import com.simpl.paylater.service._
import com.simpl.paylater.validator.{EntityValidator, InputValidator}

class FlowExecutor(command: Command.Value,implicit val args:Array[String]) {
  val entityWrapper:EntityWrapper=new EntityWrapper(args)
  val inputValidator:InputValidator=new InputValidator(args)
  def executeFlowForCommand:Option[Any]={
    command match {
      case Command.adduser =>
        if (inputValidator.validateCommandLineInputs(4,List(4))){
        val user = entityWrapper.wrapUser
        EntityValidator.validateNewUser(user)
        ServiceFactory.getCommandService(ServiceEnum.userService).get.serveCommand(command,user)
        }

      case Command.paybackuser =>
        if (inputValidator.validateCommandLineInputs(3,List(2))){
          val user= entityWrapper.wrapUserPayback
          EntityValidator.validateNewUser(user)
          service.ServiceFactory.getCommandService(ServiceEnum.userService).getOrElse()

        }

      case Command.updateuserCL =>
        if (inputValidator.validateCommandLineInputs(3,List(2))){
          //wrap correctly
          val user= entityWrapper.wrapUserCreditLimit
          EntityValidator.validateNewUser(user)
          service.ServiceFactory.getCommandService(ServiceEnum.userService).getOrElse()
        }

      case Command.addmerchant =>
        if (inputValidator.validateCommandLineInputs(4,List(4)))
          entityWrapper.wrapMerchant
        service.ServiceFactory.getCommandService(ServiceEnum.merchantService).getOrElse()

      case Command.updatemerchantdiscount =>
        if (inputValidator.validateCommandLineInputs(3,List(2)))
          entityWrapper.wrapMerchantDiscount
        service.ServiceFactory.getCommandService(ServiceEnum.merchantService).getOrElse()


      case Command.transcation =>
        if (inputValidator.validateCommandLineInputs(3,List(2)))
          entityWrapper.wrapTransaction
          service.ServiceFactory.getCommandService(ServiceEnum.transactionService).getOrElse()


      case Command.discountbymerchant =>
        if (inputValidator.validateCommandLineInputs(2,List())) {
          entityWrapper.wrapReport
          service.ServiceFactory.getCommandService(ServiceEnum.reportingService).getOrElse()
        }

      case Command.userswithCL =>
        if (inputValidator.validateCommandLineInputs(1,List())) {
          entityWrapper.wrapReport
          service.ServiceFactory.getCommandService(ServiceEnum.reportingService).getOrElse()
        }

      case Command.totaldues =>
        if (inputValidator.validateCommandLineInputs(1,List())){
          entityWrapper.wrapReport
          service.ServiceFactory.getCommandService(ServiceEnum.reportingService).getOrElse()

        }

      case Command.wrongCommand =>

    }
    None
  }

  /*
Generates the String as initial usage descriptior
 */
  def UsageStr:String="Usage"
}
