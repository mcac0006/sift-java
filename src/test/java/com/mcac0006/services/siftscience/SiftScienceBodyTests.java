package com.mcac0006.services.siftscience;

import java.io.FileInputStream;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mcac0006.siftscience.event.domain.AddItemToCart;
import com.mcac0006.siftscience.event.domain.CreateAccount;
import com.mcac0006.siftscience.event.domain.CreateOrder;
import com.mcac0006.siftscience.event.domain.LinkSessionToUser;
import com.mcac0006.siftscience.event.domain.Login;
import com.mcac0006.siftscience.event.domain.Logout;
import com.mcac0006.siftscience.event.domain.RemoveItemFromCart;
import com.mcac0006.siftscience.event.domain.SendMessage;
import com.mcac0006.siftscience.event.domain.SubmitReview;
import com.mcac0006.siftscience.event.domain.Transaction;
import com.mcac0006.siftscience.event.domain.UpdateAccount;
import com.mcac0006.siftscience.label.domain.Label;
import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.Item;
import com.mcac0006.siftscience.types.LoginStatus;
import com.mcac0006.siftscience.types.PaymentGateway;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.PaymentType;
import com.mcac0006.siftscience.types.Reason;
import com.mcac0006.siftscience.types.SocialSignOnType;
import com.mcac0006.siftscience.types.SubmissionStatus;
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
	public void transactionTest() throws JsonGenerationException, JsonMappingException, IOException {
		
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
	 * 1. Instantiate an {@link Transaction} instance with the same values found in 
	 * 	  $transaction_with_custom_fields.json.
	 * 
	 * 2. Generate an {@link Transaction} instance from $transaction_with_custom_fields.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void eventTestWithCustomFields() throws JsonGenerationException, JsonMappingException, IOException {
		
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
		
		transaction.addCustomField("coupon_code", "dollarMadness");
		transaction.addCustomField("shipping_method", "FedEx Ground Courier");
		transaction.addCustomField("is_first_time_buyer", false);
		
		// 2. Generate an {@link Transaction} instance from $transaction.json.
		final Transaction $transaction = mapper.readValue(new FileInputStream("target/test-classes/$transaction_with_custom_fields.json"), Transaction.class);
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
	public void addItemToCartTest() throws JsonGenerationException, JsonMappingException, IOException {
		
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
	
	/**
	 * 1. Instantiate an {@link CreateAccount} instance with the same values found in 
	 * 	  $create_account.json.
	 * 
	 * 2. Generate an {@link CreateAccount} instance from $create_account.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createAccountTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link CreateAccount} instance with the same values found in $create_account.json.
		final PaymentMethod pm = new PaymentMethod();
		pm.setPaymentType(PaymentType.CREDIT_CARD).setCardBIN("542486").setCardLast4("4444");
		
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final CreateAccount create_account = new CreateAccount();
		create_account.setApiKey("INSERT_API_KEY_HERE");
		create_account.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setUserEmail("bill@gmail.com").setName("Bill Jones").setPhone("1-415-555-6040").setReferrerUserId("janejane101").setSocialSignOnType(SocialSignOnType.TWITTER).setPaymentMethods(new PaymentMethod[]{ pm }).setBillingAddress(billingAddress);
		
		// 2. Generate an {@link CreateAccount} instance from $create_account.json.
		final CreateAccount $create_account = mapper.readValue(new FileInputStream("target/test-classes/$create_account.json"), CreateAccount.class);
		Assert.assertNotNull($create_account);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", create_account, $create_account);
	}
	
	/**
	 * 1. Instantiate an {@link CreateOrder} instance with the same values found in 
	 * 	  $create_order.json.
	 * 
	 * 2. Generate an {@link CreateOrder} instance from $create_order.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createOrderTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link CreateOrder} instance with the same values found in $create_order.json.
		final Address billingAddress = new Address();
		billingAddress.setName("Bill Jones").setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final PaymentMethod pm = new PaymentMethod();
		pm.setPaymentType(PaymentType.CREDIT_CARD).setCardBIN("542486").setCardLast4("4444").setPaymentGateway(PaymentGateway.BRAINTREE);
		
		final Address shippingAddress = new Address();
		shippingAddress.setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final Item item1 = new Item();
		final String[] item1tags = { "Popcorn", "Snacks", "On Sale" };
		item1.setItemId("12344321").setProductTitle("Microwavable Kettle Corn: Original Flavor").setPrice(49900000l).setUPC("097564307560").setSKU("03586005").setBrand("Peters Kettle Corn").setManufacturer("Peters Kettle Corn").setCategory("Food and Grocery").setTags(item1tags).setQuantity(4);
		
		final Item item2 = new Item();
		final String[] item2tags = { "Awesome", "Wintertime specials" };
		item2.setItemId("B004834GQO").setProductTitle("The Slanket Blanket-Texas Tea").setPrice(399900000l).setUPC("67862114510011").setSKU("004834GQ").setBrand("Slanket").setManufacturer("Slanket").setCategory("Blankets & Throws").setTags(item2tags).setColor("Texas Tea").setQuantity(16);
		
		final Item item3 = new Item();
		final String[] item3tags = { "reprint", "paperback", "Tony Hsieh" };
		item3.setItemId("10101042").setProductTitle("Delivering Happiness [eBook edition]").setPrice(69900000l).setISBN("0446576220").setSKU("10101042").setBrand("Writers of the Round Table Press").setManufacturer("eBook Digital Services, Inc.").setCategory("Business books").setTags(item3tags).setQuantity(1);
		
		final CreateOrder create_order = new CreateOrder();
		create_order.setApiKey("INSERT_API_KEY_HERE");
		create_order.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setOrderId("ORDER-28168441").setUserEmail("bill@gmail.com").setAmount(5067900000l).setCurrencyCode("USD").setBillingAddress(billingAddress).setPaymentMethods(new PaymentMethod[]{pm}).setShippingAddress(shippingAddress).setExpeditedShipping(true).setItems(new Item[]{item1,item2,item3}).setSellerUserId("slinkys_emporium");
		
		// 2. Generate an {@link CreateOrder} instance from $create_order.json.
		final CreateOrder $create_order = mapper.readValue(new FileInputStream("target/test-classes/$create_order.json"), CreateOrder.class);
		Assert.assertNotNull($create_order);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", create_order, $create_order);
	}
	
	/**
	 * 1. Instantiate an {@link LinkSessionToUser} instance with the same values found in 
	 * 	  $link_session_to_user.json.
	 * 
	 * 2. Generate an {@link LinkSessionToUser} instance from $link_session_to_user.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createLinkSessionToUser() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link LinkSessionToUser} instance with the same values found in $link_session_to_user.json.
		final LinkSessionToUser link_session_to_user = new LinkSessionToUser();
		link_session_to_user.setApiKey("INSERT_API_KEY_HERE");
		link_session_to_user.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3");
		
		
		// 2. Generate an {@link LinkSessionToUser} instance from $link_session_to_user.json.
		final LinkSessionToUser $link_session_to_user = mapper.readValue(new FileInputStream("target/test-classes/$link_session_to_user.json"), LinkSessionToUser.class);
		Assert.assertNotNull($link_session_to_user);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", link_session_to_user, $link_session_to_user);
	}
	
	/**
	 * 1. Instantiate an {@link Login} instance with the same values found in 
	 * 	  $login.json.
	 * 
	 * 2. Generate an {@link Login} instance from $login.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createLogin() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link Login} instance with the same values found in $login.json.
		final Login login = new Login();
		login.setApiKey("INSERT_API_KEY_HERE");
		login.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setLoginStatus(LoginStatus.SUCCESS);
		
		
		// 2. Generate an {@link Login} instance from $login.json.
		final Login $login = mapper.readValue(new FileInputStream("target/test-classes/$login.json"), Login.class);
		Assert.assertNotNull($login);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", login, $login);
	}
	
	/**
	 * 1. Instantiate an {@link Logout} instance with the same values found in 
	 * 	  $logout.json.
	 * 
	 * 2. Generate an {@link Logout} instance from $logout.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createLogout() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link Logout} instance with the same values found in $logout.json.
		final Logout logout = new Logout();
		logout.setApiKey("INSERT_API_KEY_HERE");
		logout.setUserId("billy_jones_301");
		
		
		// 2. Generate an {@link Logout} instance from $logout.json.
		final Logout $logout = mapper.readValue(new FileInputStream("target/test-classes/$logout.json"), Logout.class);
		Assert.assertNotNull($logout);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", logout, $logout);
	}
	
	/**
	 * 1. Instantiate an {@link RemoveItemFromCart} instance with the same values found in 
	 * 	  $remove_item_from_cart.json.
	 * 
	 * 2. Generate an {@link RemoveItemFromCart} instance from $remove_item_from_cart.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createRemoveItemFromCart() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link RemoveItemFromCart} instance with the same values found in $remove_item_from_cart.json.
		final RemoveItemFromCart remove_item_from_cart = new RemoveItemFromCart();
		
		final Item item = new Item();
		final String[] tags = new String[]{"Awesome", "Wintertime specials"};
		item.setItemId("B004834GQO").setProductTitle("The Slanket Blanket-Texas Tea").setPrice(399900000l).setCurrency("USD").setUPC("67862114510011").setSKU("004834GQ").setBrand("Slanket").setManufacturer("Slanket").setCategory("Blankets & Throws").setTags(tags).setColor("Texas Tea").setQuantity(2);
		
		remove_item_from_cart.setApiKey("INSERT_API_KEY_HERE");
		remove_item_from_cart.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setItem(item);
		
		
		// 2. Generate an {@link RemoveItemFromCart} instance from $remove_item_from_cart.json.
		final RemoveItemFromCart $remove_item_from_cart = mapper.readValue(new FileInputStream("target/test-classes/$remove_item_from_cart.json"), RemoveItemFromCart.class);
		Assert.assertNotNull($remove_item_from_cart);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", remove_item_from_cart, $remove_item_from_cart);
	}
	
	/**
	 * 1. Instantiate an {@link SendMessage} instance with the same values found in 
	 * 	  $send_message.json.
	 * 
	 * 2. Generate an {@link SendMessage} instance from $send_message.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createSendMessage() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link SendMessage} instance with the same values found in $send_message.json.
		final SendMessage send_message = new SendMessage();
		send_message.setApiKey("INSERT_API_KEY_HERE");
		send_message.setUserId("billy_jones_301").setRecipientUserId("512924123").setSubject("Subject line of the message.").setContent("Text content of message.");
		
		
		// 2. Generate an {@link SendMessage} instance from $send_message.json.
		final SendMessage $send_message = mapper.readValue(new FileInputStream("target/test-classes/$send_message.json"), SendMessage.class);
		Assert.assertNotNull($send_message);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", send_message, $send_message);
	}
	
	/**
	 * 1. Instantiate an {@link SubmitReview} instance with the same values found in 
	 * 	  $submit_review.json.
	 * 
	 * 2. Generate an {@link SubmitReview} instance from $submit_review.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createSubmitReview() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link SubmitReview} instance with the same values found in $submit_review.json.
		final SubmitReview submit_review = new SubmitReview();
		submit_review.setApiKey("INSERT_API_KEY_HERE");
		submit_review.setUserId("billy_jones_301").setContent("Text content of submitted review goes here.").setReviewTitle("Title of Review Goes Here").setItemId("V4C3D5R2Z6").setReviewedUserId("billy_jones_301").setSubmissionStatus(SubmissionStatus.SUCCESS);
		
		
		// 2. Generate an {@link SubmitReview} instance from $submit_review.json.
		final SubmitReview $submit_review = mapper.readValue(new FileInputStream("target/test-classes/$submit_review.json"), SubmitReview.class);
		Assert.assertNotNull($submit_review);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", submit_review, $submit_review);
	}
	
	/**
	 * 1. Instantiate an {@link UpdateAccount} instance with the same values found in 
	 * 	  $update_account.json.
	 * 
	 * 2. Generate an {@link UpdateAccount} instance from $update_account.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createUpdateAccount() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link SubmitReview} instance with the same values found in $update_account.json.
		final PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setPaymentType(PaymentType.CREDIT_CARD).setCardBIN("542486").setCardLast4("4444");

		final Address billingAddress = new Address();
		billingAddress.setPhone("1-415-555-6041").setAddressLine1("2100 Main Street").setAddressLine2("Apt 3B").setCity("New London").setRegion("New Hampshire").setCountry("US").setZipCode("03257");
		
		final UpdateAccount update_account = new UpdateAccount();
		update_account.setApiKey("INSERT_API_KEY_HERE");
		update_account.setUserId("billy_jones_301").setChangedPassword(true).setUserEmail("bill@gmail.com").setName("Bill Jones").setPhone("1-415-555-6040").setReferrerUserId("janejane102").setPaymentMethods(new PaymentMethod[]{paymentMethod}).setBillingAddress(billingAddress).setSocialSignOnType(SocialSignOnType.TWITTER);
		
		
		// 2. Generate an {@link SubmitReview} instance from $update_account.json.
		final UpdateAccount $update_account = mapper.readValue(new FileInputStream("target/test-classes/$update_account.json"), UpdateAccount.class);
		Assert.assertNotNull($update_account);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", update_account, $update_account);
	}
	
	/**
	 * 1. Instantiate an {@link Label} instance with the same values found in 
	 * 	  $label.json.
	 * 
	 * 2. Generate an {@link Label} instance from $label.json.
	 * ---
	 * Both instances must be equal.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void createLabel() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link Label} instance with the same values found in $label.json.
		final Label label = new Label();
		label.setApiKey("INSERT_API_KEY_HERE");
		label.setIsBad(true).setReasons(new Reason[]{Reason.CHARGEBACK}).setDescription("Freeform text describing the user or incident.");
		
		// 2. Generate an {@link Label} instance from $label.json.
		final Label $label = mapper.readValue(new FileInputStream("target/test-classes/$label.json"), Label.class);
		Assert.assertNotNull($label);
		
		/*
		 * ---
		 * Both instances must be equal.
		 */
		Assert.assertEquals("Both instances must be equal", label, $label);
	}
}

