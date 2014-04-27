/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.TransactionStatus;
import com.mcac0006.siftscience.types.TransactionType;

/**
 * Use {@link Transaction} to record attempts to exchange money, credit or other tokens of value. 
 * {@link Transaction} is most commonly used to record the results of interactions with a payment gateway, e.g., 
 * recording that a credit card authorization attempt failed. 
 * 
 * See: <a href="https://siftscience.com/docs/tutorials/integration">Initial Integration Tutorial</a>.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class Transaction extends Event {
	
	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	@JsonProperty("$user_email")
	private String userEmail;
	
	/**
	 * The type of transaction being recorded. There are five types.
	 * Refer to {@link TransactionType} for more info.
	 */
	@JsonProperty("$transaction_type")
	private TransactionType transactionType;
	
	/**
	 * Use {@link TransactionStatus} to indicate the status of the transaction. 
	 * The value can be {@link TransactionStatus#SUCCESS} (default value), 
	 * {@link TransactionStatus#FAILURE} or {@link TransactionStatus#PENDING}. 
	 * 
	 * For instance, If the transaction was rejected by the payment gateway, set 
	 * the value to {@link TransactionStatus#FAILURE}.
	 */
	@JsonProperty("$transaction_status")
	private TransactionStatus transactionStatus;
	
	/**
	 * Total transaction amount in micros in the base unit of the <code>$currency_code</code>. 1 cent = 10,000 
	 * micros. $1.23 USD = 123 cents = 1,230,000 micros.
	 */
	@JsonProperty("$amount")
	private Long amount;
	
	/**
	 * <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO-4217</a> currency code for the amount. If your site 
	 * uses alternative currencies, specifiy them here.
	 */
	@JsonProperty("$currency_code")
	private String currencyCode;
	
	/**
	 * The ID for this order in your system. Used for cross referencing an order in your internal systems.
	 */
	@JsonProperty("$order_id")
	private String orderId;
	
	/**
	 * The ID for identifying this transaction. Important for tracking transactions, and linking different parts 
	 * of the same transaction together, e.g., linking a refund to its original transaction.
	 */
	@JsonProperty("$transaction_id")
	private String transactionId;
	
	/**
	 * The billing address as entered by the user. Represented as a nested {@link Address} object.
	 */
	@JsonProperty("$billing_address")
	private Address billingAddress;
	
	/**
	 * The payment information associated with this transaction. 
	 * Represented as a single payment_method object containing payment method, payment gateway, 
	 * credit card bin, etc.
	 */
	@JsonProperty("$payment_method")
	private PaymentMethod paymentMethod;
	
	/**
	 * The shipping address as entered by the user. Represented as a nested {@link Address} object.
	 */
	@JsonProperty("$shipping_address")
	private Address shippingAddress;
	
	/**
	 * The user's current session ID, used to tie a user's action before and after log in or account creation.
	 */
	@JsonProperty("$session_id")
	private String sessionId;
	
	/**
	 * For marketplace businesses, this is the seller's user ID, typically a database primary key. Note: User IDs are case sensitive. 
	 * You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$seller_user_id")
	private String sellerUserId;
	
	public Transaction() {
		super("$transaction");
	}

	public String getUserId() {
		return userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public Long getAmount() {
		return amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getSellerUserId() {
		return sellerUserId;
	}

	public Transaction setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Transaction setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}

	public Transaction setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
		return this;
	}

	public Transaction setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
		return this;
	}

	public Transaction setAmount(Long amount) {
		this.amount = amount;
		return this;
	}

	public Transaction setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public Transaction setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public Transaction setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	public Transaction setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}

	public Transaction setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	public Transaction setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}

	public Transaction setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}

	public Transaction setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof Transaction)) {
			return false;
		}
		
		final Transaction tx = (Transaction)obj;
		
		if (this.amount == null) {
			if (tx.getAmount() != null) {
				return false;
			}
		} else if (!this.amount.equals(tx.getAmount())) {
			return false;
		}
		
		if (this.billingAddress == null) {
			if (tx.getBillingAddress() != null) {
				return false;
			}
		} else if (!this.billingAddress.equals(tx.getBillingAddress())) {
			return false;
		}
		
		if (this.currencyCode == null) {
			if (tx.getCurrencyCode() != null) {
				return false;
			}
		} else if (!this.currencyCode.equals(tx.getCurrencyCode())) {
			return false;
		}
		
		if (this.orderId == null) {
			if (tx.getOrderId() != null) {
				return false;
			}
		} else if (!this.orderId.equals(tx.getOrderId())) {
			return false;
		}
		
		if (this.paymentMethod == null) {
			if (tx.getPaymentMethod() != null) {
				return false;
			}
		} else if (!this.paymentMethod.equals(tx.getPaymentMethod())) {
			return false;
		}
		
		if (this.sellerUserId == null) {
			if (tx.getSellerUserId() != null) {
				return false;
			}
		} else if (!this.sellerUserId.equals(tx.getSellerUserId())) {
			return false;
		}
		
		if (this.sessionId == null) {
			if (tx.getSessionId() != null) {
				return false;
			}
		} else if (!this.sessionId.equals(tx.getSessionId())) {
			return false;
		}
		
		if (this.shippingAddress == null) {
			if (tx.getShippingAddress() != null) {
				return false;
			}
		} else if (!this.shippingAddress.equals(tx.getShippingAddress())) {
			return false;
		}
		
		if (this.transactionId == null) {
			if (tx.getTransactionId() != null) {
				return false;
			}
		} else if (!this.transactionId.equals(tx.getTransactionId())) {
			return false;
		}
		
		if (this.transactionStatus == null) {
			if (tx.getTransactionStatus() != null) {
				return false;
			}
		} else if (!this.transactionStatus.equals(tx.getTransactionStatus())) {
			return false;
		}
		
		if (this.transactionType == null) {
			if (tx.getTransactionType() != null) {
				return false;
			}
		} else if (!this.transactionType.equals(tx.getTransactionType())) {
			return false;
		}
		
		if (this.userEmail == null) {
			if (tx.getUserEmail() != null) {
				return false;
			}
		} else if (!this.userEmail.equals(tx.getUserEmail())) {
			return false;
		}
		
		if (this.userId == null) {
			if (tx.getUserId() != null) {
				return false;
			}
		} else if (!this.userId.equals(tx.getUserId())) {
			return false;
		}
		
		return true;
	}

}
