package com.netradius.goemerchant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Holds data for credit transaction.
 *
 * @author Dilip S Sisodia
 */
@Data
public class Credit extends MerchantInformation {
  private Recurring recurring;

  @NotEmpty
  private String refNumber;

  @NotEmpty
  private String transactionAmount;
}
