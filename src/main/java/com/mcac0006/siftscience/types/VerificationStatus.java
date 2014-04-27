package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Use {@link VerificationStatus} to indicate the payment method has been verified.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public enum VerificationStatus {
	SUCCESS("$success"),
	FAILURE("$failure"),
	PENDING("$pending");
	
	private String value;

	private VerificationStatus(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
}