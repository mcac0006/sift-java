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
import com.mcac0006.siftscience.event.domain.SendMessage;
import com.mcac0006.siftscience.event.domain.SubmitReview;
import com.mcac0006.siftscience.types.SubmissionStatus;

import static com.mcac0006.services.siftscience.AssertJsonKeys.assertEquals;

public class SendMessageAndSubmitReviewBodyTest {

	@Test
	@SuppressWarnings("unchecked")
	public void sendMessageTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final SendMessage send_message = new SendMessage();
		send_message.setApiKey("INSERT_API_KEY_HERE");
		send_message.setUserId("billy_jones_301").setRecipientUserId("512924123").setSubject("Subject line of the message.").setContent("Text content of message.");
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(send_message); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$recipient_user_id", "$subject", "$content");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$send_message", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("512924123", $.get("$recipient_user_id"));
		Assert.assertEquals("Subject line of the message.", $.get("$subject"));
		Assert.assertEquals("Text content of message.", $.get("$content"));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void submitReviewTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final SubmitReview submit_review = new SubmitReview();
		submit_review.setApiKey("INSERT_API_KEY_HERE");
		submit_review.setUserId("billy_jones_301").setContent("Text content of submitted review goes here.").setReviewTitle("Title of Review Goes Here").setItemId("V4C3D5R2Z6").setReviewedUserId("billy_jones_301").setSubmissionStatus(SubmissionStatus.SUCCESS);
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(submit_review); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$content", "$review_title", "$item_id", "$reviewed_user_id", "$submission_status");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$submit_review", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("Text content of submitted review goes here.", $.get("$content"));
		Assert.assertEquals("Title of Review Goes Here", $.get("$review_title"));
		Assert.assertEquals("V4C3D5R2Z6", $.get("$item_id"));
		Assert.assertEquals("billy_jones_301", $.get("$reviewed_user_id"));
		Assert.assertEquals("$success", $.get("$submission_status"));
	}
}

