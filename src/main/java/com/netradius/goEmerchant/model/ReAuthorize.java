package com.netradius.goemerchant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Holds ReAuthorize transaction data.
 *
 * @author Dilip S Sisodia
 */
@Data
public class ReAuthorize extends MerchantInformation {

  private boolean autoGenerateOrderId;

  private boolean orderIdIsUnique;

  @Size(max = 50)
  @NotEmpty
  private String orderId;

  @NotEmpty
  private String transactionAmount;

  @Size(max = 10)
  private String closeDate;

  private Recurring recurring;

  @NotEmpty
  private String refNumber;


}
