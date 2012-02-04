package edu.ncsu.csc.itrust.validate.bean;

import edu.ncsu.csc.itrust.beans.PatientBean;
import edu.ncsu.csc.itrust.validate.PatientValidator;
import junit.framework.TestCase;
import edu.ncsu.csc.itrust.exception.FormValidationException;

/*
 * Cite: PatientValidatorTest.java
 */
public class MIDFormatTest extends TestCase{
	
	public void testGoodParentMIDs() throws Exception {
		PatientBean p = new PatientBean();
		p.setFirstName("Person'a");
		p.setLastName("LastName");
		p.setDateOfBirthStr("10/10/2005");
		p.setDateOfDeathStr("");
		p.setCauseOfDeath("");
		p.setEmail("andy.programmer@gmail.com");
		p.setSecurityQuestion("'What is your quest?'-");
		p.setSecurityAnswer("I s33k the holy grail");
		p.setStreetAddress1("344 East Random Ave.");
		p.setStreetAddress2("");
		p.setCity("Intercourse");
		p.setState("PA");
		p.setZip1("17534");
		p.setPhone1("555");
		p.setPhone2("542");
		p.setPhone3("9023");
		p.setEmergencyName("Tow Mater");
		p.setEmergencyPhone1("809");
		p.setEmergencyPhone2("940");
		p.setEmergencyPhone3("1943");
		p.setIcName("Dewie Cheatum n Howe");
		p.setIcAddress1("458 Ripoff Blvd.");
		p.setIcAddress2("Greedy Suite");
		p.setIcCity("Hell");
		p.setIcState("MI");
		p.setIcZip1("48169");
		p.setIcZip2("0000");
		p.setIcPhone1("666");
		p.setIcPhone2("059");
		p.setIcPhone3("4023");
		p.setIcID("Money");
		p.setMotherMID("800");
		p.setFatherMID("700");
		p.setBloodTypeStr("O-");
		p.setEthnicityStr("Caucasian");
		p.setGenderStr("Male");
		p.setTopicalNotes("Here are some random topical notes. Isn't there more? Yes.\n There is.");
		p.setPassword("testpass1");
		p.setConfirmPassword("testpass1");
		try{
			new PatientValidator().validate(p);
		} catch(FormValidationException e){
			fail("Inbounds MIDs did not pass");
		}
	}
	
	public void testLeadingNineMotherMID() throws Exception {
		PatientBean p = new PatientBean();
		p.setFirstName("Person'a");
		p.setLastName("LastName");
		p.setDateOfBirthStr("10/10/2005");
		p.setDateOfDeathStr("");
		p.setCauseOfDeath("");
		p.setEmail("andy.programmer@gmail.com");
		p.setSecurityQuestion("'What is your quest?'-");
		p.setSecurityAnswer("I s33k the holy grail");
		p.setStreetAddress1("344 East Random Ave.");
		p.setStreetAddress2("");
		p.setCity("Intercourse");
		p.setState("PA");
		p.setZip1("17534");
		p.setPhone1("555");
		p.setPhone2("542");
		p.setPhone3("9023");
		p.setEmergencyName("Tow Mater");
		p.setEmergencyPhone1("809");
		p.setEmergencyPhone2("940");
		p.setEmergencyPhone3("1943");
		p.setIcName("Dewie Cheatum n Howe");
		p.setIcAddress1("458 Ripoff Blvd.");
		p.setIcAddress2("Greedy Suite");
		p.setIcCity("Hell");
		p.setIcState("MI");
		p.setIcZip1("48169");
		p.setIcZip2("0000");
		p.setIcPhone1("666");
		p.setIcPhone2("059");
		p.setIcPhone3("4023");
		p.setIcID("Money");
		p.setMotherMID("900");
		p.setFatherMID("700");
		p.setBloodTypeStr("O-");
		p.setEthnicityStr("Caucasian");
		p.setGenderStr("Male");
		p.setTopicalNotes("Here are some random topical notes. Isn't there more? Yes.\n There is.");
		p.setPassword("testpass1");
		p.setConfirmPassword("testpass1");
		try{
			new PatientValidator().validate(p);
			fail("Validate accepted a mother MID starting with a 9");
		} catch(FormValidationException e){
			assertEquals(p.getMotherMID(), "900");
		}
	}

