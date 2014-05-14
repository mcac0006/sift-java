/**
 * 
 */
package com.mcac0006.services.siftscience;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
import com.mcac0006.siftscience.score.domain.Reason;
import com.mcac0006.siftscience.score.domain.SiftScienceScore;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class SiftScienceScoreTests {
	
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
	public void testSuccessfulPath() throws IOException {
		
		// let's load up the score sample file
		final InputStream inputStream = new FileInputStream("target/test-classes/score/$sift_score_sample.json");
		Mockito.when(responseMock.readEntity(String.class)).thenReturn(IOUtils.toString(inputStream));
		
		final SiftScienceScore scoreFromSS = new SiftScienceHelper("123").getScore("mcac0006");
		
		
		final SiftScienceScore scoreToAssertAgainst = new SiftScienceScore();
		scoreToAssertAgainst.setStatus((short)0);
		scoreToAssertAgainst.setErrorMessage("OK");
		scoreToAssertAgainst.setScore(0.6022920863521355f);
		scoreToAssertAgainst.setUserId("mcac0006");
		
		final Reason reason1 = new Reason();
		reason1.setName("Users per device");
		reason1.setValue(2);
		reason1.addDetails("users", "ggre0001");
		
		final Reason reason2 = new Reason();
		reason2.setName("Transaction billing bin");
		reason2.setValue(444433);
		reason2.addDetails("users", "user1");
		
		final Reason reason3 = new Reason();
		reason3.setName("Time since previous transaction");
		reason3.setValue(0.003);
		
		final Reason reason4 = new Reason();
		reason4.setName("Users per browser+IP");
		reason4.setValue(9);
		reason4.addDetails("users", "JLHBNCCELNGCPDHIFNJGNEGKNDOKDNHDDBJLPLMCIJAMKKNKOCNPPHCFBJGHDMKHCDCDMDNJJLKFMBBNHMHKMMGOBELIMFNKAMEGGDEHFMCOFMDKNOPEGPHDLMNOMAED,ggre0001,FGGFGDAHIFMAGALFDHMBGBENFMLPKMCGFDGOPCAG,al_capoopoo,DMEKDIEEPMLBHEJBPFCMPHJPIGEOBOPFAKGPAMDC,APBBICJCMAGIPNKMDPEMFFAGFCOOHJJCMCNPCLBD,NKDJKDOOFOGLELANDCFFLPOPJFGABIJAKPNIAHAJ,NLMPOHIPDNGDNKDADCAHKFILIBNFBKAJNMNLIEKB");
		
		scoreToAssertAgainst.setReasons(new Reason[]{ reason1, reason2, reason3, reason4 });
		
		Assert.assertEquals(scoreToAssertAgainst, scoreFromSS);
	}
	
	@Test
	public void testUnknownUser() throws IOException {
		
		// let's load up the score sample file
		final InputStream inputStream = new FileInputStream("target/test-classes/score/$sift_score_unknown_user_sample.json");
		Mockito.when(responseMock.readEntity(String.class)).thenReturn(IOUtils.toString(inputStream));
		
		final SiftScienceScore scoreFromSS = new SiftScienceHelper("123").getScore("mcac0006");
		
		final SiftScienceScore scoreToAssertAgainst = new SiftScienceScore();
		scoreToAssertAgainst.setStatus((short)54);
		scoreToAssertAgainst.setErrorMessage("Specified user_id has no scorable events");
		scoreToAssertAgainst.setUserId("mcac0006");
		
		Assert.assertEquals(scoreToAssertAgainst, scoreFromSS);
	}
}
