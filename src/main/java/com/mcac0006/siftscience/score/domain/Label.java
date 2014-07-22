/**
 * 
 */
package com.mcac0006.siftscience.score.domain;

import java.util.Arrays;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mcac0006.siftscience.types.Reason;
import com.mcac0006.siftscience.types.deserializer.DateDeserializer;
import com.mcac0006.siftscience.types.serializer.DateSerializer;

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
	 * Indicate whether this user is fraudulent, or otherwise engaging in activities that are negative for your business. 
	 * 
	 * Set to {@link Boolean#TRUE} when you can confirm negative activity, e.g. a chargeback, or spam coming from the user.
	 * 
	 * Set to {@link Boolean#FALSE} when Sift gave this user a high score, but you can confirm that they are a legitimate user.
	 */
	@JsonProperty("is_bad")
	private Boolean isBad;
	
	/**
	 * A list of one or more reasons indicating why this particular user has been labeled "bad".
	 */
	@JsonProperty("reasons")
	private Reason[] reasons;
	
	/**
	 * Freeform text description of the user and/or incident triggering the label for your internal record-keeping.
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * Include this field in your API requests when sending historical events. 
	 * The value is the date and time of the historical time that the action took place.
	 * 
	 * Refer to Sift Science's 
	 * <a href="https://siftscience.com/docs/tutorials/sending-historical-data/">Sending Historical Data</a> 
	 * for more information.
	 */
	@JsonProperty(value="time")
	@JsonSerialize(using=DateSerializer.class)
	@JsonDeserialize(using=DateDeserializer.class)
	private Date time;

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
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof Label)) {
			return false;
		}
		
		final Label l = (Label)obj;
		
		if (this.isBad == null) {
			if (l.getIsBad() != null) {
				return false;
			}
		} else if (!this.isBad.equals(l.getIsBad())) {
			return false;
		}
		
		if (this.description == null) {
			if (l.getDescription() != null) {
				return false;
			}
		} else if (!this.description.equals(l.getDescription())) {
			return false;
		}
		
		if (this.reasons == null) {
			if (l.getReasons() != null) {
				return false;
			}
		} else if (!Arrays.equals(this.reasons, l.getReasons())) {
			return false;
		}
		
		if (this.time == null) {
			if (l.getTime() != null) {
				return false;
			}
		} else if (!this.time.equals(l.getTime())) {
			return false;
		}
		
		return true;
	}
}
