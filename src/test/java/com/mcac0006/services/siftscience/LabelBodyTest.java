package com.mcac0006.services.siftscience;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;
import com.mcac0006.siftscience.SiftScienceHelper;
import com.mcac0006.siftscience.label.domain.Label;
import com.mcac0006.siftscience.types.Reason;

public class LabelBodyTest {

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
	
	/**
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void labelTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final Label label = new Label();
		label.setApiKey("INSERT_API_KEY_HERE");
		label.setIsBad(true).setReasons(new Reason[]{Reason.CHARGEBACK}).setDescription("Freeform text describing the user or incident.");

		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(label); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$api_key", "$is_bad", "$reasons", "$description");
		assertEquals($.keySet(), $expectedKeys);
	

		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals(true, $.get("$is_bad"));
		Assert.assertEquals("Freeform text describing the user or incident.", $.get("$description"));
		
		final List<String> reasons = (List<String>)$.get("$reasons");
		Assert.assertEquals(reasons, Arrays.asList("$chargeback"));
		
	}
	
	/**
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void historicalLabelTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		final Label label = new Label();
		label.setApiKey("INSERT_API_KEY_HERE");
		final Calendar cal = Calendar.getInstance(); cal.setTimeInMillis((long)1405494666*1000);
		label.setTime(cal);
		label.setIsBad(true).setReasons(new Reason[]{Reason.CHARGEBACK}).setDescription("Freeform text describing the user or incident.");

		/*
		 * Assert.
		 */
		
		final String json = SiftScienceHelper.serialize(label); // the json object we will be asserting		
		final Object read = JsonPath.read(json, "$");
		final LinkedHashMap<String, Object> $ =(LinkedHashMap<String, Object>)read; 
		
		// assert first level
		final List<String> $expectedKeys = Arrays.asList("$api_key", "$time", "$is_bad", "$reasons", "$description");
		assertEquals($.keySet(), $expectedKeys);
	

		Assert.assertEquals("INSERT_API_KEY_HERE", $.get("$api_key"));
		Assert.assertEquals(1405494666, $.get("$time"));
		Assert.assertEquals(true, $.get("$is_bad"));
		Assert.assertEquals("Freeform text describing the user or incident.", $.get("$description"));
		
		final List<String> reasons = (List<String>)$.get("$reasons");
		Assert.assertEquals(reasons, Arrays.asList("$chargeback"));		
	}
}

