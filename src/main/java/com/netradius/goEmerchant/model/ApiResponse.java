package com.netradius.goemerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Holds the response returned from api for goemerchant.
 *
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
  private SuccessResponseData data;
  private String isError;
  private String[] errorMessages;
  private String validationHasFailed;
  private String[] validationFailures;
  private String isSuccess;
  private String action;
}
