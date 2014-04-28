/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.Item;

/**
 * Use {@link RemoveItemFromCart} to record when a user removes an item from their shopping cart or list.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class RemoveItemFromCart extends Event {
	
	/**
	 * The user's current session ID, used to tie a user's action before and after log in or account creation.
	 */
	@JsonProperty("$session_id")
	private String sessionId;
	
	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	
	/**
	 * The product item removed from cart. Represented as a nested {@link Item} object.
	 */
	@JsonProperty("$item")
	private Item item;
	
	public RemoveItemFromCart() {
		super("$remove_item_from_cart");
	}


	public String getSessionId() {
		return sessionId;
	}


	public String getUserId() {
		return userId;
	}


	public Item getItem() {
		return item;
	}


	public RemoveItemFromCart setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}


	public RemoveItemFromCart setUserId(String userId) {
		this.userId = userId;
		return this;
	}


	public RemoveItemFromCart setItem(Item item) {
		this.item = item;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!super.equals(obj)) {
			return false;
		}

		if (obj == null || !(obj instanceof RemoveItemFromCart)) {
			return false;
		}
		
		final RemoveItemFromCart rifc = (RemoveItemFromCart)obj;
		
		if (this.item == null) {
			if (rifc.getItem() != null) {
				return false;
			}
		} else if (!this.item.equals(rifc.getItem())) {
			return false;
		}
		
		if (this.sessionId == null) {
			if (rifc.getSessionId() != null) {
				return false;
			}
		} else if (!this.sessionId.equals(rifc.getSessionId())) {
			return false;
		}
		
		if (this.userId == null) {
			if (rifc.getUserId() != null) {
				return false;
			}
		} else if (!this.userId.equals(rifc.getUserId())) {
			return false;
		}
		
		return true;
	}
}
