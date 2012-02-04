package edu.ncsu.csc.itrust.http;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;
import edu.ncsu.csc.itrust.enums.TransactionType;

/**
 * Tests: When an HCP is entering height and weight data for a patient, the height and weight should both be greater than 0.  
 * However, entering a height and/or weight of 0 does not display a warning and saves the information (UC10).
 */
public class EditHeightRecordTest extends iTrustHTTPTest {
	
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
	 * Height: 0 inches
	 * Weight: 400 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testZeroIntHeight() throws Exception {
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
		form.setParameter("height", "0");
		form.setParameter("weight", "400");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Height: Up to 3-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 0.0 inches
	 * Weight: 400 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testZeroDoubleHeight() throws Exception {
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
		form.setParameter("height", "0.0");
		form.setParameter("weight", "400");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Height: Up to 3-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 1000.0 inches
	 * Weight: 10 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testTooLongLeftHeight() throws Exception {
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
		form.setParameter("height", "1000.0");
		form.setParameter("weight", "100");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Height: Up to 3-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 100.01 inches
	 * Weight: 100 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testTooLongRightHeight() throws Exception {
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
		form.setParameter("height", "100.01");
		form.setParameter("weight", "100");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Height: Up to 3-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 999.9 inches
	 * Weight: 10 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testMaxLengthHeight() throws Exception {
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
		form.setParameter("height", "999.9");
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
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: . inches
	 * Weight: 10.0 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testOnlyPeriodHeight() throws Exception {
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
		form.setParameter("height", ".");
		form.setParameter("weight", "10.0");
		form.setParameter("isSmoker", "1");
		form.setParameter("bloodPressureN", "999");
		form.setParameter("bloodPressureD", "000");
		form.setParameter("cholesterolHDL", "50");
		form.setParameter("cholesterolLDL", "200");
		form.setParameter("cholesterolTri", "200");
		form.getButtons()[0].click();
		WebResponse add = wc.getCurrentPage();
		assertTrue(add.getText().contains("Height: Up to 3-digit number + up to 1 decimal place"));
	}
	
	/**
	 * Authenticate HCP
	 * MID: 9000000000
	 * Password: pw
	 * Choose Edit Basic Health History
	 * enter 0000000002 and confirm
	 * Enter fields:
	 * Height: 70 inches
	 * Weight: 100.0 pounds
	 * Blood Pressure: 999/000
	 * Smokes: Y
	 * HDL: 50
	 * LDL: 200
	 * Triglycerides: 200
	 * Confirm and approve entries
	 * Cite: PHIRecordTest.java
	 */
	public void testIntHeight() throws Exception {
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
		form.setParameter("height", "70");
		form.setParameter("weight", "100.0");
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
