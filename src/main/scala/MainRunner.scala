import com.simpl.paylater.{Command, FlowExecutor}
/**
  * Entry point object of Application.
  * Assumptions -
  * 1. Merchant discount will be only number and not number"%"
  * 2.
  */
object MainRunner{
   def main(args: Array[String]): Unit = {
      val command=strToCommand(args(0)).get
      //flow executor to decide which validations/wrapper/service to execute to get result
     new FlowExecutor(command,args)
  }

  def strToCommand(inputCommandString:String):Option[Command.Value]={
    var command:Command.Value=null
     inputCommandString match {
    case Command.adduser.toString  =>  command=Command.adduser
    case Command.addmerchant.toString =>command= Command.addmerchant
    case Command.transcation.toString =>command= Command.transcation
    case Command.paybackuser.toString => command=Command.paybackuser
    case Command.updatemerchantdiscount.toString =>command= Command.updatemerchantdiscount
    case Command.discountbymerchant.toString =>command= Command.discountbymerchant
    case Command.userswithCL.toString => command=Command.userswithCL
    case Command.totaldues.toString =>command= Command.totaldues
    case Command.totaldues.toString =>command= Command.updateuserCL
    case _ => command=Command.wrongCommand
  }
    Some(command)
  }
}

