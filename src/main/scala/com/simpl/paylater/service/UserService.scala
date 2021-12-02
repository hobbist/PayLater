package com.simpl.paylater.service

import com.simpl.paylater.Command
import com.simpl.paylater.Command.Command
import com.simpl.paylater.entity.Entity

class UserService extends Service {
  override def serveCommand(command: Command,entity: Entity):Option[Any] = {
    command match {
      case Command.adduser => _
    }
  }
}
