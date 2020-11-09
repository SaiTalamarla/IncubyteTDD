package tech.incubyte.coding.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator 
{
    

	public int add(String numbersGiven) {
        
        if (numbersGiven.isEmpty())
            return 0;
        else 
            return sumOfNumbers(numbersGiven);

    }

    public int sumOfNumbers(String numbersGiven) {
        String[] inputNumbers = new String[numbersGiven.length()];
        int numbersSum = 0;
        List<String> negativeNum = new ArrayList<>();
        inputNumbers = splitLogic(numbersGiven);
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] != null && !inputNumbers[i].isEmpty()
					&& Integer.parseInt(inputNumbers[i]) < 1000){
                if (Integer.parseInt(inputNumbers[i]) < 0) {
                    negativeNum.add(inputNumbers[i]);
                }
                numbersSum += Integer.parseInt(inputNumbers[i]);
            }
                   
        }

        if (negativeNum.size() > 0) {
			StringBuilder negatives = new StringBuilder();
            for (String string : negativeNum) {
                negatives.append(string).append(" ");
            }
            throw new RuntimeException("negatives not allowed " + negativeNum.get(0)+ " ");
        }
        
        return numbersSum;
    }

    public String[] splitLogic(String numbersGiven) {
		Matcher matchDelimiters = Pattern.compile("//(.*)\n(.*)").matcher(numbersGiven);
        if (matchDelimiters.find()) {
            String customDelimiter = matchDelimiters.group(1);
            if (customDelimiter.startsWith("[")) {
                customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
            }
            String numbersInput = matchDelimiters.group(2);
            return numbersInput.split(
                    Stream.of(customDelimiter.split("]\\[")).map(Pattern::quote).collect(Collectors.joining("|")));
        }
                    return numbersGiven.split(",|\n");
    }
}
