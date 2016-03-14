/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SendMessage extends Event {
	
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
	 * The ID of the user receiving the message. Required to compute network graphs. 
	 * 
	 * Note: User IDs are case sensitive. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$recipient_user_id")
	private String recipientUserId;
	
	/**
	 * The subject of the message.
	 */
	@JsonProperty("$subject")
	private String subject;
	
	/**
	 * The content of the message.
	 */
	@JsonProperty("$content")
	private String content;
	
	public SendMessage() {
		super("$send_message");
	}


	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public String getRecipientUserId() {
		return recipientUserId;
	}


	public String getSubject() {
		return subject;
	}


	public String getContent() {
		return content;
	}


	public SendMessage setUserId(String userId) {
		this.userId = userId;
		return this;
	}


	public SendMessage setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}


	public SendMessage setRecipientUserId(String recipientUserId) {
		this.recipientUserId = recipientUserId;
		return this;
	}


	public SendMessage setSubject(String subject) {
		this.subject = subject;
		return this;
	}


	public SendMessage setContent(String content) {
		this.content = content;
		return this;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result
                + ((recipientUserId == null) ? 0 : recipientUserId.hashCode());
        result = prime * result
                + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (!super.equals(obj)) {
            return false;
        }

        if (obj == null || !(obj instanceof SendMessage)) {
            return false;
        }
        
        final SendMessage rm = (SendMessage)obj;
        
        if (this.sessionId == null) {
            if (rm.getSessionId() != null) {
                return false;
            }
        } else if (!this.sessionId.equals(rm.getSessionId())) {
            return false;
        }
        
        if (this.userId == null) {
            if (rm.getUserId() != null) {
                return false;
            }
        } else if (!this.userId.equals(rm.getUserId())) {
            return false;
        }
        
        if (this.content == null) {
            if (rm.getContent() != null) {
                return false;
            }
        } else if (!this.content.equals(rm.getContent())) {
            return false;
        }
        
        if (this.recipientUserId == null) {
            if (rm.getRecipientUserId() != null) {
                return false;
            }
        } else if (!this.recipientUserId.equals(rm.getRecipientUserId())) {
            return false;
        }
        
        if (this.subject == null) {
            if (rm.getSubject() != null) {
                return false;
            }
        } else if (!this.subject.equals(rm.getSubject())) {
            return false;
        }
        
        return true;
    }

}
