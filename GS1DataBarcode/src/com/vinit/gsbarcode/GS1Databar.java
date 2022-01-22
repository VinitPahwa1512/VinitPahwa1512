package com.vinit.gsbarcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/***
 * 
 * @author pahwa
 *
 */
public class GS1Databar implements IGS1Databar {

  
  public Optional<GS1Result> checkAIValuePair(GS1FieldName argAI, String argValue) {
    return checkAiValuePairImpl(argAI, argValue);
  }
  
  public Optional<GS1Identifier> findGS1IdentifierByPrefix(String argAI) {
    for (GS1Identifier gs1Identifier : GS1Identifier.values()) {
      String gs1ai = gs1Identifier.getAiPrefix();
      if (argAI.startsWith(gs1ai))
        return Optional.of(gs1Identifier); 
    } 
    return Optional.empty();
  }
  
  public Optional<Map<GS1FieldName, GS1Result>> parseGS1Databarcode(String argGs1DatabarCode) {
    return parseGS1Databarcode(argGs1DatabarCode, '\035');
  }
  
  public Optional<Map<GS1FieldName, GS1Result>> parseGS1Databarcode(String argGs1DatabarCode, char argGS1Separator) {
    return parseGS1DatabarcodeImpl(argGs1DatabarCode, argGS1Separator);
  }
  
  
  protected Optional<GS1Identifier> findGS1IdentifierByName(GS1FieldName argAI) {
    if (argAI == null)
      return Optional.empty(); 
    for (GS1Identifier gs1Identifier : GS1Identifier.values()) {
      if (argAI == gs1Identifier.getName())
        return Optional.of(gs1Identifier); 
    } 
    return Optional.empty();
  }
  
  protected Optional<Map<GS1FieldName, GS1Result>> parseGS1DatabarcodeImpl(String argGs1DatabarCode, char argGS1Separator) {
    Map<GS1FieldName, GS1Result> result = new HashMap<>();
    String code = argGs1DatabarCode;
    while (!code.isEmpty()) {
      GS1Result gs1Entry;
      if (code.charAt(0) == argGS1Separator) {
        code = code.substring(1);
        continue;
      } 
      Optional<GS1Identifier> maybeGs1id = findGS1IdentifierByPrefix(code);
      if (!maybeGs1id.isPresent()) {
        return Optional.empty();
      } 
      GS1Identifier gs1id = maybeGs1id.get();
      int aiLength = gs1id.getAiLength();
      int groupLength = Math.min(code.length(), aiLength + gs1id.getValueLength());
      if (!gs1id.getValueFixedLength()) {
        int gsSepIndex = code.indexOf(argGS1Separator);
        if (gsSepIndex != -1)
          groupLength = Math.min(groupLength, gsSepIndex); 
      } 
      String ai = code.substring(0, aiLength);
      String value = code.substring(aiLength, groupLength);
      if (gs1id.getHasComma()) {
        try {
          int delimiterPosition = Integer.parseInt(ai.substring(aiLength - 1));
          gs1Entry = new GS1Result(ai, value, gs1id.getHasComma(), delimiterPosition);
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Invalid delimiter position value in AI: " + ai);
        } 
      } else {
        gs1Entry = new GS1Result(ai, value, false, 0);
      } 
      result.put(gs1id.getName(), gs1Entry);
      code = code.substring(groupLength);
    } 
    return Optional.of(result);
  }
  
  private Optional<GS1Result> checkAiValuePairImpl(GS1FieldName argAI, String argValue) {
    GS1Result gs1Entry;
    if (argAI == null || argValue == null)
      return Optional.empty(); 
    Optional<GS1Identifier> gs1 = findGS1IdentifierByName(argAI);
    if (!gs1.isPresent())
      return Optional.empty(); 
    GS1Identifier gs1id = gs1.get();
    if (gs1id.getValueFixedLength()) {
      if (gs1id.getValueLength() != argValue.length())
        return Optional.empty(); 
    } else if (gs1id.getValueLength() < argValue.length()) {
      return Optional.empty();
    } 
    String ai = gs1id.getAiPrefix();
    if (gs1id.getHasComma()) {
      try {
        int delimiterPosition = Integer.parseInt(ai.substring(ai.length() - 1));
        gs1Entry = new GS1Result(ai, argValue, gs1id.getHasComma(), delimiterPosition);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid delimiter position value in AI: " + ai);
      } 
    } else {
      gs1Entry = new GS1Result(ai, argValue, false, 0);
    } 
    if (gs1id.isDate())
      return Optional.empty(); 
    return Optional.of(gs1Entry);
  }
}
