/**
 * 
 */
package com.mcac0006.siftscience.score.domain;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * This class represents the score which is received from Sift Science about 
 * a particular user.
 * 
 * This information is mostly used passively (such as manual investigation by 
 * a fraud agent) or actively (such as your product consults with the result before 
 * if serves the user's transaction).
 * 
 * Refer to <a href="https://siftscience.com/docs/getting-scores">Getting Sift Scores</a> for more information.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiftScienceScore {
	
	/**
	 * The user ID in question.
	 */
	@JsonProperty(value="user_id")
	private String userId;
	
	/**
	 * The score which Sift Science recommends for this particular {@link #userId}.
	 * 
	 * The score is from 0.00 to 1.00, 0.00 being entirely legitimate, 1.00 being entirely a fraud.
	 */
	private Float score;
	
	/**
	 * Sift Science will justify the score given for thus {@link #userId} into an array of {@link Reason} 
	 * instances.
	 * 
	 * Refer to {@link Reason} for more information.
	 */
	private Reason[] reasons;
	
	/**
	 * If this user has been labeled by you or your system, this will contain the last label given by Sift Science.
	 */
	@JsonProperty(value="latest_label")
	private Label latestLabel;
	
	/**
	 * Return a status for the response. Refer to the 
	 * <a href="https://siftscience.com/docs/references/events-api#error-codes">Error Codes</a> section for more info.
	 */
	private Short status;
	
	@JsonProperty(value="error_message")
	private String errorMessage;

	public final String getUserId() {
		return userId;
	}

	public final Float getScore() {
		return score;
	}

	public final Reason[] getReasons() {
		return reasons;
	}

	public final Label getLatestLabel() {
		return latestLabel;
	}

	public final Short getStatus() {
		return status;
	}

	public final String getErrorMessage() {
		return errorMessage;
	}

	public final void setUserId(String userId) {
		this.userId = userId;
	}

	public final void setScore(Float score) {
		this.score = score;
	}

	public final void setReasons(Reason[] reasons) {
		this.reasons = reasons;
	}

	public final void setLatestLabel(Label latestLabel) {
		this.latestLabel = latestLabel;
	}

	public final void setStatus(Short status) {
		this.status = status;
	}

	public final void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((errorMessage == null) ? 0 : errorMessage.hashCode());
        result = prime * result
                + ((latestLabel == null) ? 0 : latestLabel.hashCode());
        result = prime * result + Arrays.hashCode(reasons);
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof SiftScienceScore)) {
            return false;
        }
        
        final SiftScienceScore e = (SiftScienceScore)obj;
        
        if (this.errorMessage == null) {
            if (e.getErrorMessage() != null) {
                return false;
            }
        } else if (!this.errorMessage.equals(e.getErrorMessage())) {
            return false;
        }
        
        if (this.latestLabel == null) {
            if (e.getLatestLabel() != null) {
                return false;
            }
        } else if (!this.latestLabel.equals(e.getLatestLabel())) {
            return false;
        }

        if (this.reasons == null) {
            if (e.getReasons() != null) {
                return false;
            }
        } else if (!Arrays.equals(this.reasons, e.getReasons())) {
            return false;
        }
        
        if (this.score == null) {
            if (e.getScore() != null) {
                return false;
            }
        } else if (!this.score.equals(e.getScore())) {
            return false;
        }
        
        if (this.status == null) {
            if (e.getStatus() != null) {
                return false;
            }
        } else if (!this.status.equals(e.getStatus())) {
            return false;
        }
        
        if (this.userId == null) {
            if (e.getUserId() != null) {
                return false;
            }
        } else if (!this.userId.equals(e.getUserId())) {
            return false;
        }
        
        return true;
    }
	
}
