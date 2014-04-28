/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public abstract class Event {

	/**
	 * The event type. Can be $create_order, $transaction, etc ...
	 */
	@JsonProperty(value="$type")
	private String eventType;
	
	/**
	 * Your Sift Science API key
	 */
	@JsonProperty(value="$api_key")
	private String apiKey;
	
	protected Event(final String eventType) {
		this.eventType = eventType;
	}
	
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public final String getEventType() {
		return eventType;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof Event)) {
			return false;
		}
		
		final Event e = (Event)obj;
		
		if (this.apiKey == null) {
			if (e.getApiKey() != null) {
				return false;
			}
		} else if (!this.apiKey.equals(e.getApiKey())) {
			return false;
		}
		
		if (this.eventType == null) {
			if (e.getEventType() != null) {
				return false;
			}
		} else if (!this.eventType.equals(e.getEventType())) {
			return false;
		}
		
		return true;
	}
}
