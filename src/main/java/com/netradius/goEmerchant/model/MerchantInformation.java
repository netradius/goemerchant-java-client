package com.netradius.goemerchant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Holds merchant information.
 *
 * @author Dilip S Sisodia
 */
@Data
public class MerchantInformation {

  @Size(max = 32)
  @NotEmpty
  private String merchantKey;

  @Size(max = 9)
  @NotEmpty
  private String processorId;
}
