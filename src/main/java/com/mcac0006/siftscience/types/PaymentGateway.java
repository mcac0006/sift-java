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
		ADYEN("$adyen"),
		AFFIRM("$affirm"),
		ALIPAY("$alipay"),
		ALTAPAY("$altapay"),
		ASTROPAY("$astropay"),
		BEANSTREAM("$beanstream"),
		BLOCKCHAIN("$blockchain"),
		BLUEPAY("$bluepay"),
		CCAVENUE("$ccavenue"),
		CHASE_PAYMENTECH("$chase_paymentech"),
		CHECKOUTCOM("$checkoutcom"),
		CIELO("$cielo"),
		COFINOGA("$cofinoga"),
		COINBASE("$coinbase"),
		COLLECTOR("$collector"),
		COMPROPAGO("$compropago"),
		CONEKTA("$conekta"),
		CUENTADIGITAL("$cuentadigital"),
		CULQI("$culqi"),
		CYBERSOURCE("$cybersource"),
		DATACASH("$datacash"),
		DEBITWAY("$debitway"),
		DIBS("$dibs"),
		DIGITAL_RIVER("$digital_river"),
		DRAGONPAY("$dragonpay"),
		ELAVON("$elavon"),
		EPAYEU("$epayeu"),
		EPROCESSING_NETWORK("$eprocessing_network"),
		FIRST_ATLANTIC_COMMERCE("$first_atlantic_commerce"),
		FIRST_DATA("$first_data"),
		G2APAY("$g2apay"),
		GIROPAY("$giropay"),
		GLOBAL_PAYMENTS("$global_payments"),
		GLOBALCOLLECT("$globalcollect"),
		HDFC_FSSNET("$hdfc_fssnet"),
		HIPAY("$hipay"),
		INGENICO("$ingenico"),
		INTERNETSECURE("$internetsecure"),
		INTUIT_QUICKBOOKS_PAYMENTS("$intuit_quickbooks_payments"),
		IUGU("$iugu"),
		JABONG("$jabong"),
		MASTERCARD_PAYMENT_GATEWAY("$mastercard_payment_gateway"),
		MERCADOPAGO("$mercadopago"),
		MERCHANT_ESOLUTIONS("$merchant_esolutions"),
		MIRJEH("$mirjeh"),
		MOIP("$moip"),
		MOLLIE("$mollie"),
		MONERIS_SOLUTIONS("$moneris_solutions"),
		NMI("$nmi"),
		OGONE("$ogone"),
		OMISE("$omise"),
		OPENPAYMX("$openpaymx"),
		OPTIMAL_PAYMENTS("$optimal_payments"),
		PAYFAST("$payfast"),
		PAYGATE("$paygate"),
		PAYMENT_EXPRESS("$payment_express"),
		PAYMILL("$paymill"),
		PAYONE("$payone"),
		PAYSERA("$paysera"),
		PAYSTATION("$paystation"),
		PAYTRACE("$paytrace"),
		PAYTRAIL("$paytrail"),
		PAYTURE("$payture"),
		PAYU("$payu"),
		PAYULATAM("$payulatam"),
		PAYZA("$payza"),
		PINPAYMENTS("$pinpayments"),
		PIVOTAL_PAYMENTS("$pivotal_payments"),
		PRINCETON_PAYMENT_SOLUTIONS("$princeton_payment_solutions"),
		PSIGATE("$psigate"),
		QIWI("$qiwi"),
		QUICKPAY("$quickpay"),
		RABERIL("$raberil"),
		RBKMONEY("$rbkmoney"),
		REDE("$rede"),
		REDPAGOS("$redpagos"),
		REDSYS("$redsys"),
		REWARDSPAY("$rewardspay"),
		ROCKETGATE("$rocketgate"),
		SAGEPAY("$sagepay"),
		SERMEPA("$sermepa"),
		SIMPLIFY_COMMERCE("$simplify_commerce"),
		SKRILL("$skrill"),
		SMARY2PAY("$smart2pay"),
		SMARTCOIN("$smartcoin"),
		SOFORT("$sofort"),
		SPS_DECIDIR("$sps_decidir"),
		STONE("$stone"),
		SYNAPSEPAY("$synapsepay"),
		TELERECARGAS("$telerecargas"),
		TOWAH("$towah"),
		TNSPAY("$tnspay"),
		TRANSFIRST("$transfirst"),
		TRUSTLY("$trustly"),
		TWOCHECKOUT("$twocheckout"),
		UNIONPAY("$unionpay"),
		USA_EPAY("$usa_epay"),
		VANYIV("$vantiv"),
		VERITRANS("$veritrans"),
		VENMO("$venmo"),
		VERSAPAY("$versapay"),
		VESTA("$vesta"),
		VINDICIA("$vindicia"),
		VIRTUAL_CARD_SERVICES("$virtual_card_services"),
		VME("$vme"),
		WEBMONEY("$webmoney"),
		WEBPAY_ONECLICK("$webpay_oneclick"),
		WEPAY("$wepay"),
		WIRECARD("$wirecard"),
		WORLDPAY("$worldpay"),
		WORLDSPAN("$worldspan"),
		XIPAY("$xipay"),
		YANDEX_MONEY("$yandex_money");
		
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