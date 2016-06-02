package com.netradius.goEmerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfo {

	private String transactionType;
	private String authResponse;
	private String authCode;
	private String orderId;
	private String avsResponse;
	private String cvv2Response;
	private String isSuccessful;
	private String isPartial;
	private String partialId;
	private String amount;
	private String gratuityAmount;
	private String transDateAndTime;
	private String transactionDate;
	private String transactionTime;
	private String batchNumber;
	private String cimRefNumber;
	private String closeDate;
	private String closeTime;

}
