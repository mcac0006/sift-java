package com.mcac0006.services.siftscience;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import com.mcac0006.siftscience.SiftScienceHelper;
import com.mcac0006.siftscience.event.domain.AddItemToCart;
import com.mcac0006.siftscience.event.domain.RemoveItemFromCart;
import com.mcac0006.siftscience.types.Item;

import static com.mcac0006.services.siftscience.AssertJsonKeys.assertEquals;

public class AddandRemoveItemBodyTest {

	@Test
	@SuppressWarnings("unchecked")
	public void addItemToCartTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link AddItemToCart} instance with the same values found in $add_item_to_cart.json.
		final Item item = new Item();
		final String[] tags = new String[]{"Awesome", "Wintertime specials"};
		item.setItemId("B004834GQO").setProductTitle("The Slanket Blanket-Texas Tea").setPrice(399900000l).setCurrency("USD").setUpc("67862114510011").setSku("004834GQ").setBrand("Slanket").setManufacturer("Slanket").setCategory("Blankets & Throws").setTags(tags).setColor("Texas Tea").setQuantity(16);
		
		final AddItemToCart add_item_to_cart = new AddItemToCart();
		add_item_to_cart.setApiKey("INSERT_API_KEY_HERE");
		add_item_to_cart.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setItem(item);
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(add_item_to_cart); // the json object we will be asserting
		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id", "$item");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$add_item_to_cart", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
		
		// then assert the child keys and values
		final LinkedHashMap<String, Object> i =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$item");
		final List<String> iexpectedKeys = Arrays.asList("$item_id", "$product_title", "$price", "$currency_code", "$upc", "$sku", "$brand", "$manufacturer", "$category", "$tags", "$color", "$quantity");
		assertEquals(i.keySet(), iexpectedKeys);
		Assert.assertEquals("B004834GQO", i.get("$item_id"));
		Assert.assertEquals("The Slanket Blanket-Texas Tea", i.get("$product_title"));
		Assert.assertEquals(399900000, i.get("$price"));
		Assert.assertEquals("USD", i.get("$currency_code"));
		Assert.assertEquals("67862114510011", i.get("$upc"));
		Assert.assertEquals("004834GQ", i.get("$sku"));
		Assert.assertEquals("Slanket", i.get("$brand"));
		Assert.assertEquals("Slanket", i.get("$manufacturer"));
		Assert.assertEquals("Blankets & Throws", i.get("$category"));
		Assert.assertEquals(Arrays.asList("Awesome", "Wintertime specials"), i.get("$tags"));
		Assert.assertEquals("Texas Tea", i.get("$color"));
		Assert.assertEquals(16, i.get("$quantity"));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void removeItemFromCartTest() throws JsonGenerationException, JsonMappingException, IOException {

		final RemoveItemFromCart remove_item_from_cart = new RemoveItemFromCart();
		
		final Item item = new Item();
		final String[] tags = new String[]{"Awesome", "Wintertime specials"};
		item.setItemId("B004834GQO").setProductTitle("The Slanket Blanket-Texas Tea").setPrice(399900000l).setCurrency("USD").setUpc("67862114510011").setSku("004834GQ").setBrand("Slanket").setManufacturer("Slanket").setCategory("Blankets & Throws").setTags(tags).setColor("Texas Tea").setQuantity(2);
		
		remove_item_from_cart.setApiKey("INSERT_API_KEY_HERE");
		remove_item_from_cart.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setItem(item);
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(remove_item_from_cart); // the json object we will be asserting
		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id", "$item");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$remove_item_from_cart", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
		
		// then assert the child keys and values
		final LinkedHashMap<String, Object> i =(LinkedHashMap<String, Object>)JsonPath.read(json, "$.$item");
		final List<String> iexpectedKeys = Arrays.asList("$item_id", "$product_title", "$price", "$currency_code", "$quantity", "$upc", "$sku", "$brand", "$manufacturer", "$category", "$tags", "$color");
		assertEquals(i.keySet(), iexpectedKeys);
		Assert.assertEquals("B004834GQO", i.get("$item_id"));
		Assert.assertEquals("The Slanket Blanket-Texas Tea", i.get("$product_title"));
		Assert.assertEquals(399900000, i.get("$price"));
		Assert.assertEquals("USD", i.get("$currency_code"));
		Assert.assertEquals("67862114510011", i.get("$upc"));
		Assert.assertEquals("004834GQ", i.get("$sku"));
		Assert.assertEquals("Slanket", i.get("$brand"));
		Assert.assertEquals("Slanket", i.get("$manufacturer"));
		Assert.assertEquals("Blankets & Throws", i.get("$category"));
		Assert.assertEquals(Arrays.asList("Awesome", "Wintertime specials"), i.get("$tags"));
		Assert.assertEquals("Texas Tea", i.get("$color"));
		Assert.assertEquals(2, i.get("$quantity"));
	}
}

