package com.netradius.goEmerchant.model;

import com.netradius.goEmerchant.model.ResponseOrder;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * @author Dilip S Sisodia
 */
@Data
public class SuccessResponseData {
	private String authResponse;
	private String authCode;
	private String referenceNumber;
	private String isPartial;
	private String partialId;
	private String originalFullAmount;
	private String partialAmountApproved;
	private String avsResponse;
	private String cvv2Response;
	private String orderId;
	private String last4;
	private String maskedPan;
	private String creditAmount;
	private List<ResponseOrder> orders;
	private String settleAmount;
	private String batchNumber;
	private String isRecordModified;
}
