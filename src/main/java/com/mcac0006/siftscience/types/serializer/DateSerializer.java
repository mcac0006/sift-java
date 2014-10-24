/**
 * 
 */
package com.mcac0006.siftscience.types.serializer;

import java.io.IOException;
import java.util.Calendar;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @author matthew.cachia
 *
 */
public class DateSerializer extends JsonSerializer<Calendar> {

	@Override
	public void serialize(Calendar date, JsonGenerator gen, SerializerProvider pro) throws IOException, JsonProcessingException {
		gen.writeNumber(date.getTimeInMillis() / 1000);
	}

}
