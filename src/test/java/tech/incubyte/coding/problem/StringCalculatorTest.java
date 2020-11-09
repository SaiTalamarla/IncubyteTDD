package tech.incubyte.coding.problem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
	
	@Test
	public void add_UnKnownNumbers_ReturnsSumOfUnknownNumbers() {
		// Given
		String input = "1,2,3,4,5";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(15, resultObtained);
	}
	
	@Test
	public void add_UnKnownNumbersWithNewLineAsValid_ReturnsSumWithNewLine() {
		// Given
		String input = "1\n2,3,4,5";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(15, resultObtained);
	}
	
	@Test
	public void add_UnKnownNumbersStartsWithDelimiter_ReturnsSumIgnoringDelimiter() {
		// Given
		String input = "//;\n1;2";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(3, resultObtained);
	}
	
	@Test
	public void add_negativeNumber_ThrowsException() {
		// Given
		String input = "-1,2";
		// When
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			stringCalculator.add(input);
		});

		// Then
		assertEquals("negatives not allowed -1 ", e.getMessage());
	}
	
	@Test
	public void add_multipleNegativeNumber_ThrowsException() {
		// Given
		String input = "-1,-2,-3";
		// When
		RuntimeException e = assertThrows(RuntimeException.class, () -> {
			stringCalculator.add(input);
		});

		// Then
		assertEquals("negatives not allowed -1 -2 -3 ", e.getMessage());
	}
	
	@Test
	public void add_numbersGreaterThanThousand_ReturnsSumOfNumsLessthanThousand() {
		// Given
		String input = "2,1000";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(2, resultObtained);
	}
	
	@Test
	public void add_UnKnownNumbersWithUnknownDelimiter_ReturnsSumIgnoringDelimiter() {
		// Given
		String input = "//[***]\n1***2***3";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(6, resultObtained);
	}
	
	@Test
	public void add_UnKnownNumbersWithMultipleDelimiter_ReturnsSumIgnoringDelimiter() {
		// Given
		String input = "//[*][%]\n1*2%3";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(6, resultObtained);
	}
	
	@Test
	public void add_withMultipleDelimiter_ReturnsSumIgnoringDelimiter() {
		// Given
		String input = "//[**][%%]\n1**2%%3";
		// When
		int resultObtained = stringCalculator.add(input);
		// Then
		assertEquals(6, resultObtained);
	}
	
	@AfterAll
    @Test
    public static void addInvokedCount(){

        int result = StringCalculator.getAddCount();
        assertEquals(12, result);
    }
}
