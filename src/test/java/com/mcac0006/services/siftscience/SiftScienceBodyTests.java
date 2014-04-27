package com.mcac0006.services.siftscience;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Currency;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mcac0006.siftscience.event.domain.AddItemToCart;
import com.mcac0006.siftscience.event.domain.Transaction;
import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.Item;
import com.mcac0006.siftscience.types.PaymentGateway;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.PaymentType;
import com.mcac0006.siftscience.types.TransactionStatus;
import com.mcac0006.siftscience.types.TransactionType;

public class SiftScienceBodyTests {
	
	private ObjectMapper mapper;
	
	@Before
	public void setup() {		
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}
	
	/**
	 * 1. Instantiate an {@link Transaction} instance with the same values found in 
	 * 	  $transactions.json.
	 * 
	 * 2. Generate an {@link Transaction} instance from $transaction.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void test1() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link Transaction} instance with the same values found in $transactions.json.
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD).setPaymentGateway(PaymentGateway.BRAINTREE).setCardBIN("542486").setCardLast4("4444");
		
		final Address shippingAddress = new Address();
		shippingAddress.setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final Transaction transaction = new Transaction();
		transaction.setApiKey("INSERT_API_KEY_HERE");
		transaction.setUserId("billy_jones_301").setUserEmail("bill@gmail.com").setTransactionType(TransactionType.SALE).setTransactionStatus(TransactionStatus.SUCCESS).setAmount(5067900000l).setCurrencyCode("USD").setOrderId("ORDER-123124124").setTransactionId("719637215").setBillingAddress(billingAddress).setPaymentMethod(paymentMethod).setShippingAddress(shippingAddress).setSessionId("gigtleqddo84l8cm15qe4il3q3").setSellerUserId("slinkys_emporium");
		
		// 2. Generate an {@link Transaction} instance from $transaction.json.
		final Transaction $transaction = mapper.readValue(new FileInputStream("target/test-classes/$transaction.json"), Transaction.class);
		Assert.assertNotNull($transaction);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", transaction, $transaction);
	}
	
	/**
	 * 1. Instantiate an {@link AddItemToCart} instance with the same values found in 
	 * 	  $add_item_to_cart.json.
	 * 
	 * 2. Generate an {@link AddItemToCart} instance from $add_item_to_cart.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void test2() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link AddItemToCart} instance with the same values found in $add_item_to_cart.json.
		final Item item = new Item();
		final String[] tags = new String[]{"Awesome", "Wintertime specials"};
		item.setItemId("B004834GQO").setProductTitle("The Slanket Blanket-Texas Tea").setPrice(399900000l).setCurrency("USD").setUPC("67862114510011").setSKU("004834GQ").setBrand("Slanket").setManufacturer("Slanket").setCategory("Blankets & Throws").setTags(tags).setColor("Texas Tea").setQuantity(16);
		
		final AddItemToCart add_item_to_cart = new AddItemToCart();
		add_item_to_cart.setApiKey("INSERT_API_KEY_HERE");
		add_item_to_cart.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setItem(item);
		
		// 2. Generate an {@link AddItemToCart} instance from $add_item_to_cart.json.
		final AddItemToCart $add_item_to_cart = mapper.readValue(new FileInputStream("target/test-classes/$add_item_to_cart.json"), AddItemToCart.class);
		Assert.assertNotNull($add_item_to_cart);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", add_item_to_cart, $add_item_to_cart);
	}
}

