package com.simpl.paylater.entity

import com.simpl.paylater.Command

class Report(val command: Command.Value,val args:String*) extends Entity {

}


