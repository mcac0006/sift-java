/**
 * 
 */
package com.mcac0006.siftscience.label.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.Reason;

/**
 * Use the Labels to identify bad users for Sift Science's machine learning system. 
 * Labels allows you to label and categorize bad behavior, as well as mark false positives 
 * programmatically. Our system automatically analyzes these examples and learns to identify 
 * bad behavior more accurately.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class Label {
	
	/**
	 * Your Sift Science API key
	 */
	@JsonProperty(value="$api_key")
	private String apiKey;
	
	/**
	 * Indicate whether this user is fraudulent, or otherwise engaging in activities that are negative for your business. 
	 * 
	 * Set to {@link Boolean#TRUE} when you can confirm negative activity, e.g. a chargeback, or spam coming from the user.
	 * 
	 * Set to {@link Boolean#FALSE} when Sift gave this user a high score, but you can confirm that they are a legitimate user.
	 */
	@JsonProperty("$is_bad")
	private Boolean isBad;
	
	/**
	 * A list of one or more reasons indicating why this particular user has been labeled "bad".
	 */
	@JsonProperty("$reasons")
	private Reason[] reasons;
	
	/**
	 * Freeform text description of the user and/or incident triggering the label for your internal record-keeping.
	 */
	@JsonProperty("$description")
	private String description;

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiKey() {
		return apiKey;
	}

	public Boolean getIsBad() {
		return isBad;
	}

	public Reason[] getReasons() {
		return reasons;
	}

	public String getDescription() {
		return description;
	}

	public Label setIsBad(Boolean isBad) {
		this.isBad = isBad;
		return this;
	}

	public Label setReasons(Reason[] reasons) {
		this.reasons = reasons;
		return this;
	}

	public Label setDescription(String description) {
		this.description = description;
		return this;
	}
}
