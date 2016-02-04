package com.mcac0006.services.siftscience;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import com.mcac0006.siftscience.SiftScienceHelper;
import com.mcac0006.siftscience.event.domain.Transaction;
import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.PaymentGateway;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.PaymentType;
import com.mcac0006.siftscience.types.TransactionStatus;
import com.mcac0006.siftscience.types.TransactionType;

import static com.mcac0006.services.siftscience.AssertJsonKeys.assertEquals;

public class TransactionBodyTest {

	/**
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void transactionTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		/*
		 * Instantiate an {@link Transaction} instance with the same values found in $transactions.json.
		 */
		
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD).setPaymentGateway(PaymentGateway.BRAINTREE).setCardBIN("542486").setCardLast4("4444");
		
		final Address shippingAddress = new Address();
		shippingAddress.setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final Transaction transaction = new Transaction();
		transaction.setApiKey("INSERT_API_KEY_HERE");
		transaction.setUserId("billy_jones_301").setUserEmail("bill@gmail.com").setTransactionType(TransactionType.SALE).setTransactionStatus(TransactionStatus.SUCCESS).setAmount(5067900000l).setCurrencyCode("USD").setOrderId("ORDER-123124124").setTransactionId("719637215").setBillingAddress(billingAddress).setPaymentMethod(paymentMethod).setShippingAddress(shippingAddress).setSessionId("gigtleqddo84l8cm15qe4il3q3").setSellerUserId("slinkys_emporium");
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(transaction); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$user_email", "$transaction_type", "$transaction_status", "$amount", "$currency_code", "$order_id", "$transaction_id", "$billing_address", "$payment_method", "$shipping_address", "$session_id", "$seller_user_id");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$transaction", $.get("$type"));
		
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("bill@gmail.com", $.get("$user_email"));
		Assert.assertEquals("$sale", $.get("$transaction_type"));
		Assert.assertEquals("$success", $.get("$transaction_status"));
		Assert.assertEquals(5067900000l, $.get("$amount"));
		Assert.assertEquals("USD", $.get("$currency_code"));
		Assert.assertEquals("ORDER-123124124", $.get("$order_id"));
		Assert.assertEquals("719637215", $.get("$transaction_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
		Assert.assertEquals("slinkys_emporium", $.get("$seller_user_id"));
		
		// then assert the child keys and values
		final LinkedHashMap<String, Object> ba =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$billing_address");
		final List<String> baexpectedKeys = Arrays.asList("$name", "$phone", "$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(ba.keySet(), baexpectedKeys);
		Assert.assertEquals("Bill Jones", ba.get("$name"));
		Assert.assertEquals("1-415-555-6041", ba.get("$phone"));
		Assert.assertEquals("2100 Main Street", ba.get("$address_1"));
		Assert.assertEquals("Apt 3B", ba.get("$address_2"));
		Assert.assertEquals("New London", ba.get("$city"));
		Assert.assertEquals("New Hampshire", ba.get("$region"));
		Assert.assertEquals("US", ba.get("$country"));
		Assert.assertEquals("03257", ba.get("$zipcode"));
		
		final LinkedHashMap<String, Object> pm =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$payment_method");
		final List<String> pmexpectedKeys = Arrays.asList("$payment_type", "$payment_gateway", "$card_bin", "$card_last4");
		assertEquals(pm.keySet(), pmexpectedKeys);
		Assert.assertEquals("$credit_card", pm.get("$payment_type"));
		Assert.assertEquals("$braintree", pm.get("$payment_gateway"));
		Assert.assertEquals("542486", pm.get("$card_bin"));
		Assert.assertEquals("4444", pm.get("$card_last4"));
		
		final LinkedHashMap<String, Object> sa =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$shipping_address");
		final List<String> saexpectedKeys = Arrays.asList("$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(sa.keySet(), saexpectedKeys);
		Assert.assertEquals("2100 Main Street", sa.get("$address_1"));
		Assert.assertEquals("Apt 3B", sa.get("$address_2"));
		Assert.assertEquals("New London", sa.get("$city"));
		Assert.assertEquals("New Hampshire", sa.get("$region"));
		Assert.assertEquals("US", sa.get("$country"));
		Assert.assertEquals("03257", sa.get("$zipcode"));
	}
	
	/**
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void historicalTransactionTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		/*
		 * Instantiate an {@link Transaction} instance with the same values found in $transactions.json.
		 */
		
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD).setPaymentGateway(PaymentGateway.BRAINTREE).setCardBIN("542486").setCardLast4("4444");
		
		final Address shippingAddress = new Address();
		shippingAddress.setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final Transaction transaction = new Transaction();
		transaction.setApiKey("INSERT_API_KEY_HERE");
		final Calendar cal = Calendar.getInstance(); cal.setTime(new Date(112, 10, 8, 0, 0, 0));
		transaction.setTime(cal);
		transaction.setUserId("billy_jones_301").setUserEmail("bill@gmail.com").setTransactionType(TransactionType.SALE).setTransactionStatus(TransactionStatus.SUCCESS).setAmount(5067900000l).setCurrencyCode("USD").setOrderId("ORDER-123124124").setTransactionId("719637215").setBillingAddress(billingAddress).setPaymentMethod(paymentMethod).setShippingAddress(shippingAddress).setSessionId("gigtleqddo84l8cm15qe4il3q3").setSellerUserId("slinkys_emporium");
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(transaction); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$time", "$user_id", "$user_email", "$transaction_type", "$transaction_status", "$amount", "$currency_code", "$order_id", "$transaction_id", "$billing_address", "$payment_method", "$shipping_address", "$session_id", "$seller_user_id");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals((int) (cal.getTimeInMillis() / 1000), $.get("$time"));
		Assert.assertEquals("$transaction", $.get("$type"));
		
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("bill@gmail.com", $.get("$user_email"));
		Assert.assertEquals("$sale", $.get("$transaction_type"));
		Assert.assertEquals("$success", $.get("$transaction_status"));
		Assert.assertEquals(5067900000l, $.get("$amount"));
		Assert.assertEquals("USD", $.get("$currency_code"));
		Assert.assertEquals("ORDER-123124124", $.get("$order_id"));
		Assert.assertEquals("719637215", $.get("$transaction_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
		Assert.assertEquals("slinkys_emporium", $.get("$seller_user_id"));
		
		// then assert the child keys and values
		final LinkedHashMap<String, Object> ba =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$billing_address");
		final List<String> baexpectedKeys = Arrays.asList("$name", "$phone", "$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(ba.keySet(), baexpectedKeys);
		Assert.assertEquals("Bill Jones", ba.get("$name"));
		Assert.assertEquals("1-415-555-6041", ba.get("$phone"));
		Assert.assertEquals("2100 Main Street", ba.get("$address_1"));
		Assert.assertEquals("Apt 3B", ba.get("$address_2"));
		Assert.assertEquals("New London", ba.get("$city"));
		Assert.assertEquals("New Hampshire", ba.get("$region"));
		Assert.assertEquals("US", ba.get("$country"));
		Assert.assertEquals("03257", ba.get("$zipcode"));
		
		final LinkedHashMap<String, Object> pm =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$payment_method");
		final List<String> pmexpectedKeys = Arrays.asList("$payment_type", "$payment_gateway", "$card_bin", "$card_last4");
		assertEquals(pm.keySet(), pmexpectedKeys);
		Assert.assertEquals("$credit_card", pm.get("$payment_type"));
		Assert.assertEquals("$braintree", pm.get("$payment_gateway"));
		Assert.assertEquals("542486", pm.get("$card_bin"));
		Assert.assertEquals("4444", pm.get("$card_last4"));
		
		final LinkedHashMap<String, Object> sa =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$shipping_address");
		final List<String> saexpectedKeys = Arrays.asList("$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(sa.keySet(), saexpectedKeys);
		Assert.assertEquals("2100 Main Street", sa.get("$address_1"));
		Assert.assertEquals("Apt 3B", sa.get("$address_2"));
		Assert.assertEquals("New London", sa.get("$city"));
		Assert.assertEquals("New Hampshire", sa.get("$region"));
		Assert.assertEquals("US", sa.get("$country"));
		Assert.assertEquals("03257", sa.get("$zipcode"));
	}



	/**
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void transactionWithCustomFieldsTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		/*
		 * Instantiate an {@link Transaction} instance with the same values found in $transactions.json.
		 */
		
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD).setPaymentGateway(PaymentGateway.BRAINTREE).setCardBIN("542486").setCardLast4("4444");
		
		final Address shippingAddress = new Address();
		shippingAddress.setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final Transaction transaction = new Transaction();
		transaction.setApiKey("INSERT_API_KEY_HERE");
		transaction.setUserId("billy_jones_301").setUserEmail("bill@gmail.com").setTransactionType(TransactionType.SALE).setTransactionStatus(TransactionStatus.SUCCESS).setAmount(5067900000l).setCurrencyCode("USD").setOrderId("ORDER-123124124").setTransactionId("719637215").setBillingAddress(billingAddress).setPaymentMethod(paymentMethod).setShippingAddress(shippingAddress).setSessionId("gigtleqddo84l8cm15qe4il3q3").setSellerUserId("slinkys_emporium");

		transaction.addCustomField("coupon_code", "dollarMadness");
		transaction.addCustomField("shipping_method", "FedEx Ground Courier");
		transaction.addCustomField("is_first_time_buyer", false);
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(transaction); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$user_email", "$transaction_type", "$transaction_status", "$amount", "$currency_code", "$order_id", "$transaction_id", "$billing_address", "$payment_method", "$shipping_address", "$session_id", "$seller_user_id", "coupon_code", "shipping_method", "is_first_time_buyer");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$transaction", $.get("$type"));
		
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("bill@gmail.com", $.get("$user_email"));
		Assert.assertEquals("$sale", $.get("$transaction_type"));
		Assert.assertEquals("$success", $.get("$transaction_status"));
		Assert.assertEquals(5067900000l, $.get("$amount"));
		Assert.assertEquals("USD", $.get("$currency_code"));
		Assert.assertEquals("ORDER-123124124", $.get("$order_id"));
		Assert.assertEquals("719637215", $.get("$transaction_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
		Assert.assertEquals("slinkys_emporium", $.get("$seller_user_id"));
		
		// then assert the child keys and values
		final LinkedHashMap<String, Object> ba =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$billing_address");
		final List<String> baexpectedKeys = Arrays.asList("$name", "$phone", "$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(ba.keySet(), baexpectedKeys);
		Assert.assertEquals("Bill Jones", ba.get("$name"));
		Assert.assertEquals("1-415-555-6041", ba.get("$phone"));
		Assert.assertEquals("2100 Main Street", ba.get("$address_1"));
		Assert.assertEquals("Apt 3B", ba.get("$address_2"));
		Assert.assertEquals("New London", ba.get("$city"));
		Assert.assertEquals("New Hampshire", ba.get("$region"));
		Assert.assertEquals("US", ba.get("$country"));
		Assert.assertEquals("03257", ba.get("$zipcode"));
		
		final LinkedHashMap<String, Object> pm =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$payment_method");
		final List<String> pmexpectedKeys = Arrays.asList("$payment_type", "$payment_gateway", "$card_bin", "$card_last4");
		assertEquals(pm.keySet(), pmexpectedKeys);
		Assert.assertEquals("$credit_card", pm.get("$payment_type"));
		Assert.assertEquals("$braintree", pm.get("$payment_gateway"));
		Assert.assertEquals("542486", pm.get("$card_bin"));
		Assert.assertEquals("4444", pm.get("$card_last4"));
		
		final LinkedHashMap<String, Object> sa =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$shipping_address");
		final List<String> saexpectedKeys = Arrays.asList("$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(sa.keySet(), saexpectedKeys);
		Assert.assertEquals("2100 Main Street", sa.get("$address_1"));
		Assert.assertEquals("Apt 3B", sa.get("$address_2"));
		Assert.assertEquals("New London", sa.get("$city"));
		Assert.assertEquals("New Hampshire", sa.get("$region"));
		Assert.assertEquals("US", sa.get("$country"));
		Assert.assertEquals("03257", sa.get("$zipcode"));
		
		Assert.assertEquals("dollarMadness", $.get("coupon_code"));
		Assert.assertEquals("FedEx Ground Courier", $.get("shipping_method"));
		Assert.assertEquals(false, $.get("is_first_time_buyer"));
	}
}

