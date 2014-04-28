/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.SubmissionStatus;


/**
 * Use {@link SubmitReview} to record a user-submitted review of a product or 
 * other users. e.g., a seller on your site.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SubmitReview extends Event {
		
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

	@Override
	public boolean equals(Object obj) {
		
		if (!super.equals(obj)) {
			return false;
		}

		if (obj == null || !(obj instanceof SubmitReview)) {
			return false;
		}
		
		final SubmitReview sr = (SubmitReview)obj;
		
		if (this.sessionId == null) {
			if (sr.getSessionId() != null) {
				return false;
			}
		} else if (!this.sessionId.equals(sr.getSessionId())) {
			return false;
		}
		
		if (this.userId == null) {
			if (sr.getUserId() != null) {
				return false;
			}
		} else if (!this.userId.equals(sr.getUserId())) {
			return false;
		}
		
		if (this.content == null) {
			if (sr.getContent() != null) {
				return false;
			}
		} else if (!this.content.equals(sr.getContent())) {
			return false;
		}
		
		if (this.itemId == null) {
			if (sr.getItemId() != null) {
				return false;
			}
		} else if (!this.itemId.equals(sr.getItemId())) {
			return false;
		}
		
		if (this.reviewedUserId == null) {
			if (sr.getReviewedUserId() != null) {
				return false;
			}
		} else if (!this.reviewedUserId.equals(sr.getReviewedUserId())) {
			return false;
		}
		
		if (this.reviewTitle == null) {
			if (sr.getReviewTitle() != null) {
				return false;
			}
		} else if (!this.reviewTitle.equals(sr.getReviewTitle())) {
			return false;
		}
		
		if (this.submissionStatus == null) {
			if (sr.getSubmissionStatus() != null) {
				return false;
			}
		} else if (!this.submissionStatus.equals(sr.getSubmissionStatus())) {
			return false;
		}
		
		return true;
	}
}
