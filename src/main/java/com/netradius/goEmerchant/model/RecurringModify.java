package com.netradius.goEmerchant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author Dilip S Sisodia
 */
@Data
public class RecurringModify extends MerchantInformation {

	@NotEmpty
	private String referenceNumber;

	private String recurring;

	private Recurring recurringType;

	private String recurringStartDate;

	private String recurringEndDate;

	@NotEmpty
	private String recurringAmount;

	@Size(max = 10)
	private String ownerZip;

	@Size(max = 25)
	private String ownerPhone;

	@Size(max = 300)
	private String ownerEmail;

	private String sendInvoice;

}
