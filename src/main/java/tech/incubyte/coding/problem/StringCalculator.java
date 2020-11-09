package tech.incubyte.coding.problem;


public class StringCalculator 
{
    

	public int add(String numbersGiven) {
		
		if (numbersGiven.isEmpty())
            return 0;
		else if(numbersGiven.length()==1){
            return Integer.parseInt(numbersGiven);
        }
		return -1;
	}
}
