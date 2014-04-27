package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.TransactionTypeDeserializer;


/**
 * The type of transaction being recorded. There are five types.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=TransactionTypeDeserializer.class)
public enum TransactionType {

	SALE("$sale"),
	AUTHORIZE("$authorize"),
	CAPTURE("$capture"),
	VOID("$void"),
	REFUND("$refund");
	
	private String siftScienceValue;

	private TransactionType(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}

	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static TransactionType resolve(final String siftScienceValue) {
		
		for (TransactionType type : TransactionType.values()) {
			if (type.getSiftScienceValue().equals(siftScienceValue))
				return type;
		}
		
		throw new IllegalArgumentException(String.format("Transaction Type [%s] is not supported by this enum.", siftScienceValue));
	}
}