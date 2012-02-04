package edu.ncsu.csc.itrust.http;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;
import edu.ncsu.csc.itrust.enums.TransactionType;

/**
 * This tests to make sure the provided MID a non-staff does not start with a 9
 * Cite: EditDemographicsTest.java
 */
public class MIDFormatTest extends iTrustHTTPTest{

	
	@Override
	/**
	 * Setup the tests
	 */
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		gen.hcp1();
		gen.patient2();
		gen.icd9cmCodes();
		gen.uap1();
		gen.patient2();
		gen.patient1();
		gen.patient4();
		gen.hcp0();
	}

	@Override
	/**
	 * Clear tables after the tests
	 */
	protected void tearDown() throws Exception {
		gen.clearAllTables();
	}

	/**
	 * Authenticate HCP 1
	 * MID: 9000000000
	 * Password: pw
	 * Choose Patient Information
	 * Select patient 2 and confirm.
	 * Change Field:
	 * Mother MID: 900
	 * Confirm and approve the selection
	 */
	public void testLeadingNineMotherMID() throws Exception {
		// login uap
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		// choose "Patient Information"
		wr = wr.getLinkWith("Patient Information").click();
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editPatient.jsp", wr.getURL().toString());
		
		// update street address to be blank
		WebForm form = wr.getForms()[0];
		form.setParameter("motherMID", "900");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Between 1 and 10 digits not starting with a 9"));
		assertNotLogged(TransactionType.DEMOGRAPHICS_EDIT, 9000000000L, 2L, "");
	}
	
	/**
	 * Authenticate HCP 1
	 * MID: 9000000000
	 * Password: pw
	 * Choose Patient Information
	 * Select patient 2 and confirm.
	 * Change Field:
	 * Father MID: 900
	 * Confirm and approve the selection
	 */
	public void testLeadingNineFatherMID() throws Exception {
		// login uap
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		// choose "Patient Information"
		wr = wr.getLinkWith("Patient Information").click();
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editPatient.jsp", wr.getURL().toString());
		
		// update street address to be blank
		WebForm form = wr.getForms()[0];
		form.setParameter("fatherMID", "900");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Between 1 and 10 digits not starting with a 9"));
		assertNotLogged(TransactionType.DEMOGRAPHICS_EDIT, 9000000000L, 2L, "");
	}
	
	/**
	 * Authenticate HCP 1
	 * MID: 9000000000
	 * Password: pw
	 * Choose Patient Information
	 * Select patient 2 and confirm.
	 * Change Field:
	 * Mother MID: 900
	 * Father MID: 900
	 * Confirm and approve the selection
	 */
	public void testLeadingNineParentMIDs() throws Exception {
		// login uap
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		// choose "Patient Information"
		wr = wr.getLinkWith("Patient Information").click();
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editPatient.jsp", wr.getURL().toString());
		
		// update street address to be blank
		WebForm form = wr.getForms()[0];
		form.setParameter("motherMID", "900");
		form.setParameter("fatherMID", "900");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Between 1 and 10 digits not starting with a 9"));
		assertNotLogged(TransactionType.DEMOGRAPHICS_EDIT, 9000000000L, 2L, "");
	}
	
	/**
	 * Authenticate HCP 1
	 * MID: 9000000000
	 * Password: pw
	 * Choose Patient Information
	 * Select patient 2 and confirm.
	 * Change Field:
	 * Mother MID: 800
	 * Father MID: 600
	 * Confirm and approve the selection
	 */
	public void testGoodMIDs() throws Exception {
		// login uap
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		// choose "Patient Information"
		wr = wr.getLinkWith("Patient Information").click();
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editPatient.jsp", wr.getURL().toString());
		
		// update street address to be blank
		WebForm form = wr.getForms()[0];
		form.setParameter("motherMID", "800");
		form.setParameter("fatherMID", "600");
		form.getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Information Successfully Updated"));
		assertLogged(TransactionType.DEMOGRAPHICS_EDIT, 9000000000L, 2L, "");
	}
}
