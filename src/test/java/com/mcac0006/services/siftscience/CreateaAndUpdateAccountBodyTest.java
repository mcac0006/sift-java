package com.mcac0006.services.siftscience;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import net.minidev.json.JSONArray;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import com.mcac0006.siftscience.SiftScienceHelper;
import com.mcac0006.siftscience.event.domain.CreateAccount;
import com.mcac0006.siftscience.event.domain.UpdateAccount;
import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.PaymentType;
import com.mcac0006.siftscience.types.SocialSignOnType;

import static com.mcac0006.services.siftscience.AssertJsonKeys.assertEquals;

public class CreateaAndUpdateAccountBodyTest {

	@Test
	@SuppressWarnings("unchecked")
	public void createAccountTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final PaymentMethod pm = new PaymentMethod();
		pm.setPaymentType(PaymentType.CREDIT_CARD).setCardBIN("542486").setCardLast4("4444");
		
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final CreateAccount create_account = new CreateAccount();
		create_account.setApiKey("INSERT_API_KEY_HERE");
		create_account.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setUserEmail("bill@gmail.com").setName("Bill Jones").setPhone("1-415-555-6040").setReferrerUserId("janejane101").setSocialSignOnType(SocialSignOnType.TWITTER).setPaymentMethods(new PaymentMethod[]{ pm }).setBillingAddress(billingAddress);
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(create_account); // the json object we will be asserting
		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id", "$user_email", "$name", "$phone", "$referrer_user_id", "$payment_methods", "$billing_address", "$social_sign_on_type");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$create_account", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));

		Assert.assertEquals("bill@gmail.com", $.get("$user_email"));
		Assert.assertEquals("Bill Jones", $.get("$name"));
		Assert.assertEquals("1-415-555-6040", $.get("$phone"));
		Assert.assertEquals("janejane101", $.get("$referrer_user_id"));
		Assert.assertEquals("$twitter", $.get("$social_sign_on_type"));
		
		// then assert the child keys and values
		final JSONArray pmjarray =(JSONArray)JsonPath.read(json, "$.$payment_methods");
		Assert.assertEquals(1, pmjarray.size());
		LinkedHashMap<String, Object> pmj = (LinkedHashMap<String, Object>)pmjarray.get(0);
		final List<String> pmexpectedKeys = Arrays.asList("$payment_type", "$card_bin", "$card_last4");
		assertEquals(pmj.keySet(), pmexpectedKeys);
		Assert.assertEquals("$credit_card", pmj.get("$payment_type"));
		Assert.assertEquals("542486", pmj.get("$card_bin"));
		Assert.assertEquals("4444", pmj.get("$card_last4"));
		
		final LinkedHashMap<String, Object> ba =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$billing_address");
		final List<String> baexpectedKeys = Arrays.asList("$name", "$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(ba.keySet(), baexpectedKeys);
		Assert.assertEquals("Bill Jones", ba.get("$name"));
		Assert.assertEquals("2100 Main Street", ba.get("$address_1"));
		Assert.assertEquals("Apt 3B", ba.get("$address_2"));
		Assert.assertEquals("New London", ba.get("$city"));
		Assert.assertEquals("New Hampshire", ba.get("$region"));
		Assert.assertEquals("US", ba.get("$country"));
		Assert.assertEquals("03257", ba.get("$zipcode"));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void updateAccountTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD).setCardBIN("542486").setCardLast4("4444");

		final Address billingAddress = new Address();
		billingAddress.setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final UpdateAccount update_account = new UpdateAccount();
		update_account.setApiKey("INSERT_API_KEY_HERE");
		update_account.setUserId("billy_jones_301").setChangedPassword(true).setUserEmail("bill@gmail.com").setName("Bill Jones").setPhone("1-415-555-6040").setReferrerUserId("janejane102").setPaymentMethods(new PaymentMethod[]{paymentMethod}).setBillingAddress(billingAddress).setSocialSignOnType(SocialSignOnType.TWITTER);
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(update_account); // the json object we will be asserting
		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$changed_password", "$user_email", "$name", "$phone", "$referrer_user_id", "$payment_methods", "$billing_address", "$social_sign_on_type");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$update_account", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));

		Assert.assertEquals("bill@gmail.com", $.get("$user_email"));
		Assert.assertEquals("Bill Jones", $.get("$name"));
		Assert.assertEquals("1-415-555-6040", $.get("$phone"));
		Assert.assertEquals("janejane102", $.get("$referrer_user_id"));
		Assert.assertEquals("$twitter", $.get("$social_sign_on_type"));
		
		// then assert the child keys and values
		final JSONArray pmjarray =(JSONArray)JsonPath.read(json, "$.$payment_methods");
		Assert.assertEquals(1, pmjarray.size());
		LinkedHashMap<String, Object> pmj = (LinkedHashMap<String, Object>)pmjarray.get(0);
		final List<String> pmexpectedKeys = Arrays.asList("$payment_type", "$card_bin", "$card_last4");
		assertEquals(pmj.keySet(), pmexpectedKeys);
		Assert.assertEquals("$credit_card", pmj.get("$payment_type"));
		Assert.assertEquals("542486", pmj.get("$card_bin"));
		Assert.assertEquals("4444", pmj.get("$card_last4"));
		
		final LinkedHashMap<String, Object> ba =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$billing_address");
		final List<String> baexpectedKeys = Arrays.asList("$phone", "$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
		assertEquals(ba.keySet(), baexpectedKeys);
		Assert.assertEquals("1-415-555-6041", ba.get("$phone"));
		Assert.assertEquals("2100 Main Street", ba.get("$address_1"));
		Assert.assertEquals("Apt 3B", ba.get("$address_2"));
		Assert.assertEquals("New London", ba.get("$city"));
		Assert.assertEquals("New Hampshire", ba.get("$region"));
		Assert.assertEquals("US", ba.get("$country"));
		Assert.assertEquals("03257", ba.get("$zipcode"));
	}
}

