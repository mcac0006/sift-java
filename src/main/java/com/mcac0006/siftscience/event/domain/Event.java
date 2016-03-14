/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mcac0006.siftscience.types.deserializer.DateDeserializer;
import com.mcac0006.siftscience.types.serializer.DateSerializer;

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
	 * Include this field in your API requests when sending historical events. 
	 * The value is the date and time of the historical time that the action took place.
	 * 
	 * Refer to Sift Science's 
	 * <a href="https://siftscience.com/docs/tutorials/sending-historical-data/">Sending Historical Data</a> 
	 * for more information.
	 */
	@JsonProperty(value="$time")
	@JsonSerialize(using=DateSerializer.class, include=Inclusion.NON_EMPTY)
	@JsonDeserialize(using=DateDeserializer.class)
	private Calendar time;
	
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
		super();
		this.eventType = eventType;
	}
	
	protected Event(String eventType, String apiKey) {
		this(eventType);
		this.apiKey = apiKey;
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

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
        result = prime * result
                + ((customFields == null) ? 0 : customFields.hashCode());
        result = prime * result
                + ((eventType == null) ? 0 : eventType.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        return result;
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
        
        if (this.customFields == null) {
            if (e.getCustomFields() != null) {
                return false;
            }
        } else if (!this.customFields.equals(e.getCustomFields())) {
            return false;
        }
        
        if (this.time == null) {
            if (e.getTime() != null) {
                return false;
            }
        } else if (!this.time.equals(e.getTime())) {
            return false;
        }
        
        return true;
    }
	
}
