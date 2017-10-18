package com.netradius.goemerchant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Holds void transaction data.
 *
 * @author Dilip S Sisodia
 */
@Data
public class VoidTransaction extends MerchantInformation {
  @NotEmpty
  private String refNumber;
}
