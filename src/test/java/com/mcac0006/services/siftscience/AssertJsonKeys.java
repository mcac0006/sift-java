package com.mcac0006.services.siftscience;

import org.junit.Assert;

import java.util.List;
import java.util.Set;

public final class AssertJsonKeys {

    /**
     * Asserts that the keys in the given jsonObject are there and no extra/missing keys are found.
     *
     * @param jsonObject - the list of
     * @param expectedKeys
     */
    public static void assertEquals(final Set<String> jsonKeys, final List<String> expectedKeys) {

        Assert.assertEquals("Number of keys different from expected. Expected keys [%s].", expectedKeys.size(), jsonKeys.size());
        for (final String key : expectedKeys)
            Assert.assertTrue(String.format("Key [%s] expected.", key), jsonKeys.contains(key));
    }

    private AssertJsonKeys() {
    }
}
