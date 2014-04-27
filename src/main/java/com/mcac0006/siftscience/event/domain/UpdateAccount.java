/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.SocialSignOnType;

/**
 * 
 * Use {@link UpdateAccount} to record changes to the user's account information. For user accounts created
 * prior to integrating with Sift, there's no need to call {@link CreateAccount} before {@link UpdateAccount}. 
 * Simply call {@link UpdateAccount} and we'll infer that account was created before integration.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class UpdateAccount extends Event {
	
	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	/**
	 * If the user changed their password, set this field and mark as {@link Boolean#TRUE}.
	 */
	@JsonProperty("$changed_password")
	private Boolean changedPassword;
	

	@JsonProperty("$user_email")
	private String userEmail;
	
	/**
	 * Provide the full name of the user here. Concatenate first name and last name together if you collect 
	 * them separately in your system.
	 */
	@JsonProperty("$name")
	private String name;
	
	/**
	 * The primary phone number of the user associated with this account. Provide the phone number as a string, 
	 * starting with the country code. For example: "1-415-555-6041".
	 */
	@JsonProperty("$phone")
	private String phone;
	
	/**
	 * The payment information associated with this order. Represented as an array of nested {@link PaymentMethod} 
	 * objects containing payment type, payment gateway, credit card bin, etc.
	 */
	@JsonProperty("$payment_methods")
	private PaymentMethod[] paymentMethods;
	
	/**
	 * The billing address as entered by the user. Represented as a nested {@link Address} object.
	 */
	@JsonProperty("$billing_address")
	private Address billingAddress;
	
	/**
	 * Provide the name of the social identity provider (e.g., $twitter, $facebook) in this field if the user 
	 * uses them to log in to their account.
	 */
	@JsonProperty("$social_sign_on_type")
	private SocialSignOnType socialSignOnType;
	
	
	public UpdateAccount() {
		super("$update_account");
	}
	

	public String getUserId() {
		return userId;
	}



	public Boolean getChangedPassword() {
		return changedPassword;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public String getName() {
		return name;
	}



	public String getPhone() {
		return phone;
	}



	public PaymentMethod[] getPaymentMethods() {
		return paymentMethods;
	}



	public Address getBillingAddress() {
		return billingAddress;
	}



	public SocialSignOnType getSocialSignOnType() {
		return socialSignOnType;
	}



	public UpdateAccount setUserId(String userId) {
		this.userId = userId;
		return this;
	}



	public UpdateAccount setChangedPassword(Boolean changedPassword) {
		this.changedPassword = changedPassword;
		return this;
	}



	public UpdateAccount setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}



	public UpdateAccount setName(String name) {
		this.name = name;
		return this;
	}



	public UpdateAccount setPhone(String phone) {
		this.phone = phone;
		return this;
	}



	public UpdateAccount setPaymentMethods(PaymentMethod[] paymentMethods) {
		this.paymentMethods = paymentMethods;
		return this;
	}



	public UpdateAccount setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}



	public UpdateAccount setSocialSignOnType(SocialSignOnType socialSignOnType) {
		this.socialSignOnType = socialSignOnType;
		return this;
	}

}
