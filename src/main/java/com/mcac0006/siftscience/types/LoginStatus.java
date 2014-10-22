package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.LoginStatusDeserializer;


/**
 * Use {@link LoginStatus} to represent the success or failure of the log in attempt. 
 * 
 * The field value can be {@link LoginStatus#SUCCESS} (default value) or {@link LoginStatus#FAILURE}.
 * 
 * @author <a href="mailto:matthew.cachia@ixaris.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=LoginStatusDeserializer.class)
public enum LoginStatus {
	
	SUCCESS ("$success"),
	FAILURE("$failure");
	
	private String siftScienceValue;

	private LoginStatus(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static LoginStatus resolve(final String siftScienceValue) {
		
		for (LoginStatus ele : LoginStatus.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Login Status [%s] is not supported by this enum.", siftScienceValue));
	}
};