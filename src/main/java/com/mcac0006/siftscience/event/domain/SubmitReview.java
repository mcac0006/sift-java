/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Use {@link SubmitReview} to record a user-submitted review of a product or 
 * other users. e.g., a seller on your site.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SubmitReview extends Event {
	
	/**
	 * If reviews in your system must be approved, use {@link SubmissionStatus} to 
	 * represent the status of the review.
	 * 
	 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
	 *
	 */
	public enum SubmissionStatus {

		SUCCESS("$success"),
		FAILURE("$failure"),
		PENDING("$pending");
		
		private String value;
		
		private SubmissionStatus(final String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
		
	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	/**
	 * The user's current session ID, used to tie a user's action before and after log in or account creation.
	 */
	@JsonProperty("$session_id")
	private String sessionId;
	
	/**
	 * The text content of the review submitted.
	 */
	@JsonProperty("$content")
	private String content;
	
	/**
	 * The title of review submitted.
	 */
	@JsonProperty("$review_title")
	private String reviewTitle;
	
	/**
	 * The ID of the product or service being reviewed.
	 */
	@JsonProperty("$item_id")
	private String itemId;
	
	/**
	 * The user ID of the user being reviewed. Required to compute network graphs. Note: User IDs are case 
	 * sensitive. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$reviewed_user_id")
	private String reviewedUserId;
	
	/**
	 * If reviews in your system must be approved, use {@link SubmissionStatus} to represent the status of the review.
	 */
	@JsonProperty("$submission_status")
	private SubmissionStatus submissionStatus;
	
	public SubmitReview() {
		super("$submit_review");
	}

	public String getUserId() {
		return userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getContent() {
		return content;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public String getItemId() {
		return itemId;
	}

	public String getReviewedUserId() {
		return reviewedUserId;
	}

	public SubmissionStatus getSubmissionStatus() {
		return submissionStatus;
	}

	public SubmitReview setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public SubmitReview setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}

	public SubmitReview setContent(String content) {
		this.content = content;
		return this;
	}

	public SubmitReview setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
		return this;
	}

	public SubmitReview setItemId(String itemId) {
		this.itemId = itemId;
		return this;
	}

	public SubmitReview setReviewedUserId(String reviewedUserId) {
		this.reviewedUserId = reviewedUserId;
		return this;
	}

	public SubmitReview setSubmissionStatus(SubmissionStatus submissionStatus) {
		this.submissionStatus = submissionStatus;
		return this;
	}

}
