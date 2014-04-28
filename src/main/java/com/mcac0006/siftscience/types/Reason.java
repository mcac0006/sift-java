package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.ReasonDeserializer;

/**
 * The fraud reason help us specify why we consider this account to be fraudulent.
 * 
 * @author <a href="mailto:matthew.cachia@ixaris.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=ReasonDeserializer.class)
public enum Reason {
	
	/**
	 * Chargeback received for this user.
	 */
	CHARGEBACK ("$chargeback"),
	/**
	 * The user is spending spam.
	 */
	SPAM ("$spam"),
	/**
	 * The user engaged in coordinated buying and selling in an effort to funnel money.
	 */
	FUNNELING("$funneling"),
	/**
	 * The user is listing non-existent or fraudulent products or services for sale.
	 */
	FAKE("$fake"),
	/**
	 * The user engaged in various kinds of referral abuse
	 */
	REFERRAL("$referral"),
	/**
	 * This user account is a duplicate of another account.
	 */
	DUPLICATE_ACCOUNT("$duplicate_account");
	
	private String siftScienceValue;

	private Reason(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static Reason resolve(final String siftScienceValue) {
		
		for (Reason ele : Reason.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Reason [%s] is not supported by this enum.", siftScienceValue));
	}
};