package com.vinit.gsbarcode;


import java.util.Map;
import java.util.Optional;


/***
 * 
 * @author pahwa
 *
 */
public interface IGS1Databar {
  public static final char GS1_GROUP_SEPARATOR = '\035';
  
  Optional<GS1Result> checkAIValuePair(GS1FieldName paramGS1FieldName, String paramString);
  
  Optional<Map<GS1FieldName, GS1Result>> parseGS1Databarcode(String paramString);
  
  Optional<Map<GS1FieldName, GS1Result>> parseGS1Databarcode(String paramString, char paramChar);
  
  Optional<GS1Identifier> findGS1IdentifierByPrefix(String paramString);
}
