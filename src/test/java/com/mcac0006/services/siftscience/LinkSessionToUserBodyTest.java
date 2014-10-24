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
import com.mcac0006.siftscience.event.domain.LinkSessionToUser;

public class LinkSessionToUserBodyTest {

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
	public void linkSessionToUserTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final LinkSessionToUser link_session_to_user = new LinkSessionToUser();
		link_session_to_user.setApiKey("INSERT_API_KEY_HERE");
		link_session_to_user.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3");
		
		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(link_session_to_user); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$link_session_to_user", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
	}
}

