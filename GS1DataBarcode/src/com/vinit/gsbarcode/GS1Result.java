package com.vinit.gsbarcode;

public class GS1Result {
	  protected String ai;
	  
	  protected String value;
	  
	  protected boolean hasComma;
	  
	  protected int commaPosition;
	  
	  public GS1Result(String argAi, String argValue, boolean argHasComma, int argCommaPosition) {
	    this.ai = argAi;
	    this.value = argValue;
	    this.hasComma = argHasComma;
	    this.commaPosition = argCommaPosition;
	  }
	  
	  public String getAi() {
	    return this.ai;
	  }
	  
	  public int getCommaPosition() {
	    return this.commaPosition;
	  }
	  
	  public String getValue() {
	    return this.value;
	  }
	  
	  public boolean isHasComma() {
	    return this.hasComma;
	  }
	  
	  public String toString() {
	    return getClass().getName() + "[AI:" + this.ai + ", VALUE:" + this.value + "]";
	  }
	}
