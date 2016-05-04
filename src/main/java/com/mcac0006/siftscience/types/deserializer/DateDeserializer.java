/**
 * 
 */
package com.mcac0006.siftscience.types.deserializer;

import java.io.IOException;
import java.util.Calendar;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * @author matthew.cachia
 *
 */
public class DateDeserializer extends JsonDeserializer<Calendar> {

	/* (non-Javadoc)
	 * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser, org.codehaus.jackson.map.DeserializationContext)
	 */
	@Override
	public Calendar deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(parser.getLongValue() * 1000);
		return cal;
	}

}
