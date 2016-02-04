package com.mcac0006.services.siftscience;

import com.jayway.jsonpath.JsonPath;
import com.mcac0006.siftscience.SiftScienceHelper;
import com.mcac0006.siftscience.event.domain.CreateContent;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static com.mcac0006.services.siftscience.AssertJsonKeys.assertEquals;

public class CreateContentBodyTest {

    @Test
    public void createContentTest() throws IOException {
        final CreateContent create_order = new CreateContent();
        String expectedApiKey = "INSERT_API_KEY_HERE";
        create_order.setApiKey(expectedApiKey);
        String expectedUserId = "john_doe";
        String expectedSessionId = "abcabcabc";
        String expectedContactEmail = "test@siftscience.com";
        String expectedContactPhone = "1-800-123-1234";
        String expectedSubject = "Subject";
        String expectedContent = "Lorem ipsum dolor sit amet";
        create_order.setUserId(expectedUserId).setSessionId(expectedSessionId).setContactEmail(expectedContactEmail).setContactPhone(expectedContactPhone).setSubject(expectedSubject).setContent(expectedContent);

        final String json = SiftScienceHelper.serialize(create_order); // the json object we will be asserting

        final LinkedHashMap<String, Object> $ = JsonPath.read(json, "$");

        // assert first level
        final List<String> $expectedKeys = Arrays.asList("$type", "$api_key", "$user_id", "$session_id", "$contact_email", "$contact_phone", "$subject", "$content");
        assertEquals($.keySet(), $expectedKeys);

        // then assert the values
        Assert.assertEquals(expectedApiKey, $.get("$api_key"));
        Assert.assertEquals("$create_content", $.get("$type"));
        Assert.assertEquals(expectedUserId, $.get("$user_id"));

        Assert.assertEquals(expectedSessionId, $.get("$session_id"));
        Assert.assertEquals(expectedContactEmail, $.get("$contact_email"));
        Assert.assertEquals(expectedContactPhone, $.get("$contact_phone"));
        Assert.assertEquals(expectedSubject, $.get("$subject"));
        Assert.assertEquals(expectedContent, $.get("$content"));
    }
}
