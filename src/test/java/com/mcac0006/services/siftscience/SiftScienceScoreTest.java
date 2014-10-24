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
import com.mcac0006.siftscience.score.domain.Label;
import com.mcac0006.siftscience.score.domain.Reason;
import com.mcac0006.siftscience.score.domain.SiftScienceScore;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class SiftScienceScoreTest {
	
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
		final SiftScienceScore scoreFromSS = SiftScienceHelper.deserializeScore(IOUtils.toString(inputStream));
		
		
		final SiftScienceScore scoreToAssertAgainst = new SiftScienceScore();
		scoreToAssertAgainst.setStatus((short)0);
		scoreToAssertAgainst.setErrorMessage("OK");
		scoreToAssertAgainst.setScore(0.6022920863521355f);
		scoreToAssertAgainst.setUserId("mcac0006");
		
		final Reason reason1 = new Reason();
		reason1.setName("Users per device");
		reason1.setValue("2");
		reason1.addDetails("users", "ggre0001");
		
		final Reason reason2 = new Reason();
		reason2.setName("Transaction billing bin");
		reason2.setValue("444433");
		reason2.addDetails("users", "user1");
		
		final Reason reason3 = new Reason();
		reason3.setName("Time since previous transaction");
		reason3.setValue("0.003");
		
		final Reason reason4 = new Reason();
		reason4.setName("Users per browser+IP");
		reason4.setValue("9");
		reason4.addDetails("users", "JLHBNCCELNGCPDHIFNJGNEGKNDOKDNHDDBJLPLMCIJAMKKNKOCNPPHCFBJGHDMKHCDCDMDNJJLKFMBBNHMHKMMGOBELIMFNKAMEGGDEHFMCOFMDKNOPEGPHDLMNOMAED,ggre0001,FGGFGDAHIFMAGALFDHMBGBENFMLPKMCGFDGOPCAG,al_capoopoo,DMEKDIEEPMLBHEJBPFCMPHJPIGEOBOPFAKGPAMDC,APBBICJCMAGIPNKMDPEMFFAGFCOOHJJCMCNPCLBD,NKDJKDOOFOGLELANDCFFLPOPJFGABIJAKPNIAHAJ,NLMPOHIPDNGDNKDADCAHKFILIBNFBKAJNMNLIEKB");
		
		scoreToAssertAgainst.setReasons(new Reason[]{ reason1, reason2, reason3, reason4 });
		
		Assert.assertEquals(scoreToAssertAgainst, scoreFromSS);
	}
	
	@Test
	public void testAnotherSuccessfulPath() throws IOException {
		
		// let's load up the score sample file
		final InputStream inputStream = new FileInputStream("target/test-classes/score/$sift_score_sample_2.json");
		final SiftScienceScore scoreFromSS = SiftScienceHelper.deserializeScore(IOUtils.toString(inputStream));
		
		
		final SiftScienceScore scoreToAssertAgainst = new SiftScienceScore();
		scoreToAssertAgainst.setStatus((short)0);
		scoreToAssertAgainst.setErrorMessage("OK");
		scoreToAssertAgainst.setScore(0.9340580293938543f);
		scoreToAssertAgainst.setUserId("FGJJKOIEDDLCAGLNCHLKICOGCCCMCILDJCFCEOIF");
		
		Label label = new Label();
		label.setIsBad(true);
		com.mcac0006.siftscience.types.Reason[] reasons = new com.mcac0006.siftscience.types.Reason[1];
		reasons[0] = com.mcac0006.siftscience.types.Reason.CHARGEBACK;
		final Calendar cal = Calendar.getInstance(); cal.setTimeInMillis((long)1405494666*1000);
		label.setTime(cal);
		label.setReasons(reasons);
		scoreToAssertAgainst.setLatestLabel(label);
		
		final Reason reason1 = new Reason();
		reason1.setName("Latest billing address country");
		reason1.setValue("NZ");
		
		final Reason reason2 = new Reason();
		reason2.setName("Failed transactionss per hour");
		reason2.setValue("4");
		
		final Reason reason3 = new Reason();
		reason3.setName("Latest billing address name");
		reason3.setValue("Ray Weston");
		
		final Reason reason4 = new Reason();
		reason4.setName("Transactions per hour");
		reason4.setValue("6");
		
		final Reason reason5 = new Reason();
		reason5.setName("Time since previous transaction");
		reason5.setValue("0");
		
		final Reason reason6 = new Reason();
		reason6.setName("Time since previous event");
		reason6.setValue("0");
		
		final Reason reason7 = new Reason();
		reason7.setName("Latest billing address city");
		reason7.setValue("Berfaler");
		
		final Reason reason8 = new Reason();
		reason8.setName("Failed transactionss per week");
		reason8.setValue("40");
		
		final Reason reason9 = new Reason();
		reason9.setName("Failed transactionss per day");
		reason9.setValue("16");
		
		final Reason reason10 = new Reason();
		reason10.setName("Latest billing address address 1");
		reason10.setValue("Santorama street 1190-4");
		
		final Reason reason11 = new Reason();
		reason11.setName("Original amount");
		reason11.setValue("1500");
		
		final Reason reason12 = new Reason();
		reason12.setName("Purchase amount in USD");
		reason12.setValue("1574.25");
		
		final Reason reason13 = new Reason();
		reason13.setName("Email address");
		reason13.setValue("futudabehog@hotmail.com");
		
		final Reason reason14 = new Reason();
		reason14.setName("Unique Bank Identification Numbers");
		reason14.setValue("19");
		
		final Reason reason15 = new Reason();
		reason15.setName("Transactions per minute");
		reason15.setValue("4");
		
		final Reason reason16 = new Reason();
		reason16.setName("Credit card country");
		reason16.setValue("AE");
		
		final Reason reason17 = new Reason();
		reason17.setName("Purchase totals per week");
		reason17.setValue("8144.778");
		
		final Reason reason18 = new Reason();
		reason18.setName("Credit card bank");
		reason18.setValue("NATIONAL BANK OF RAS AL-KHAIMAH (RAKBANK)");
		reason18.addDetails("users", "PDBKKIGJNHCPDLNGLNFGBDDEPGBPPLCJDPMNLPHC,BHONOOMIPOJDMJJMDAKGIAGOMIGLNKLEKNLDBCEB,JEJLAIJJILJEGEINBJNKGJIFDDJPKCGOLCNDFPLO,CJGKAEOGCBIJPMAFBLOEHBPPHKFACOCCPHENOBPK");
		
		final Reason reason19 = new Reason();
		reason19.setName("Transactions per day");
		reason19.setValue("2");
		
		scoreToAssertAgainst.setReasons(new Reason[]{ reason1, reason2, reason3, reason4, reason5, reason6, reason7, reason8, reason9, reason10, reason11, reason12, reason13, reason14, reason15, reason16, reason17, reason18, reason19 });
		
		Assert.assertEquals(scoreToAssertAgainst, scoreFromSS);
	}
	
	@Test
	public void testUnknownUser() throws IOException {
		
		// let's load up the score sample file
		final InputStream inputStream = new FileInputStream("target/test-classes/score/$sift_score_unknown_user_sample.json");
		final SiftScienceScore scoreFromSS = SiftScienceHelper.deserializeScore(IOUtils.toString(inputStream));
		
		final SiftScienceScore scoreToAssertAgainst = new SiftScienceScore();
		scoreToAssertAgainst.setStatus((short)54);
		scoreToAssertAgainst.setErrorMessage("Specified user_id has no scorable events");
		scoreToAssertAgainst.setUserId("mcac0006");
		
		Assert.assertEquals(scoreToAssertAgainst, scoreFromSS);
	}
}
