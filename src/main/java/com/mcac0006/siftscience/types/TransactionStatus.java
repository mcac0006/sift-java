package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.TransactionStatusDeserializer;



/**
 * The transaction status gives us an idea whether the transaction is complete and successful/failed, 
 * or whether it is being held up by 3D Secure (thus pending). This is important to get a better idea 
 * of the transaction's lifetime.
 * 
 * @author <a href="mailto:matthew.cachia@ixaris.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=TransactionStatusDeserializer.class)
public enum TransactionStatus {
	
	PENDING ("$pending"),
	SUCCESS ("$success"),
	FAILURE("$failure");
	
	private String siftScienceValue;
	
	TransactionStatus(final String siftScienceValue) {
		this.siftScienceValue=siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static TransactionStatus resolve(final String siftScienceValue) {
		
		for (TransactionStatus ele : TransactionStatus.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Transaction Status [%s] is not supported by this enum.", siftScienceValue));
	}
};