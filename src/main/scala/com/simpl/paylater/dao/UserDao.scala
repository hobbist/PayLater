package com.simpl.paylater.dao

import java.io

import com.simpl.paylater.entity.User

import scala.reflect.io.{Directory, File}

class UserDao extends Dao[User] {
  override var db: DB = _
  this()={
    val db=new DB(new Directory(new java.io.File(s"$dbPath/users")))
    if(!db.dir.exists){
      db.dir.createDirectory(failIfExists = true)
    }
  }

  def addUser(user:User): Unit = {
    val dir=db.dir
      if(!new io.File(s"${dir.path}/${user.name}").exists()){
        val userRec:File = new File(new io.File(s"${dir.path}/${user.name}"))
        userRec.appendAll(user.toString)
      }
    }
}
