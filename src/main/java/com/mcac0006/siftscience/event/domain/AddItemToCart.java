/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mcac0006.siftscience.types.Item;

/**
 * Use {@link AddItemToCart} to record when a user adds an item to their shopping cart or list.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonSerialize(include=Inclusion.NON_NULL)
public class AddItemToCart extends Event {
		
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
	 * The product {@link Item} added to cart.
	 */
	@JsonProperty("$item")
	private Item item;
	
	
	public AddItemToCart() {
		super("$add_item_to_cart");
	}


	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public Item getItem() {
		return item;
	}


	public AddItemToCart setUserId(String userId) {
		this.userId = userId;
		return this;
	}


	public AddItemToCart setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}


	public AddItemToCart setItem(Item item) {
		this.item = item;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!super.equals(obj)) {
			return false;
		}

		if (obj == null || !(obj instanceof AddItemToCart)) {
			return false;
		}
		
		final AddItemToCart aitc = (AddItemToCart)obj;
		
		if (this.item == null) {
			if (aitc.getItem() != null) {
				return false;
			}
		} else if (!this.item.equals(aitc.getItem())) {
			return false;
		}
		
		if (this.sessionId == null) {
			if (aitc.getSessionId() != null) {
				return false;
			}
		} else if (!this.sessionId.equals(aitc.getSessionId())) {
			return false;
		}
		
		if (this.userId == null) {
			if (aitc.getUserId() != null) {
				return false;
			}
		} else if (!this.userId.equals(aitc.getUserId())) {
			return false;
		}
		
		return true;
	}
}
