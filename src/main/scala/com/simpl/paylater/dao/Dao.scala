package com.simpl.paylater.dao

import scala.reflect.io.Directory

trait Dao[Entity] {
  val dbPath:String=System.getProperty("user.dir")
  var db:DB
}

class DB(val dir:Directory)
