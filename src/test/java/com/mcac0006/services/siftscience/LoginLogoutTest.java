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
import com.mcac0006.siftscience.event.domain.Login;
import com.mcac0006.siftscience.event.domain.Logout;
import com.mcac0006.siftscience.types.LoginStatus;

public class LoginLogoutTest {

	/**
	 * Asserts that the keys in the given jsonObject are there and no extra/missing keys are found.
	 * 
	 * @param jsonObject - the list of 
	 * @param expectedKeys
	 */
	private void assertEquals(final Set<String> jsonKeys, final List<String> expectedKeys) {
		
		Assert.assertEquals(String.format("Number of expected keys [%s] not the same: [%s].", expectedKeys.size(), jsonKeys.size()), expectedKeys.size(), jsonKeys.size());
		for (final String key: expectedKeys)
			Assert.assertTrue(String.format("Key [%s] expected.", key), jsonKeys.contains(key));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void loginTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link Login} instance with the same values found in $login.json.
		final Login login = new Login();
		login.setApiKey("INSERT_API_KEY_HERE");
		login.setUserId("billy_jones_301").setSessionId("gigtleqddo84l8cm15qe4il3q3").setLoginStatus(LoginStatus.SUCCESS);
		
		final String json = SiftScienceHelper.serialize(login); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id", "$login_status");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$login", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
		Assert.assertEquals("gigtleqddo84l8cm15qe4il3q3", $.get("$session_id"));
		Assert.assertEquals("$success", $.get("$login_status"));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void logoutTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		// 1. Instantiate an {@link Login} instance with the same values found in $login.json.
		final Logout logout = new Logout();
		logout.setApiKey("INSERT_API_KEY_HERE");
		logout.setUserId("billy_jones_301");	
		
		final String json = SiftScienceHelper.serialize(logout); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id");
		assertEquals($.keySet(), $expectedKeys);
		
		// then assert the values
		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals("$logout", $.get("$type"));
		Assert.assertEquals("billy_jones_301", $.get("$user_id"));
	}
}

