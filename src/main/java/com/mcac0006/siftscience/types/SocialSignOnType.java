package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.SocialSignOnTypeDeserializer;

/**
 * Provide the name of the social identity provider (e.g., {@link #TWITTER}, {@link #FACEBOOK}) 
 * in this field if the user uses them to log in to their account.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=SocialSignOnTypeDeserializer.class)
public enum SocialSignOnType {
	
	FACEBOOK("$facebook"),
	GOOGLE("$google"),
	YAHOO("$yahoo"),
	TWITTER("$twitter"),
	OTHER("$other");
	
	private String siftScienceValue;

	private SocialSignOnType(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static SocialSignOnType resolve(final String siftScienceValue) {
		
		for (SocialSignOnType ele : SocialSignOnType.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Social Sign-on Type [%s] is not supported by this enum.", siftScienceValue));
	}
	
}
