package edu.ncsu.csc.itrust.http;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;
import edu.ncsu.csc.itrust.enums.TransactionType;

/**
 * Test Diagnosis Trends page
 * 
 * @author Daniel Farrell
 * Goal: Test getEpidemicStatistics, which is called right after input from viewEpidemics.jsp is taken in. 
 * Input will be checked, and a FormValidationException will be thrown if the input is invalid. 
 * FormValidationException being thrown results in a nice message being given to the user, not an exception splat. 
 */
public class HandleInvalidThresholdTest extends iTrustHTTPTest {

	/**
	 * Sets up the test. Clears the tables then adds necessary data
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		
		gen.standardData();
		//gen.patient_hcp_vists();
		//gen.hcp_diagnosis_data();
	}
	
	/**
	 * Authenticate PHA
	 * MID 7000000001
	 * Password: pw
	 * Choose "Diagnosis Trends"
	 * Enter Fields:
	 * ICDCode: 84.50
	 * ZipCode: 27607
	 * StartDate: 1/02/2012
	 * Threshold: ""
	 */
	public void testViewDiagnosisTrends_ThresholdNull() throws Exception {
		gen.influenza_epidemic();
		
		// PHA views diagnosis statistics for mumps
		// login PHA
		WebConversation wc = login("7000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - PHA Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 7000000001L, 0L, "");
				
		// click Diagnosis Trends
		wr = wr.getLinkWith("Diagnosis Trends").click();
		
		WebForm form = wr.getFormWithID("formSelectFlow");
		form.getScriptableObject().setParameterValue("viewSelect", "epidemics");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
				
		// View Trend
		form = wr.getFormWithID("formMain");
		form.getScriptableObject().setParameterValue("icdCode", "84.50");
		form.getScriptableObject().setParameterValue("zipCode", "27607");
		form.getScriptableObject().setParameterValue("startDate", "1/02/2012");
		form.getScriptableObject().setParameterValue("threshold", "");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
		
		assertTrue(wr.getText().contains("Please enter a threshold"));
	}
	
	/**
	 * Authenticate PHA
	 * MID 7000000001
	 * Password: pw
	 * Choose "Diagnosis Trends"
	 * Enter Fields:
	 * ICDCode: 84.50
	 * ZipCode: 27607
	 * StartDate: 1/02/2012
	 * Threshold: "abcd"
	 */
	public void testViewDiagnosisTrends_ThresholdAlpha() throws Exception {
		gen.influenza_epidemic();
		
		// PHA views diagnosis statistics for mumps
		// login PHA
		WebConversation wc = login("7000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - PHA Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 7000000001L, 0L, "");
				
		// click Diagnosis Trends
		wr = wr.getLinkWith("Diagnosis Trends").click();
		
		WebForm form = wr.getFormWithID("formSelectFlow");
		form.getScriptableObject().setParameterValue("viewSelect", "epidemics");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
				
		// View Trend
		form = wr.getFormWithID("formMain");
		form.getScriptableObject().setParameterValue("icdCode", "84.50");
		form.getScriptableObject().setParameterValue("zipCode", "27607");
		form.getScriptableObject().setParameterValue("startDate", "1/02/2012");
		form.getScriptableObject().setParameterValue("threshold", "abcd");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
		
		assertTrue(wr.getText().contains("Please enter a threshold"));
	}
	
	/**
	 * Authenticate PHA
	 * MID 7000000001
	 * Password: pw
	 * Choose "Diagnosis Trends"
	 * Enter Fields:
	 * ICDCode: 84.50
	 * ZipCode: 27607
	 * StartDate: 1/02/2012
	 * Threshold: "abcd"
	 */
	public void testViewDiagnosisTrends_ThresholdSymbols() throws Exception {
		gen.influenza_epidemic();
		
		// PHA views diagnosis statistics for mumps
		// login PHA
		WebConversation wc = login("7000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - PHA Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 7000000001L, 0L, "");
				
		// click Diagnosis Trends
		wr = wr.getLinkWith("Diagnosis Trends").click();
		
		WebForm form = wr.getFormWithID("formSelectFlow");
		form.getScriptableObject().setParameterValue("viewSelect", "epidemics");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
				
		// View Trend
		form = wr.getFormWithID("formMain");
		form.getScriptableObject().setParameterValue("icdCode", "84.50");
		form.getScriptableObject().setParameterValue("zipCode", "27607");
		form.getScriptableObject().setParameterValue("startDate", "1/02/2012");
		form.getScriptableObject().setParameterValue("threshold", "!@#$");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
		
		assertTrue(wr.getText().contains("Please enter a threshold"));
	}
	
	/**
	 * Authenticate PHA
	 * MID 7000000001
	 * Password: pw
	 * Choose "Diagnosis Trends"
	 * Enter Fields:
	 * ICDCode: 84.50
	 * ZipCode: 27607
	 * StartDate: 1/02/2012
	 * Threshold: "abcd"
	 */
	public void testViewDiagnosisTrends_GoodThreshold() throws Exception {
		gen.influenza_epidemic();
		
		// PHA views diagnosis statistics for mumps
		// login PHA
		WebConversation wc = login("7000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - PHA Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 7000000001L, 0L, "");
				
		// click Diagnosis Trends
		wr = wr.getLinkWith("Diagnosis Trends").click();
		
		WebForm form = wr.getFormWithID("formSelectFlow");
		form.getScriptableObject().setParameterValue("viewSelect", "epidemics");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
				
		// View Trend
		form = wr.getFormWithID("formMain");
		form.getScriptableObject().setParameterValue("icdCode", "84.50");
		form.getScriptableObject().setParameterValue("zipCode", "27607");
		form.getScriptableObject().setParameterValue("startDate", "1/02/2012");
		form.getScriptableObject().setParameterValue("threshold", "1");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-pha/viewDiagnosisStatistics.jsp", wr.getURL().toString());
		
		assertFalse(wr.getText().contains("Please enter a threshold"));
	}
}