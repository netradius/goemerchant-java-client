package com.netradius.goEmerchant.model;

import com.netradius.goEmerchant.model.MerchantInformation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author Dilip S Sisodia
 */
@Data
public class Credit extends MerchantInformation {
	private Recurring recurring;

	@NotEmpty
	private String refNumber;

	@NotEmpty
	private String transactionAmount;
}
