/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
//@JsonSerialize(using=EventSerializer.class)
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
	
	/**
	 * Sift Science also supports additional information which might be analyzed and 
	 * further improve the accuracy for fraud.
	 * 
	 * <br /><br />
	 * 
	 * <strong>Note: The $ prefix is reserved for supported fields in the Events API. 
	 * Custom field names may only contain alphanumeric characters and _.</strong>
	 * 
	 * <br /><br />
	 * 
	 * It is important to name the field properly so that Sift Science can perform the relevant 
	 * analysis on them.
	 * 
	 * <ul>
	 * <li><strong>Email</strong> fields should always end with <code>_email</code>. For example: <code>referrer_email</code>, <code>seller_email</code>.</li>
	 * <li><strong>Phone</strong> fields should always end with <code>_phone</code>. For example: <code>secondary_phone</code>, <code>work_phone</code>.</li>
	 * <li><strong>Latitude</strong> fields should always end with <code>_lat</code>. For example: <code>dropoff_location_lat</code>. Must be a floating point number.</li>
	 * <li><strong>Longitude</strong> fields should always end with <code>_lng</code>. For example: <code>pickup_location_lng</code>. Must be a floating point number.</li>
	 * <li><strong>User ID</strong> fields should always end with <code>_user_id</code>. For example: <code>friend_user_id</code>, <code>buyer_user_id</code>.</li>
	 * <li><strong>Status</strong> fields should always end with <code>_status</code>. For example: <code>request_status</code>, <code>rma_status</code>.</li>
	 * </ul>
	 * 
	 */
	private Map<String, Object> customFields = new HashMap<String, Object>();
	
	
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

	@JsonAnyGetter
	public final Map<String, Object> getCustomFields() {
		return customFields;
	}
	
	@JsonAnySetter
	public final void addCustomField(final String key, final Object value) {
		customFields.put(key, value);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!super.equals(obj)) {
			return false;
		}

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
		
		if (this.customFields == null) {
			if (e.getCustomFields() != null) {
				return false;
			}
		} else if (!this.customFields.equals(e.getCustomFields())) {
			return false;
		}
		
		return true;
	}
}
