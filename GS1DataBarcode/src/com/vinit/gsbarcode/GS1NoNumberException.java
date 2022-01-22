package com.vinit.gsbarcode;


/***
 * 
 * @author pahwa
 *
 */
public class GS1NoNumberException extends GS1ParserException {
  private static final long serialVersionUID = 1L;
  
  public GS1NoNumberException(String message) {
    super(message);
  }
}
