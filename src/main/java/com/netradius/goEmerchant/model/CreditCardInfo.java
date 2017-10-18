package com.netradius.goemerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Holds data for credit card.
 *
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardInfo {
  private String cardNumber;
  private String cardType;
  private String nameOnCard;
  private String cardExp;
}
