package com.netradius.goemerchant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Holds settle transaction data.
 *
 * @author Dilip S Sisodia
 */
@Data
public class Settle extends MerchantInformation {
  private boolean isAdjustment;

  @NotEmpty
  private String refNumber;

  @NotEmpty
  private String transactionAmount;

}
