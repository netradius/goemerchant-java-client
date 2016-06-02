package com.netradius.goEmerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
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
