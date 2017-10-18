package com.netradius.goemerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Holds the billing information data.
 *
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingInfo {
  private String street;
  private String city;
  private String state;
  private String postalCode;
  private String country;
  private String phoneNumber;
  private String emailAddress;
}

