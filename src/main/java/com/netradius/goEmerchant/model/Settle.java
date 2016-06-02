package com.netradius.goEmerchant.model;

import com.netradius.goEmerchant.model.MerchantInformation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Dilip S Sisodia
 */
@Data
public class Settle extends MerchantInformation {
	private boolean isAdjustment;

	@NotEmpty
	private String refNumber;

	@NotEmpty
	private String transactionAmount;

}
