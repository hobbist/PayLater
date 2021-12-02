package com.simpl.paylater.validator

import com.simpl.paylater.entity.{Merchant, Report, Transaction, User}

object EntityValidator {

  def validateNewUser(user:User):Boolean=validateEmail(user.email) && validateCreditLimit(user.creditLimit)
  def validateNewMerchant(merchant:Merchant):Boolean=validateEmail(merchant.email) && validateDiscountAmount(merchant.discount)
  def validateTransaction(transaction: Transaction):Boolean=false

  /**
    * Method checks if inputEmailString is valid.
    * @param emailString
    * @return
    */
  private def validateEmail(emailString: String): Boolean = if(emailString!=null && emailString.length>0 && """(?=[^\s]+)(?=(\w+)@([\w\.]+))""".r.findFirstIn(emailString) == None)false else true

  /**Method checks if numeric CreditLimit is greater than or equal to Zero
    *
    * @param creditLimit
    * @return
    */
  private def validateCreditLimit(creditLimit: Int): Boolean = creditLimit>=0


  /**
    * Mehod Checks if numeric Discount is greater than or equal to Zero
    * @param discount
    * @return
    */
  private def validateDiscountAmount(discount:Int):Boolean = discount>=0

  private def validateNumeric(amount:Int):Boolean = amount>0

}
