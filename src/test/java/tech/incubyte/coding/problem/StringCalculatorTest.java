package tech.incubyte.coding.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
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
}
