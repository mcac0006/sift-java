/**
 * 
 */
package com.mcac0006.siftscience.result.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.score.domain.SiftScienceScore;

/**
 * This is the response we receive from Sift Science.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SiftScienceResponse {
	
	/**
	 * This contains the error code of the request.
	 * 
	 *  Zero (0) means all OK, any non-zero status is an error. Refer to 
	 *  {@link #error_message} for an informal description of the error.
	 */
	private Integer status;
	
	/**
	 * This goes hand-in-hand with {@link #status}. It gives an informal 
	 * description justifying the error code found in {@link #status}.
	 */
	private String error_message;
	
	/**
	 * When Sift Science received the original request (in seconds).
	 */
	private Integer time;
	
	/**
	 * The request content received sent to Sift Science. This is particularly 
	 * useful in case you need to investigate the content itself.
	 */
	private String request;
	
	/**
	 * If a score was requested, contains the nested score response.
	 */
	@JsonProperty(value="score_response")
	private SiftScienceScore scoreResponse;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public SiftScienceScore getScoreResponse() {
		return scoreResponse;
	}

	public void setScoreResponse(SiftScienceScore scoreResponse) {
		this.scoreResponse = scoreResponse;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result
                + ((error_message == null) ? 0 : error_message.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((request == null) ? 0 : request.hashCode());
        result = prime * result
                + ((scoreResponse == null) ? 0 : scoreResponse.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof SiftScienceResponse)) {
            return false;
        }

        final SiftScienceResponse r = (SiftScienceResponse)obj;

        if (this.status == null) {
            if (r.getStatus() != null) {
                return false;
            }
        } else if (!this.status.equals(r.getStatus())) {
            return false;
        }

        if (this.error_message == null) {
            if (r.getError_message() != null) {
                return false;
            }
        } else if (!this.error_message.equals(r.getError_message())) {
            return false;
        }

        if (this.time == null) {
            if (r.getTime() != null) {
                return false;
            }
        } else if (!this.time.equals(r.getTime())) {
            return false;
        }

        if (this.request == null) {
            if (r.getRequest() != null) {
                return false;
            }
        } else if (!this.request.equals(r.getRequest())) {
            return false;
        }

        if (this.scoreResponse == null) {
            if (r.getScoreResponse() != null) {
                return false;
            }
        } else if (!this.scoreResponse.equals(r.getScoreResponse())) {
            return false;
        }

        return true;
    }

}
