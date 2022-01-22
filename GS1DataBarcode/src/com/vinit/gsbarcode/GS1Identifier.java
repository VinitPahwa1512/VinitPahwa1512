package com.vinit.gsbarcode;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/***
 * 
 * @author pahwa
 *
 */

public class GS1Identifier {
  private static final Map<GS1FieldName, GS1Identifier> INSTANCES = new HashMap<>();
  
  private final GS1FieldName name;
  
  private final String aiPrefix;
  
  private final int aiLength;
  
  private final int valueLength;
  
  private final boolean isValueFixedLength;
  
  private final boolean hasComma;
  
  private final GS1IdentifierType type;
  
  private final boolean isDate;
  
  static {

    addIdentifier(GS1FieldName.SerialShippingContainerCode, "00", 18, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GTIN, "01", 14, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GTINTransport, "02", 14, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.BatchNumber, "10", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ManufacturingDate, "11", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.DueDate, "12", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.PackagingDate, "13", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.FreshnessDate, "15", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.ExpirationDate, "17", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.ProductVariant, "20", 2, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.SerialNumber, "21", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.AdditionalProductidentification, "240", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CustomerNumber, "241", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.MadeToOrderVariationNumber, "242", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.PackagingComponentNumber, "243", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.SecondarySerialNumber, "250", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ReferenceToOriginalUnit, "251", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GDTI, "253", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLN, "254", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GlobalCouponNumber, "255", 25, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.QuantityPieces, "30", 8, false, false, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetWeightKg, "310", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LengthDimMeter, "311", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthDimMeter, "312", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightDimMeter, "313", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.SquareMeter, "314", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeLiter, "315", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeCubicMeter, "316", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WeightPounds, "320", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LengthDimInches, "321", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LengthDimFeet, "322", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LengthDimYards, "323", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthDim, "324", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthDimFeet, "325", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthDimYards, "326", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightDimInches, "327", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightDimFeet, "328", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightDimYards, "329", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.GrossWeightKg, "330", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LengthMLog, "331", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthMLog, "332", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightMLog, "333", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaM2Log, "334", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeLLog, "335", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeM3Log, "336", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.KGPerM2, "337", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.GrossWeightLb, "340", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LengthILog, "341", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LenghtFLog, "342", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.LenghtYLog, "343", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthILog, "344", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthFLog, "345", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.WidthYLog, "346", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightILog, "347", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightFLog, "348", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.HeightYLog, "349", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaI2, "350", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaF2, "351", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaY2, "352", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaI2Log, "353", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaF2Log, "354", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AreaY2Log, "355", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NewWeightT, "356", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetVolumeOZ, "357", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetVolumeLB, "360", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetVolumeG, "361", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeQLog, "362", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeGLog, "363", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetVolumeI3, "364", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetVolumeF3, "365", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.NetVolumeY3, "366", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeI3Log, "367", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeF3Log, "368", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.VolumeY3Log, "369", 6, true, true, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.Count, "37", 8, false, false, GS1IdentifierType.GS1_TYPE_QUANTITY, false);
    addIdentifier(GS1FieldName.AmountDue, "390", 15, false, true, GS1IdentifierType.GS1_TYPE_AMOUNT, false);
    addIdentifier(GS1FieldName.AmountDueIsoCode, "391", 18, false, true, GS1IdentifierType.GS1_TYPE_AMOUNT, false);
    addIdentifier(GS1FieldName.Amount, "392", 15, false, true, GS1IdentifierType.GS1_TYPE_AMOUNT, false);
    addIdentifier(GS1FieldName.AmountIsoCode, "393", 18, false, true, GS1IdentifierType.GS1_TYPE_AMOUNT, false);
    addIdentifier(GS1FieldName.PercentageDiscountOfACoupon, "394", 4, false, true, GS1IdentifierType.GS1_TYPE_PERCENT, false);
    addIdentifier(GS1FieldName.OrderNumber, "400", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Consignment, "401", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ShipmentNumber, "402", 17, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Route, "403", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLNShipToLoc, "410", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLNBillTo, "411", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLNPurchaseFrom, "412", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLNShipForLoc, "413", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GlobalLocationNumber, "414", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLNPayTo, "415", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GLNProdServLoc, "416", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ZipCodeWithCountryCode, "420", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ZipCodeWithCountryCode, "421", 12, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.OriginZipCode, "422", 3, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CountryInitialProcess, "423", 12, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CountryProcess, "424", 3, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CountryDisassembly, "425", 3, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CountryFullProcess, "426", 3, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CountrySubDivision, "427", 3, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.NatoStockNumber, "7001", 13, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.MeatCut, "7002", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ExpirationDateWithTime, "7003", 10, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ActivePotency, "7004", 4, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CatchArea, "7005", 12, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.FirstFreezeDate, "7006", 6, true, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.HarvestDate, "7007", 18, false, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.AquaticSpecies, "7008", 3, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.FishingGearType, "7009", 10, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ProductionMethod, "7010", 2, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.RefurbLot, "7020", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.FuncStat, "7021", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.RevStat, "7022", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GIAIAssembly, "7023", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ProcessorNumber, "703", 30, false, true, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.NHRNPZN, "710", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.NHRNCIP, "711", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.NHRNCN, "712", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.NHRNDRN, "713", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Dimensions, "8001", 14, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CMTNumber, "8002", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GRAI, "8003", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GIAI, "8004", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.SellingPrice, "8005", 6, true, false, GS1IdentifierType.GS1_TYPE_PRICE, false);
    addIdentifier(GS1FieldName.GCTIN, "8006", 18, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.IBAN, "8007", 34, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ProductionTime, "8008", 12, false, false, GS1IdentifierType.GS1_TYPE_MISC, true);
    addIdentifier(GS1FieldName.CPID, "8010", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CPIDSerial, "8011", 12, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Version, "8012", 20, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GSRNProvider, "8017", 18, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.GSRNRecipient, "8018", 18, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.SRIN, "8019", 10, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ReferenceNumber, "8020", 25, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.CouponIdendification, "8110", 70, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.LoyaltyPoints, "8111", 4, true, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.PaperlessCouponIdendification, "8112", 70, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.ProductionUrl, "8200", 70, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal0, "90", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal1, "91", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal2, "92", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal3, "93", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal4, "94", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal5, "95", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal6, "96", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal7, "97", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal8, "98", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
    addIdentifier(GS1FieldName.Internal9, "99", 30, false, false, GS1IdentifierType.GS1_TYPE_MISC, false);
  }
  
  public static synchronized void addIdentifier(GS1FieldName argName, String argAi, int argValueLength, boolean argIsValueFixedLength, boolean argHasComma, GS1IdentifierType argType, boolean argIsDate) {
    int aiLength = argAi.length() + (argHasComma ? 1 : 0);
    GS1Identifier gs1Identifier = new GS1Identifier(argName, argAi, aiLength, argValueLength, argIsValueFixedLength, argHasComma, argType, argIsDate);
    INSTANCES.put(argName, gs1Identifier);
  }
  
  public static GS1Identifier valueOf(GS1FieldName argName) {
    return INSTANCES.get(argName);
  }
  
  public static Collection<GS1Identifier> values() {
    return INSTANCES.values();
  }
  
  private GS1Identifier(GS1FieldName argName, String argAi, int argAiLength, int argValueLength, boolean argIsValueFixedLength, boolean argHasComma, GS1IdentifierType argType, boolean argIsDate) {
    this.name = argName;
    this.aiPrefix = argAi;
    this.aiLength = argAiLength;
    this.valueLength = argValueLength;
    this.isValueFixedLength = argIsValueFixedLength;
    this.hasComma = argHasComma;
    this.type = argType;
    this.isDate = argIsDate;
  }
  
  public int getAiLength() {
    return this.aiLength;
  }
  
  public String getAiPrefix() {
    return this.aiPrefix;
  }
  
  public boolean getHasComma() {
    return this.hasComma;
  }
  
  public GS1FieldName getName() {
    return this.name;
  }
  
  public GS1IdentifierType getType() {
    return this.type;
  }
  
  public boolean getValueFixedLength() {
    return this.isValueFixedLength;
  }
  
  public int getValueLength() {
    return this.valueLength;
  }
  
  public boolean isDate() {
    return this.isDate;
  }
  
  public String toString() {
    return getClass().getName() + " [Name:" + this.name + " AI:" + this.aiPrefix + " type:" + this.type + "]";
  }
}