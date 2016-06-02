package com.netradius.goEmerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardInfo {
	private String cardNumber;
	private String cardType;
	private String nameOnCard;
	private String cardExp;
}
