/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.LoginStatus;


/**
 * Use {@link Login} to record when a user attempts to log in.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class Login extends Event {
	
	public Login() {
		super("$login");
	}
	
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
	 * Use {@link LoginStatus} to represent the success or failure of the log in attempt.
	 */
	@JsonProperty("$login_status")
	private LoginStatus loginStatus;


	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public LoginStatus getLoginStatus() {
		return loginStatus;
	}


	public Login setUserId(String userId) {
		this.userId = userId;
		return this;
	}


	public Login setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}


	public Login setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
		return this;
	}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((loginStatus == null) ? 0 : loginStatus.hashCode());
        result = prime * result
                + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (!super.equals(obj)) {
            return false;
        }

        if (obj == null || !(obj instanceof Login)) {
            return false;
        }
        
        final Login l = (Login)obj;
        
        if (this.loginStatus == null) {
            if (l.getLoginStatus() != null) {
                return false;
            }
        } else if (!this.loginStatus.equals(l.getLoginStatus())) {
            return false;
        }
        
        if (this.sessionId == null) {
            if (l.getSessionId() != null) {
                return false;
            }
        } else if (!this.sessionId.equals(l.getSessionId())) {
            return false;
        }
        
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
