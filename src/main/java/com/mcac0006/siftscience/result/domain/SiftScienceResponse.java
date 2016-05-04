/**
 * 
 */
package com.mcac0006.siftscience.result.domain;

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
	 *  {@link #errorMessage} for an informal description of the error.
	 */
	private Integer status;
	
	/**
	 * This goes hand-in-hand with {@link #status}. It gives an informal 
	 * description justifying the error code found in {@link #status}.
	 */
	private String errorMessage;
	
	/**
	 * When Sift Science received the original request (in seconds).
	 */
	private Integer time;
	
	/**
	 * The request content received sent to Sift Science. This is particularly 
	 * useful in case you need to investigate the content itself.
	 */
	private String request;
	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
}
