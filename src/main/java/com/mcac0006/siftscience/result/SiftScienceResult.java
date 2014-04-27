/**
 * 
 */
package com.mcac0006.siftscience.result;

/**
 * This is the response we receive from Sift Science.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SiftScienceResult {
	
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
}
