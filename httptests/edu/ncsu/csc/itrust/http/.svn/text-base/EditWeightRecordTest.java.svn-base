package edu.ncsu.csc.itrust.http;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;
import edu.ncsu.csc.itrust.enums.TransactionType;

/**
 * Tests: When an HCP is entering height and weight data for a patient, the height and weight should both be greater than 0.  
 * However, entering a height and/or weight of 0 does not display a warning and saves the information (UC10).
 */
public class EditWeightRecordTest extends iTrustHTTPTest {
	
	/**
	 * Setup tests
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		gen.uap1();
		gen.patient2();
		gen.patient1();
		gen.patient4();
		gen.hcp0();
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 10 inches
	 * Weight: 0 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testZeroIntWeight() throws Exception {
		// login hcp
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L,"");
		
		// click Edit Basic Health Information
		wr = wr.getLinkWith("Basic Health Information").click();
		assertEquals(ADDRESS + "auth/getPatientID.jsp?forward=hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_VIEW, 9000000000L, 2L,"");
		
		// add a new record
		WebForm form = wr.getForms()[0];
		form.getButtons()[0].click();
		form.setParameter("height", "10");
		form.setParameter("weight", "0");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Weight: Up to 4-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 10 inches
	 * Weight: 0.0 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testZeroDoubleWeight() throws Exception {
		// login hcp
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L,"");
		
		// click Edit Basic Health Information
		wr = wr.getLinkWith("Basic Health Information").click();
		assertEquals(ADDRESS + "auth/getPatientID.jsp?forward=hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_VIEW, 9000000000L, 2L,"");
		
		// add a new record
		WebForm form = wr.getForms()[0];
		form.getButtons()[0].click();
		form.setParameter("height", "10");
		form.setParameter("weight", "0.0");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Weight: Up to 4-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 10.0 inches
	 * Weight: 10000.0 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testTooLongLeftWeight() throws Exception {
		// login hcp
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L,"");
		
		// click Edit Basic Health Information
		wr = wr.getLinkWith("Basic Health Information").click();
		assertEquals(ADDRESS + "auth/getPatientID.jsp?forward=hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_VIEW, 9000000000L, 2L,"");
		
		// add a new record
		WebForm form = wr.getForms()[0];
		form.getButtons()[0].click();
		form.setParameter("height", "10.0");
		form.setParameter("weight", "10000.0");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Weight: Up to 4-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 10.0 inches
	 * Weight: 100.01 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testTooLongRightWeight() throws Exception {
		// login hcp
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L,"");
		
		// click Edit Basic Health Information
		wr = wr.getLinkWith("Basic Health Information").click();
		assertEquals(ADDRESS + "auth/getPatientID.jsp?forward=hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_VIEW, 9000000000L, 2L,"");
		
		// add a new record
		WebForm form = wr.getForms()[0];
		form.getButtons()[0].click();
		form.setParameter("height", "10.0");
		form.setParameter("weight", "100.01");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Weight: Up to 4-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 10.0 inches
	 * Weight: 9999.9 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testMaxLengthWeight() throws Exception {
		// login hcp
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L,"");
		
		// click Edit Basic Health Information
		wr = wr.getLinkWith("Basic Health Information").click();
		assertEquals(ADDRESS + "auth/getPatientID.jsp?forward=hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_VIEW, 9000000000L, 2L,"");
		
		// add a new record
		WebForm form = wr.getForms()[0];
		form.getButtons()[0].click();
		form.setParameter("height", "10.0");
		form.setParameter("weight", "9999.9");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Information Recorded"));
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_EDIT, 9000000000L, 2L,"");
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 70.0 inches
	 * Weight: 100 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testIntWeight() throws Exception {
		// login hcp
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - HCP Home", wr.getTitle());
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L,"");
		
		// click Edit Basic Health Information
		wr = wr.getLinkWith("Basic Health Information").click();
		assertEquals(ADDRESS + "auth/getPatientID.jsp?forward=hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		// choose patient 2
		WebForm patientForm = wr.getForms()[0];
		patientForm.getScriptableObject().setParameterValue("UID_PATIENTID", "2");
		patientForm.getButtons()[1].click();
		wr = wc.getCurrentPage();
		assertEquals(ADDRESS + "auth/hcp-uap/editBasicHealth.jsp", wr.getURL().toString());
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_VIEW, 9000000000L, 2L,"");
		
		// add a new record
		WebForm form = wr.getForms()[0];
		form.getButtons()[0].click();
		form.setParameter("height", "70.0");
		form.setParameter("weight", "100");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Information Recorded"));
		assertLogged(TransactionType.PATIENT_HEALTH_INFORMATION_EDIT, 9000000000L, 2L,"");
	}
	
	

}
