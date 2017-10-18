package com.netradius.goemerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Order data for successful response. Used in SuccessResponseData.
 *
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseOrder {
  private String transactionId;
  private String referenceNumber;
  private boolean isAch;
  private BillingInfo billingInfo;
  private OrderInfo orderInfo;
  private CreditCardInfo ccInfo;
  private ACHInfo achInfo;
}
