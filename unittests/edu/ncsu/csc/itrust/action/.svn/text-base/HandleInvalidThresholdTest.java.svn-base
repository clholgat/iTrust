package edu.ncsu.csc.itrust.action;

import java.util.Calendar;
import junit.framework.TestCase;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

/**
 * Cite: ViewDiagnosisStatisticsActionTest.java
 * Author: Daniel Farrell
 * Goal: Test getEpidemicStatistics, which is called right after input from viewEpidemics.jsp is taken in. 
 * Input will be checked, and a FormValidationException will be thrown if the input is invalid. 
 * FormValidationException being thrown results in a nice message being given to the user, not an exception splat. 
 */
public class HandleInvalidThresholdTest extends TestCase{
	
	private TestDataGenerator gen = new TestDataGenerator();
	private ViewDiagnosisStatisticsAction action;
	
	private int thisYear = Calendar.getInstance().get(Calendar.YEAR);
	
	@Override
	protected void setUp() throws Exception {
		gen.clearAllTables();
		gen.standardData();
		gen.patient_hcp_vists();
		gen.hcp_diagnosis_data();
		
		action = new ViewDiagnosisStatisticsAction(TestDAOFactory.getTestInstance());
	}
	
	/**
	 * Input to threshold field: ""
	 * Expected result: FormValidationException thrown
	 */
	public void testNullThreshold() throws Exception {
		gen.malaria_epidemic();
		try{
			action.getEpidemicStatistics("11/02/" + thisYear, "84.50", "27606", "");
			fail("Should throw exception with null threshold");
		} catch(FormValidationException e){
			//Test passes
		}
	}
	
	/**
	 * Input to threshold field: "abcd"
	 * Expected result: FormValidationException thrown
	 */
	public void testAlphaThreshold() throws Exception {
		gen.malaria_epidemic();
		try{
			action.getEpidemicStatistics("11/02/" + thisYear, "84.50", "27606", "abcd");
			fail("Should throw exception with alph threshold");
		} catch(FormValidationException e){
			//Test passes
		}
	}
	
	/**
	 * Input to threshold field: "1"
	 * Expected result: No exception thrown
	 */
	public void testGoodInput() throws Exception {
		gen.malaria_epidemic();
		try{
			action.getEpidemicStatistics("11/02/" + thisYear, "84.50", "27606", "1");
		} catch(FormValidationException e){
			fail("Should not throw exception with good input");
		}
	}
	
	/**
	 * Input to threshold field: "%$@!"
	 * Expected result: FormValidationException thrown
	 */
	public void testSymbolThreshold() throws Exception {
		gen.malaria_epidemic();
		try{
			action.getEpidemicStatistics("11/02/" + thisYear, "84.50", "27606", "%$@!");
			fail("Should throw exception with symbol threshold");
		} catch(FormValidationException e){
			//Test passes
		}
	}
}