	public void testLeadingNineFatherMID() throws Exception {
		PatientBean p = new PatientBean();
		p.setFirstName("Person'a");
		p.setLastName("LastName");
		p.setDateOfBirthStr("10/10/2005");
		p.setDateOfDeathStr("");
		p.setCauseOfDeath("");
		p.setEmail("andy.programmer@gmail.com");
		p.setSecurityQuestion("'What is your quest?'-");
		p.setSecurityAnswer("I s33k the holy grail");
		p.setStreetAddress1("344 East Random Ave.");
		p.setStreetAddress2("");
		p.setCity("Intercourse");
		p.setState("PA");
		p.setZip1("17534");
		p.setPhone1("555");
		p.setPhone2("542");
		p.setPhone3("9023");
		p.setEmergencyName("Tow Mater");
		p.setEmergencyPhone1("809");
		p.setEmergencyPhone2("940");
		p.setEmergencyPhone3("1943");
		p.setIcName("Dewie Cheatum n Howe");
		p.setIcAddress1("458 Ripoff Blvd.");
		p.setIcAddress2("Greedy Suite");
		p.setIcCity("Hell");
		p.setIcState("MI");
		p.setIcZip1("48169");
		p.setIcZip2("0000");
		p.setIcPhone1("666");
		p.setIcPhone2("059");
		p.setIcPhone3("4023");
		p.setIcID("Money");
		p.setMotherMID("800");
		p.setFatherMID("900");
		p.setBloodTypeStr("O-");
		p.setEthnicityStr("Caucasian");
		p.setGenderStr("Male");
		p.setTopicalNotes("Here are some random topical notes. Isn't there more? Yes.\n There is.");
		p.setPassword("testpass1");
		p.setConfirmPassword("testpass1");
		try{
			new PatientValidator().validate(p);
			fail("Validate accepted a father MID starting with a 9");
		} catch(FormValidationException e){
			assertEquals(p.getFatherMID(), "900");
		}
	}
	
	public void testLeadingNineParentMIDs() throws Exception {
		PatientBean p = new PatientBean();
		p.setFirstName("Person'a");
		p.setLastName("LastName");
		p.setDateOfBirthStr("10/10/2005");
		p.setDateOfDeathStr("");
		p.setCauseOfDeath("");
		p.setEmail("andy.programmer@gmail.com");
		p.setSecurityQuestion("'What is your quest?'-");
		p.setSecurityAnswer("I s33k the holy grail");
		p.setStreetAddress1("344 East Random Ave.");
		p.setStreetAddress2("");
		p.setCity("Intercourse");
		p.setState("PA");
		p.setZip1("17534");
		p.setPhone1("555");
		p.setPhone2("542");
		p.setPhone3("9023");
		p.setEmergencyName("Tow Mater");
		p.setEmergencyPhone1("809");
		p.setEmergencyPhone2("940");
		p.setEmergencyPhone3("1943");
		p.setIcName("Dewie Cheatum n Howe");
		p.setIcAddress1("458 Ripoff Blvd.");
		p.setIcAddress2("Greedy Suite");
		p.setIcCity("Hell");
		p.setIcState("MI");
		p.setIcZip1("48169");
		p.setIcZip2("0000");
		p.setIcPhone1("666");
		p.setIcPhone2("059");
		p.setIcPhone3("4023");
		p.setIcID("Money");
		p.setMotherMID("900");
		p.setFatherMID("900");
		p.setBloodTypeStr("O-");
		p.setEthnicityStr("Caucasian");
		p.setGenderStr("Male");
		p.setTopicalNotes("Here are some random topical notes. Isn't there more? Yes.\n There is.");
		p.setPassword("testpass1");
		p.setConfirmPassword("testpass1");
		try{
			new PatientValidator().validate(p);
			fail("Validate accepted a mother and father MID starting with a 9");
		} catch(FormValidationException e){
			assertEquals(p.getFatherMID(), "900");
			assertEquals(p.getMotherMID(), "900");
		}
	}
}
