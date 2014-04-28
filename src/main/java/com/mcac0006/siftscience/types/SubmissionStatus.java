package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.SubmissionStatusDeserializer;


/**
 * If reviews in your system must be approved, use {@link SubmissionStatus} to 
 * represent the status of the review.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=SubmissionStatusDeserializer.class)
public enum SubmissionStatus {

	SUCCESS("$success"),
	FAILURE("$failure"),
	PENDING("$pending");
	
	private String siftScienceValue;

	private SubmissionStatus(String siftScienceValue) {
		this.siftScienceValue = siftScienceValue;
	}
	
	@JsonValue
	public String getSiftScienceValue() {
		return siftScienceValue;
	}
	
	public static SubmissionStatus resolve(final String siftScienceValue) {
		
		for (SubmissionStatus ele : SubmissionStatus.values()) {
			if (ele.getSiftScienceValue().equals(siftScienceValue))
				return ele;
		}
		
		throw new IllegalArgumentException(String.format("Submission status [%s] is not supported by this enum.", siftScienceValue));
	}
}