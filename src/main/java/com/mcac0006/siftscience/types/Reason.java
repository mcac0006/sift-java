package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * The fraud reason help us specify why we consider this account to be fraudulent.
 * 
 * @author <a href="mailto:matthew.cachia@ixaris.com">Matthew Cachia</a>
 *
 */
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
	
	private String value;
	
	Reason(final String value) {
		this.value=value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
};