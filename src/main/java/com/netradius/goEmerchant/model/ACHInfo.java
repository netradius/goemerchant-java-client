package com.netradius.goEmerchant.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Dilip S Sisodia
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ACHInfo {
	private String salesTax;
	private String aba;
	private String dda;
	private String accountType;
	private String number;
	private String categoryText;
	private String classCode;
	private String entry;
}
