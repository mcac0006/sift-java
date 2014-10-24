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
import com.mcac0006.siftscience.event.domain.CreateOrder;
import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.Item;
import com.mcac0006.siftscience.types.PaymentGateway;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.PaymentType;

public class CreateOrderBodyTest {

	/**
	 * Asserts that the keys in the given jsonObject are there and no extra/missing keys are found.
	 * 
	 * @param jsonObject - the list of 
	 * @param expectedKeys
	 */
	private void assertEquals(final Set<String> jsonKeys, final List<String> expectedKeys) {
		
		Assert.assertEquals("Number of keys different from expected. Expected keys [%s].", expectedKeys.size(), jsonKeys.size());
		for (final String key: expectedKeys)
			Assert.assertTrue(String.format("Key [%s] expected.", key), jsonKeys.contains(key));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void createOrderTest() throws JsonGenerationException, JsonMappingException, IOException {
			
			final Address billingAddress = new Address();
			billingAddress.setName("Bill Jones").setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
			
			final PaymentMethod pm = new PaymentMethod();
			pm.setPaymentType(PaymentType.CREDIT_CARD).setCardBIN("542486").setCardLast4("4444").setPaymentGateway(PaymentGateway.BRAINTREE);
			
			final Address shippingAddress = new Address();
			shippingAddress.setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
			
			final Item item1 = new Item();
			final String[] item1tags = { "Popcorn", "Snacks", "On Sale" };
			item1.setItemId("12344321").setProductTitle("Microwavable Kettle Corn: Original Flavor").setPrice(49900000l).setUpc("097564307560").setSku("03586005").setBrand("Peters Kettle Corn").setManufacturer("Peters Kettle Corn").setCategory("Food and Grocery").setTags(item1tags).setQuantity(4);
			
			final Item item2 = new Item();
			final String[] item2tags = { "Awesome", "Wintertime specials" };
			item2.setItemId("B004834GQO").setProductTitle("The Slanket Blanket-Texas Tea").setPrice(399900000l).setUpc("67862114510011").setSku("004834GQ").setBrand("Slanket").setManufacturer("Slanket").setCategory("Blankets & Throws").setTags(item2tags).setColor("Texas Tea").setQuantity(16);
			
			final Item item3 = new Item();
			final String[] item3tags = { "reprint", "paperback", "Tony Hsieh" };
			item3.setItemId("10101042").setProductTitle("Delivering Happiness [eBook edition]").setPrice(69900000l).setIsbn("0446576220").setSku("10101042").setBrand("Writers of the Round Table Press").setManufacturer("eBook Digital Services, Inc.").setCategory("Business books").setTags(item3tags).setQuantity(1);
			
			final CreateOrder create_order = new CreateOrder();
			create_order.setApiKey("INSERT_API_KEY_HERE");
			create_order.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setOrderId("ORDER-28168441").setUserEmail("bill@gmail.com").setAmount(5067900000l).setCurrencyCode("USD").setBillingAddress(billingAddress).setPaymentMethods(new PaymentMethod[]{pm}).setShippingAddress(shippingAddress).setExpeditedShipping(true).setItems(new Item[]{item1,item2,item3}).setSellerUserId("slinkys_emporium");
			
			/*
			 * Assert.
			 */
			
			final String json = SiftScienceHelper.serialize(create_order); // the json object we will be asserting
			
			final Object read = JsonPath.read(json, "$");
			final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
			
			// assert first level
			final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id", "$order_id", "$user_email", "$amount", "$currency_code", "$billing_address", "$payment_methods", "$shipping_address", "$expedited_shipping", "$items", "$seller_user_id");
			assertEquals($.keySet(), $expectedKeys);
			
			// then assert the values
			Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
			Assert.assertEquals("$create_order", $.get("$type"));
			Assert.assertEquals("billy_jones_301", $.get("$user_id"));

			Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
			Assert.assertEquals("ORDER-28168441", $.get("$order_id"));
			Assert.assertEquals("bill@gmail.com", $.get("$user_email"));
			Assert.assertEquals(5067900000l, $.get("$amount"));
			Assert.assertEquals("USD", $.get("$currency_code"));
			Assert.assertEquals(true, $.get("$expedited_shipping"));
			Assert.assertEquals("slinkys_emporium", $.get("$seller_user_id"));
			
			// then assert the child keys and values
			final JSONArray pmjarray =(JSONArray)JsonPath.read(json, "$.$payment_methods");
			Assert.assertEquals(1, pmjarray.size());
			LinkedHashMap<String, Object> pmj = (LinkedHashMap<String, Object>)pmjarray.get(0);
			final List<String> pmexpectedKeys = Arrays.asList("$payment_type", "$payment_gateway", "$card_bin", "$card_last4");
			assertEquals(pmj.keySet(), pmexpectedKeys);
			Assert.assertEquals("$credit_card", pmj.get("$payment_type"));
			Assert.assertEquals("$braintree", pmj.get("$payment_gateway"));
			Assert.assertEquals("542486", pmj.get("$card_bin"));
			Assert.assertEquals("4444", pmj.get("$card_last4"));
			
			final LinkedHashMap<String, Object> ba =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$shipping_address");
			final List<String> baexpectedKeys = Arrays.asList("$address_1", "$address_2", "$city", "$region", "$country", "$zipcode");
			assertEquals(ba.keySet(), baexpectedKeys);
			Assert.assertEquals("2100 Main Street", ba.get("$address_1"));
			Assert.assertEquals("Apt 3B", ba.get("$address_2"));
			Assert.assertEquals("New London", ba.get("$city"));
			Assert.assertEquals("New Hampshire", ba.get("$region"));
			Assert.assertEquals("US", ba.get("$country"));
			Assert.assertEquals("03257", ba.get("$zipcode"));
			

			
			// then assert the child keys and values
			final JSONArray itemArray =(JSONArray)JsonPath.read(json, "$.$items");
			Assert.assertEquals(3, itemArray.size());
			
			final LinkedHashMap<String, Object> i1 =(LinkedHashMap<String, Object>)itemArray.get(0);
			final List<String> iexpectedKeys = Arrays.asList("$item_id", "$product_title", "$price", "$upc", "$sku", "$brand", "$manufacturer", "$category", "$tags", "$quantity");
			assertEquals(i1.keySet(), iexpectedKeys);
			Assert.assertEquals("12344321", i1.get("$item_id"));
			Assert.assertEquals("Microwavable Kettle Corn: Original Flavor", i1.get("$product_title"));
			Assert.assertEquals(49900000, i1.get("$price"));
			Assert.assertEquals("097564307560", i1.get("$upc"));
			Assert.assertEquals("03586005", i1.get("$sku"));
			Assert.assertEquals("Peters Kettle Corn", i1.get("$brand"));
			Assert.assertEquals("Peters Kettle Corn", i1.get("$manufacturer"));
			Assert.assertEquals("Food and Grocery", i1.get("$category"));
			Assert.assertEquals(Arrays.asList("Popcorn", "Snacks", "On Sale"), i1.get("$tags"));
			Assert.assertEquals(4, i1.get("$quantity"));
			
			final LinkedHashMap<String, Object> i2 =(LinkedHashMap<String, Object>)itemArray.get(1);
			final List<String> i2expectedKeys = Arrays.asList("$item_id", "$product_title", "$price", "$upc", "$sku", "$brand", "$manufacturer", "$category", "$tags", "$color", "$quantity");
			assertEquals(i2.keySet(), i2expectedKeys);
			Assert.assertEquals("B004834GQO", i2.get("$item_id"));
			Assert.assertEquals("The Slanket Blanket-Texas Tea", i2.get("$product_title"));
			Assert.assertEquals(399900000, i2.get("$price"));
			Assert.assertEquals("67862114510011", i2.get("$upc"));
			Assert.assertEquals("004834GQ", i2.get("$sku"));
			Assert.assertEquals("Slanket", i2.get("$brand"));
			Assert.assertEquals("Slanket", i2.get("$manufacturer"));
			Assert.assertEquals("Blankets & Throws", i2.get("$category"));
			Assert.assertEquals(Arrays.asList("Awesome", "Wintertime specials"), i2.get("$tags"));
			Assert.assertEquals("Texas Tea", i2.get("$color"));
			Assert.assertEquals(16, i2.get("$quantity"));
			
			final LinkedHashMap<String, Object> i3 =(LinkedHashMap<String, Object>)itemArray.get(2);
			final List<String> i3expectedKeys = Arrays.asList("$item_id", "$product_title", "$price", "$isbn", "$sku", "$brand", "$manufacturer", "$category", "$tags", "$quantity");
			assertEquals(i3.keySet(), i3expectedKeys);
			Assert.assertEquals("10101042", i3.get("$item_id"));
			Assert.assertEquals("Delivering Happiness [eBook edition]", i3.get("$product_title"));
			Assert.assertEquals(69900000, i3.get("$price"));
			Assert.assertEquals("0446576220", i3.get("$isbn"));
			Assert.assertEquals("10101042", i3.get("$sku"));
			Assert.assertEquals("Writers of the Round Table Press", i3.get("$brand"));
			Assert.assertEquals("eBook Digital Services, Inc.", i3.get("$manufacturer"));
			Assert.assertEquals("Business books", i3.get("$category"));
			Assert.assertEquals(Arrays.asList("reprint", "paperback", "Tony Hsieh"), i3.get("$tags"));
			Assert.assertEquals(1, i3.get("$quantity"));
	}

}

