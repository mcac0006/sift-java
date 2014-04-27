package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Provide the name of the social identity provider (e.g., {@link #TWITTER}, {@link #FACEBOOK}) 
 * in this field if the user uses them to log in to their account.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public enum SocialSignOnType {
	
	FACEBOOK("$facebook"),
	GOOGLE("$google"),
	YAHOO("$yahoo"),
	TWITTER("$twitter"),
	OTHER("$other");

	private String value;

	private SocialSignOnType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
