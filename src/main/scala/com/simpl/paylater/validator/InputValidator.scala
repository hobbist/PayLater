package com.simpl.paylater.validator

import com.simpl.paylater.Command

class InputValidator(args:Array[String]) {

  /** Method Validates the Length and type of parameters provided for each command.
    * Also commands are Strictly types, meaning case and word of command has to matcch
    * @return
    */
  def validateCommandLineInputs(expectedLength:Int,numericPlaces:List[Int]): Boolean = {
    validateCommandArgsLength(expectedLength) && validateNumeric(numericPlaces)
  }

  private def validateCommandArgsLength(expectedLength:Int):Boolean = args.length==expectedLength

  private def validateNumeric(numericPlaces:List[Int]):Boolean = {
    var numericeFound=true
    numericPlaces.foreach(x=> numericeFound=numericeFound && args(x).forall(_.isWhole()))
    numericeFound
  }
}