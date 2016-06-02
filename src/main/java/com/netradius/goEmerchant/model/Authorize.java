package com.netradius.goEmerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Authorize extends MerchantInformation {

	private String autoGenerateOrderId;

	private String orderIdIsUnique;

	@Size(max = 50)
	private String orderId;

	private String preventPartial;

	@NotEmpty
	private String transactionAmount;

	private String traceModeEnabled;

	@Size(max = 20)
	@NotEmpty
	private String cardNumber;

	@Size(max = 2)
	@NotEmpty
	private String cardExpMonth;

	@Size(max = 2)
	@NotEmpty
	private String  cardExpYear;

	@Size(max = 4)
	@NotEmpty
	private String cVV;

	private String creditCardCryptogram;

	@Size(max = 100)
	@NotEmpty
	private String ownerCity;

	@Size(max = 200)
	@NotEmpty
	private String ownerCountry;

	@Size(max = 100)
	@NotEmpty
	private String ownerState;

	@Size(max = 250)
	@NotEmpty
	private String ownerStreet;

	@Size(max = 250)
	private String ownerStreet2;

	@Size(max = 10)
	@NotEmpty
	private String ownerZip;

	@Size(max = 300)
	private String ownerEmail;

	@Size(max = 750)
	@NotEmpty
	private String ownerName;

	@Size(max = 25)
	private String ownerPhone;

	private String magData;

	private String ksn;

	private String encryptionBlockType;

	private String localTaxFlag;

	@Size(max = 75)
	private String customerRefNo;

	@Size(max = 9)
	private String shippingZip;
	private String purchaseCard;
	private String taxAmount;
	private Recurring recurring;

}
