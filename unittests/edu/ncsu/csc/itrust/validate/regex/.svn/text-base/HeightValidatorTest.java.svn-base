package edu.ncsu.csc.itrust.validate.regex;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.testutils.ValidatorProxy;
import edu.ncsu.csc.itrust.validate.ValidationFormat;

public class HeightValidatorTest extends TestCase{
	private ValidatorProxy validatorProxy = new ValidatorProxy();
	private static final ValidationFormat VALIDATION_FORMAT = ValidationFormat.Height;
	private static final String PASSED = "";
	private static final String FAILED = "Height: " + VALIDATION_FORMAT.getDescription();

	public void testDecimalZero() throws Exception {//Fails
		String value = "0.0";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}

	public void testIntZero() throws Exception {
		String value = "0";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}

	public void testInt() throws Exception {//Fails
		String value = "7";
		String errorMessage = PASSED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testDecimal() throws Exception {
		String value = "7.7";
		String errorMessage = PASSED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testIntLeadingZeros() throws Exception {//Fails
		String value = "01";
		String errorMessage = PASSED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testDecimalLeadingZeros() throws Exception {
		String value = "01.1";
		String errorMessage = PASSED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testNegitiveInt() throws Exception {
		String value = "-1";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testNegitiveDecimal() throws Exception {
		String value = "-4.3";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testOnlyPoint() throws Exception {
		String value = ".";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testTooManyLeft() throws Exception {
		String value = "1000.0";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testMax() throws Exception {
		String value = "999.9";
		String errorMessage = PASSED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
	
	public void testToManyRight() throws Exception {
		String value = "0.01";
		String errorMessage = FAILED;
		assertEquals(errorMessage, validatorProxy.checkFormat("Height", value, VALIDATION_FORMAT, false));
	}
}
