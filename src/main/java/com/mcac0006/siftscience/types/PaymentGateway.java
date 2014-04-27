package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mcac0006.siftscience.types.deserializer.PaymentGatewayDeserializer;

/**
 * The payment processor used for this payment.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@JsonDeserialize(using=PaymentGatewayDeserializer.class)
public enum PaymentGateway {
		STRIPE("$stripe"),
		BRAINTREE("$braintree"),
		PAYPAL("$paypal"),
		AMAZON_PAYMENTS("$amazon_payments"),
		AUTHORIZENET("$authorizenet"),
		BALANCED("$balanced"),
		EWAY("$eway"),
		ADYEN("$adyen");
		
		private String siftScienceValue;

		private PaymentGateway(String siftScienceValue) {
			this.siftScienceValue = siftScienceValue;
		}
		
		@JsonValue
		public String getSiftScienceValue() {
			return siftScienceValue;
		}
		
		public static PaymentGateway resolve(final String siftScienceValue) {
			
			for (PaymentGateway ele : PaymentGateway.values()) {
				if (ele.getSiftScienceValue().equals(siftScienceValue))
					return ele;
			}
			
			throw new IllegalArgumentException(String.format("Payment Gateway [%s] is not supported by this enum.", siftScienceValue));
		}
	}