package tech.incubyte.coding.problem;


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
        
        inputNumbers = splitLogic(numbersGiven);
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] != null && !inputNumbers[i].isEmpty())
                    numbersSum += Integer.parseInt(inputNumbers[i]);
        }
        
        return numbersSum;
    }

    public String[] splitLogic(String numbersGiven) {
		if (numbersGiven.startsWith("//")) {
            Matcher matchDelimiters = Pattern.compile("//(.*)\n(.*)").matcher(numbersGiven);
            matchDelimiters.matches();
            String customDelimiter = matchDelimiters.group(1);
            String numbersInput = matchDelimiters.group(2);
            return numbersInput.split(customDelimiter);
        }
        return numbersGiven.split(",|\n");
    }
}
