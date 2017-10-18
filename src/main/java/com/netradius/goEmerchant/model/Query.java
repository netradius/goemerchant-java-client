package com.netradius.goemerchant.model;

import javax.validation.constraints.Size;

/**
 * Holds search data for searching transactions.
 *
 * @author Dilip S Sisodia
 */
public class Query extends MerchantInformation {

  @Size(max = 2)
  private String queryEndMonth;

  @Size(max = 2)
  private String queryEndDay;

  @Size(max = 4)
  private String queryEndYear;

  @Size(max = 2)
  private String queryEndHour;

  @Size(max = 2)
  private String queryEndMinute;

  @Size(max = 2)
  private String queryEndAMPM;

  @Size(max = 2)
  private String queryStartMonth;

  @Size(max = 4)
  private String queryStartYear;

  @Size(max = 2)
  private String queryStartHour;

  @Size(max = 2)
  private String queryStartMinute;

  @Size(max = 2)
  private String queryStartAMPM;

  @Size(max = 4)
  private String queryTimeZoneOffset;

  @Size(max = 50)
  private String queryAmountMax;

  @Size(max = 50)
  private String queryAmountMin;

  @Size(max = 50)
  private String queryOrderId;

  @Size(max = 50)
  private String queryOrderIdEndingWith;

  private String queryReferenceNo;

  private String queryBatchNo;

  @Size(min = 8, max = 75)
  private String queryVaultKey;

  private String isRecurring;

  @Size(max = 750)
  private String queryName;

  @Size(max = 4)
  private String queryCCLast4;

  private String queryGetCCTypeAmex;

  private String queryGetCCTypeDiscover;

  private String queryGetCCTypeMasterCard;

  private String queryGetCCTypeVisa;

  private TransactionType queryTransType;

  private TransactionStatus queryTransStatus;

}
