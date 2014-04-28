package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.VerificationStatusDeserializer;

/**
 * Use {@link VerificationStatus} to indicate the payment method has been verified.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=VerificationStatusDeserializer.class)
public enum VerificationStatus {
	SUCCESS("$success"),
	FAILURE("$failure"),
	PENDING("$pending");
	
	private String siftScienceValue;

	private VerificationStatus(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static VerificationStatus resolve(final String siftScienceValue) {
		
		for (VerificationStatus ele : VerificationStatus.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Verification status [%s] is not supported by this enum.", siftScienceValue));
	}
}