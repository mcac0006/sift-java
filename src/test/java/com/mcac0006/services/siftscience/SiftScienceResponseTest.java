/**
 *
 */
package com.mcac0006.services.siftscience;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mcac0006.siftscience.SiftScienceHelper;
import com.mcac0006.siftscience.result.domain.SiftScienceResponse;
import com.mcac0006.siftscience.score.domain.Label;
import com.mcac0006.siftscience.score.domain.Reason;
import com.mcac0006.siftscience.score.domain.SiftScienceScore;

/**
 * @author <a href="mailto:jburnim@siftscience.com">Jacob Burnim</a>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class SiftScienceResponseTest {

	@Mock
	private Response responseMock;

	@Before
	public void setup() {
		// ... and inject the mock into the static method.
		final Builder builderMock = Mockito.mock(Builder.class);
		Mockito.when(builderMock.get()).thenReturn(responseMock);

		final WebTarget webTargetMock = Mockito.mock(WebTarget.class);
		Mockito.when(webTargetMock.request(MediaType.APPLICATION_JSON_TYPE)).thenReturn(builderMock);
		Mockito.when(webTargetMock.path(Mockito.anyString())).thenReturn(webTargetMock);
		Mockito.when(webTargetMock.queryParam(Mockito.anyString(), Mockito.anyString())).thenReturn(webTargetMock);

		final Client clientMock = Mockito.mock(Client.class);
		Mockito.when(clientMock.target(Mockito.anyString())).thenReturn(webTargetMock);

		PowerMockito.mockStatic(ClientBuilder.class);
		Mockito.when(ClientBuilder.newClient()).thenReturn(clientMock);
	}


	@Test
	public void testScoreError() throws IOException {
		// let's load up the score sample file
		final InputStream inputStream = new FileInputStream("target/test-classes/result/$sift_result_sample_from_docs.json");
		final SiftScienceResponse responseFromSS = SiftScienceHelper.deserializeResponse(IOUtils.toString(inputStream));


		final SiftScienceResponse responseToAssertAgainst = new SiftScienceResponse();
		responseToAssertAgainst.setStatus(0);
		responseToAssertAgainst.setError_message("OK");
		responseToAssertAgainst.setRequest("body_of_the_request_you_sent");
		responseToAssertAgainst.setTime(1454517138);

		final SiftScienceScore score = new SiftScienceScore();
		score.setStatus((short)0);
		score.setErrorMessage("OK");
		score.setUserId("sample_user2");
                score.setScore(0.39944676614045643f);
		responseToAssertAgainst.setScoreResponse(score);

		Label label = new Label();
		label.setIsBad(false);
		com.mcac0006.siftscience.types.Reason[] reasons = new com.mcac0006.siftscience.types.Reason[1];
		reasons[0] = com.mcac0006.siftscience.types.Reason.SPAM;
		final Calendar cal = Calendar.getInstance(); cal.setTimeInMillis(1454517070000L);
		label.setTime(cal);
		label.setReasons(reasons);
		score.setLatestLabel(label);

		final Reason reason1 = new Reason();
		reason1.setName("Number of users with the same billing address");
		reason1.setValue("3");
		reason1.addDetails("users", "sample_user3,sample_user4");

		score.setReasons(new Reason[]{ reason1 });

                Assert.assertEquals(responseToAssertAgainst, responseFromSS);
	}

	@Test
	public void testSuccessfulPath() throws IOException {
		// let's load up the score sample file
		final InputStream inputStream = new FileInputStream("target/test-classes/result/$sift_result_sample_with_score_error.json");
		final SiftScienceResponse responseFromSS = SiftScienceHelper.deserializeResponse(IOUtils.toString(inputStream));


		final SiftScienceResponse responseToAssertAgainst = new SiftScienceResponse();
		responseToAssertAgainst.setStatus(0);
		responseToAssertAgainst.setError_message("OK");
		responseToAssertAgainst.setRequest("...request_body...");
		responseToAssertAgainst.setTime(1454519952);

		final SiftScienceScore score = new SiftScienceScore();
		score.setStatus((short)-3);
		score.setErrorMessage("Server-side timeout processing request. Please try again later.");
		responseToAssertAgainst.setScoreResponse(score);

                Assert.assertEquals(responseToAssertAgainst, responseFromSS);
	}
}
