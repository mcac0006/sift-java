/**
 * 
 */
package com.mcac0006.siftscience;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mcac0006.siftscience.event.domain.Event;
import com.mcac0006.siftscience.label.domain.Label;
import com.mcac0006.siftscience.result.domain.SiftScienceResponse;
import com.mcac0006.siftscience.score.domain.SiftScienceScore;

/**
 * This helper will take care of marshalling the content you wish to send to Sift Science and 
 * also POST send it to Sift Science.
 * 
 * <strong>This class is synchronous.</strong>
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SiftScienceHelper {
	
	private ObjectMapper mapper;
	
	private String apiKey;
	
	public SiftScienceHelper(final String apiKey) {
		
		if (apiKey == null || apiKey.isEmpty()) {
			throw new RuntimeException("The API Key apiKey must not be null or empty.");
		}
		
		this.apiKey = apiKey;
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}
	
	/**
	 * Sends an event ($transaction, $create_account, etc ...) to Sift Sciecne.
	 * 
	 * @param event - the content regarding the user (or session) in question.
	 * @return the Sift Science response which denotes whether the request has been processed successfully or not.
	 */
	public SiftScienceResponse send(final Event event) {
		
		event.setApiKey(apiKey);
		
		try {
			
			final Client client = ClientBuilder.newClient();
			final WebTarget target = client.target("https://api.siftscience.com/v203/events");
			final Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
			final Response post = request.post(Entity.entity(mapper.writeValueAsString(event), MediaType.APPLICATION_JSON_TYPE));
			
			final SiftScienceResponse siftResult = mapper.readValue(post.readEntity(String.class), SiftScienceResponse.class);
			return siftResult;
			
		} catch (JsonGenerationException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		} catch (IOException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		}
	}
	
	/**
	 * Sends a Label ($label) to Sift Science.
	 * 
	 * @param userId - the user in question
	 * @param label - the content regarding the user in question.
	 * @return the Sift Science response which denotes whether the request has been processed successfully or not.
	 */
	public SiftScienceResponse send(final String userId, final Label label) {
		
		label.setApiKey(apiKey);
		
		try {
			
			final Client client = ClientBuilder.newClient();
			final WebTarget target = client.target("https://api.siftscience.com/v203/users/").path(userId).path("labels");
			final Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
			final Response post = request.post(Entity.entity(mapper.writeValueAsString(label), MediaType.APPLICATION_JSON_TYPE));
			
			final SiftScienceResponse siftResult = mapper.readValue(post.readEntity(String.class), SiftScienceResponse.class);
			return siftResult;
			
		} catch (JsonGenerationException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		} catch (IOException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		}
	}
	
	/**
	 * Retrieve a risk assessment of a particular user. This is particularly useful to consult with Sift Science 
	 * before you proceed with any (user-invoked or system-invoked) operations (such as a purchase) on that user.
	 * 
	 * @param userId - the user would you like to run a risk assessment on.
	 * @return a Sift Science score wrapped in a {@link SiftScienceScore} instance containing information such as the 
	 *         fraud score and the reason. 
	 *         
	 *         Refer to the class' JavaDocs for more information.
	 */
	public SiftScienceScore getScore(final String userId) {
		
		try {
			
			final Client client = ClientBuilder.newClient();
			final WebTarget target = client.target("https://api.siftscience.com/v203/score/").path(userId).queryParam("api_key", apiKey);
			final Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
			final Response get = request.get();
			
			final SiftScienceScore score = mapper.readValue(get.readEntity(String.class), SiftScienceScore.class);
			return score;
			
		} catch (JsonGenerationException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		} catch (IOException e) {
			throw new RuntimeException("Error generating JSON content to send.", e);
		}
		
	}
}
