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

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mcac0006.siftscience.event.domain.Event;
import com.mcac0006.siftscience.exception.SiftScienceException;
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
	
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}

	private SiftScienceHelper() {}
	
	/**
	 * Sends an event ($transaction, $create_account, etc ...) to Sift Science.
	 * 
	 * @param event - the content regarding the user (or session) in question.
	 * @return the Sift Science response which denotes whether the request has been processed successfully or not.
	 */
	public static SiftScienceResponse send(final Event event) {
		
		try {
			
			final Client client = ClientBuilder.newClient();
			final WebTarget target = client.target("https://api.siftscience.com/v203/events");
			final Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
			final Response post = request.post(Entity.entity(serialize(event), MediaType.APPLICATION_JSON_TYPE));
			
			final SiftScienceResponse siftResult = deserializeResponse(post.readEntity(String.class));
			return siftResult;
			
		} catch (IOException e) {
			throw new SiftScienceException("Error generating JSON content to send event.", e);
		}
	}
	
	/**
	 * Sends a Label ($label) to Sift Science.
	 * 
	 * @param userId - the user in question
	 * @param label - the content regarding the user in question.
	 * @return the Sift Science response which denotes whether the request has been processed successfully or not.
	 */
	public static SiftScienceResponse send(final String userId, final Label label) {
		
		try {
			
			final Client client = ClientBuilder.newClient();
			final WebTarget target = client.target("https://api.siftscience.com/v203/users/").path(userId).path("labels");
			final Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
			final Response post = request.post(Entity.entity(serialize(label), MediaType.APPLICATION_JSON_TYPE));
			
			final SiftScienceResponse siftResult = deserializeResponse(post.readEntity(String.class));
			return siftResult;
			
		} catch (IOException e) {
			throw new SiftScienceException("Error generating JSON content to send label.", e);
		}
	}
	
	/**
	 * Retrieve a risk assessment of a particular user. This is particularly useful to consult with Sift Science 
	 * before you proceed with any (user-invoked or system-invoked) operations (such as a purchase) on that user.
	 * 
	 * @param apiKey - the api key to denote which Sift Science account to use.
	 * @param userId - the user would you like to run a risk assessment on.
	 * 
	 * @return a Sift Science score wrapped in a {@link SiftScienceScore} instance containing information such as the 
	 *         fraud score and the reason. 
	 *         
	 *         Refer to the class' JavaDocs for more information.
	 */
	public static SiftScienceScore getScore(final String apiKey, final String userId) {
		
		try {
			
			final Client client = ClientBuilder.newClient();
			final WebTarget target = client.target("https://api.siftscience.com/v203/score/").path(userId).queryParam("api_key", apiKey);
			final Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
			final Response get = request.get();
			
			final SiftScienceScore score = deserializeScore(get.readEntity(String.class));
			return score;
			
		} catch (IOException e) {
			throw new RuntimeException("Error generating JSON content to retrieve score request.", e);
		}
		
	}

	/**
	 * <p>Serializes an event as a JSON envelope, ready to be sent to Sift Science.</p>
	 * 
	 * <p><strong>Useful if you have your own way of sending the envelope.</strong> Should you require a way of 
	 * sending the envelope via Http, you can make use of {@link SiftScienceHelper#send(Event)}.</p>
	 * 
	 * @param event the filled event POJO, ready to be serialized
	 * @return the event in JSON form.
	 * @throws IOException thrown whenever an error (unexpected or user-inflicted) has been found during serialization of the event. 
	 */
	public static String serialize(final Event event) throws IOException {
		return mapper.writeValueAsString(event);
	}
	
	public static String serialize(final Label label) throws IOException {
		return mapper.writeValueAsString(label);
	}
	
	/**
	 * <p>Deserializes a response after sending an {@link Event} or a {@link Label}.
	 * 
	 * @param response the JSON envelope withholding Sift Science's response.
	 * @return the response in POJO.
	 * @throws IOException thrown whenever an error (unexpected or user-inflicted) has been found during deserialization of the event or label.
	 */
	public static SiftScienceResponse deserializeResponse(final String response) throws IOException {
		return mapper.readValue(response, SiftScienceResponse.class);
	}
	
	/**
	 * <p>Deserializes the score returned by Sift Science.</p>
	 * 
	 * <p><strong>Useful if you have your own way of sending and receiving requests.</strong> Should you require a way of 
	 * receiving the score Http, you can make use of {@link SiftScienceHelper#getScore(String, String)}.</p>
	 * 
	 * @param scoreResponse the JSON envelope withholding Sift Science's response.
	 * @return the response in POJO.
	 * @throws IOException thrown whenever an error (unexpected or user-inflicted) has been found during deserialization of the score.
	 */
	public static SiftScienceScore deserializeScore(final String scoreResponse) throws IOException {
		return mapper.readValue(scoreResponse, SiftScienceScore.class);
	}
}
