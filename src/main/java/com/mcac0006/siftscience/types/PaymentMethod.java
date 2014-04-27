/**
 * 
 */
package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.event.domain.CreateOrder;
import com.mcac0006.siftscience.event.domain.Transaction;


/**
 * This class represents information about the payment methods provided by the user.
 * Generally used with the {@link CreateOrder} or {@link Transaction} events.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class PaymentMethod {

	@JsonProperty("$payment_type")
	private PaymentType paymentType;
	
	/**
	 * The payment processor used for this payment.
	 */
	@JsonProperty("$payment_gateway")
	private PaymentGateway paymentGateway;
	
	/**
	 * The first six digits of the credit card number. These numbers contain information about the card issuer, the geography and other card details.
	 */
	@JsonProperty("$card_bin")
	private String cardBIN;
	
	/**
	 * The last four digits of the credit card number.
	 */
	@JsonProperty("$card_last4")
	private String cardLast4;
	
	/**
	 * Response code from the AVS address verification system. Used in payments involving credit cards.
	 */
	@JsonProperty("$avs_result_code")
	private String AVSResultCode;
	
	/**
	 * Response code from the credit card company indicating if the CVV number entered matches the number on record. Used in payments involving credit cards.
	 */
	@JsonProperty("$cvv_result_code")
	private String CVVResultCode;
	
	/**
	 * Use this to indicate the payment method has been verified.
	 */
	@JsonProperty("$verification_status")
	private VerificationStatus verificationStatus;

	/**
	 * The ABA routing number used for electronic fund transfers
	 */
	@JsonProperty("$routing_number")
	private String routingNumber;	
	
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public PaymentGateway getPaymentGateway() {
		return paymentGateway;
	}

	public String getCardBIN() {
		return cardBIN;
	}

	public String getCardLast4() {
		return cardLast4;
	}

	public String getAVSResultCode() {
		return AVSResultCode;
	}

	public String getCVVResultCode() {
		return CVVResultCode;
	}

	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public PaymentMethod setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public PaymentMethod setPaymentGateway(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
		return this;
	}

	public PaymentMethod setCardBIN(String cardBIN) {
		this.cardBIN = cardBIN;
		return this;
	}

	public PaymentMethod setCardLast4(String cardLast4) {
		this.cardLast4 = cardLast4;
		return this;
	}

	public PaymentMethod setAVSResultCode(String aVSResultCode) {
		AVSResultCode = aVSResultCode;
		return this;
	}

	public PaymentMethod setCVVResultCode(String cVVResultCode) {
		CVVResultCode = cVVResultCode;
		return this;
	}

	public PaymentMethod setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
		return this;
	}

	public PaymentMethod setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof PaymentMethod)) {
			return false;
		}
		
		final PaymentMethod pm = (PaymentMethod)obj;
		
		if (this.AVSResultCode == null) {
			if (pm.getAVSResultCode() != null) {
				return false;
			}
		} else if (!this.AVSResultCode.equals(pm.getAVSResultCode())) {
			return false;
		}
		
		if (this.cardBIN == null) {
			if (pm.getCardBIN() != null) {
				return false;
			}
		} else if (!this.cardBIN.equals(pm.getCardBIN())) {
			return false;
		}
		
		if (this.cardLast4 == null) {
			if (pm.getCardLast4() != null) {
				return false;
			}
		} else if (!this.cardLast4.equals(pm.getCardLast4())) {
			return false;
		}
		
		if (this.CVVResultCode == null) {
			if (pm.getCVVResultCode() != null) {
				return false;
			}
		} else if (!this.CVVResultCode.equals(pm.getCVVResultCode())) {
			return false;
		}
		
		if (this.paymentGateway == null) {
			if (pm.getPaymentGateway() != null) {
				return false;
			}
		} else if (!this.paymentGateway.equals(pm.getPaymentGateway())) {
			return false;
		}
		
		if (this.paymentType == null) {
			if (pm.getPaymentType() != null) {
				return false;
			}
		} else if (!this.paymentType.equals(pm.getPaymentType())) {
			return false;
		}
		
		if (this.routingNumber == null) {
			if (pm.getRoutingNumber() != null) {
				return false;
			}
		} else if (!this.routingNumber.equals(pm.getRoutingNumber())) {
			return false;
		}
		
		if (this.verificationStatus == null) {
			if (pm.getVerificationStatus() != null) {
				return false;
			}
		} else if (!this.verificationStatus.equals(pm.getVerificationStatus())) {
			return false;
		}
		
		return true;
	}
}
