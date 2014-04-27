package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.PaymentTypeDeserializer;


/**
 * This specifies the method of payment (e.g. {@link #CREDIT_CARD} is one of the most 
 * common methods of payments in eCommerce).
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=PaymentTypeDeserializer.class)
public enum PaymentType {
	
	CREDIT_CARD("$credit_card"),
	ELECTRONIC_FUND_TRANSFER("$electronic_fund_transfer"),
	CRYPTO_CURRENCY("$crypto_currency"),
	CASH("$cash"),
	STORE_CREDIT("$store_credit"),
	GIFT_CARD("$gift_card"),
	POINTS("$points"),
	FINANCING("$financing"),
	THIRD_PARTY_SUCCESSOR("$third_party_successor");
	
	private String siftScienceValue;

	private PaymentType(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static PaymentType resolve(final String siftScienceValue) {
		
		for (PaymentType ele : PaymentType.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Payment Type [%s] is not supported by this enum.", siftScienceValue));
	}
	
}