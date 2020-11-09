package tech.incubyte.coding.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest 
{
	
	private static StringCalculator stringCalculator;

	@BeforeEach	
	public void setupObject() {
		stringCalculator = new StringCalculator();
	}
	
	@Test
	public void add_EmptyString_ReturnsZero() {
		// Given
		String input = "";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(0, resultObtained);
	}
	
	@Test
	public void add_SingleNumber_ReturnsSameNumber1() {
		// Given
		String input = "1";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(1, resultObtained);
	}
	
	@Test
	public void add_TwoNumbers_ReturnsSumOfTwoNumber1() {
		// Given
		String input = "1,2";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(3, resultObtained);
	}
}
