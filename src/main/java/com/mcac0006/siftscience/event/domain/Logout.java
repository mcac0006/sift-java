/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Use {@link Logout} to record when a user logs out.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class Logout extends Event {	

	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	public Logout() {
		super("$logout");
	}


	public String getUserId() {
		return userId;
	}


	public Logout setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!super.equals(obj)) {
			return false;
		}

		if (obj == null || !(obj instanceof Logout)) {
			return false;
		}
		
		final Logout l = (Logout)obj;
		
		if (this.userId == null) {
			if (l.getUserId() != null) {
				return false;
			}
		} else if (!this.userId.equals(l.getUserId())) {
			return false;
		}
		
		return true;
	}

}
