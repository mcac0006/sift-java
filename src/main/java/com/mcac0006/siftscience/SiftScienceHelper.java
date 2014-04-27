/**
 * 
 */
package com.mcac0006.siftscience;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mcac0006.siftscience.event.domain.Event;
import com.mcac0006.siftscience.label.domain.Label;
import com.mcac0006.siftscience.result.SiftScienceResult;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SiftScienceHelper {
	
	private ObjectMapper mapper;
	
	private String apiKey;
	
	public SiftScienceHelper(final String apiKey) throws Exception {
		
		if (apiKey == null || apiKey.isEmpty()) {
			throw new Exception("The API Key apiKey must not be null or empty.");
		}
		
		this.apiKey = apiKey;
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}
	
	public SiftScienceResult send(final Event event) {
		
		try {
			
	    	final String url = "https://api.siftscience.com/v203/events";
	   	 
	    	final HttpClient client = HttpClientBuilder.create().build();
	    	final HttpPost post = new HttpPost(url);
	    	post.setHeader("User-Agent", "Mozilla/5.0");
	     
	    	event.setApiKey(apiKey);
	        final HttpEntity entity = new ByteArrayEntity(mapper.writeValueAsString(event).getBytes("UTF-8"));
	        post.setEntity(entity);
	        
	    	final HttpResponse response = client.execute(post);
	    	if (response.getStatusLine().getStatusCode() != 200) {
	    		throw new RuntimeException(String.format("Error trying to send request to SiftScience. Http Code [%s].", response.getStatusLine().getStatusCode()));
	    	}
	    	final SiftScienceResult siftResult = mapper.readValue(response.getEntity().getContent(), SiftScienceResult.class);
	    	
	    	return siftResult;
	    	
		} catch (Exception ex) {
			throw new RuntimeException("An unexpected error was thrown.", ex);
		}
	}
	
	public SiftScienceResult send(final String userId, final Label label) {
		
		try {
			
			final String url = String.format("https://api.siftscience.com/v203/users/%s/labels", userId);
	   	 
	    	final HttpClient client = HttpClientBuilder.create().build();
	    	final HttpPost post = new HttpPost(url);
	    	post.setHeader("User-Agent", "Mozilla/5.0");
	    	
	    	label.setApiKey(this.apiKey);
	        final HttpEntity entity = new ByteArrayEntity(mapper.writeValueAsString(label).getBytes("UTF-8"));
	        post.setEntity(entity);
	     
	    	final HttpResponse response = client.execute(post);
	    	if (response.getStatusLine().getStatusCode() != 200) {
	    		throw new RuntimeException(String.format("Error trying to send request to SiftScience. Http Code [%s].", response.getStatusLine().getStatusCode()));
	    	}
	    	final SiftScienceResult siftResult = mapper.readValue(response.getEntity().getContent(), SiftScienceResult.class);
	    	
	    	return siftResult;
	    	
		} catch (Exception ex) {
			throw new RuntimeException("An unexpected error was thrown.", ex);
		}
	}
}
