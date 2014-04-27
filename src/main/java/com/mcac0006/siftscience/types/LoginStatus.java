package com.mcac0006.siftscience.types;


/**
 * Use {@link LoginStatus} to represent the success or failure of the log in attempt. 
 * 
 * The field value can be {@value #SUCCESS} (default value) or {@value #FAILURE}.
 * 
 * @author <a href="mailto:matthew.cachia@ixaris.com">Matthew Cachia</a>
 *
 */
public enum LoginStatus {
	
	SUCCESS ("$success"),
	FAILURE("$failure");
	
	private String value;
	
	LoginStatus(final String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
};