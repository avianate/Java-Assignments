// Nate Graham	A00305171



import java.util.Scanner;


public class ArithmeticExpression {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int numberOfTestCases = input.nextInt();

		input.nextLine();

		// loop for each test case
		for (int testCase = 0; testCase < numberOfTestCases; testCase++)
		{
			// ArithemeticExpression myExpression = new ArithmeticExpression();

			// get string expression
			String equation = input.nextLine();

			// evaluate expression, checking for parentheses
			System.out.println(evaluate(equation));


			// perform operation
		}

	}

	private static String evaluate(String equation) {

		equation = evalParentheses(equation);

		if (equation.contains("*"))
			equation = evalMuliply(equation);

		else if (equation.contains("/"))
			equation = evalDivide(equation);

		else if (equation.contains("+"))
			equation = evalAdd(equation);

		else if (equation.contains("-"))
			equation = evalSubtract(equation);

		return equation;

	}


	private static String evalSubtract(String equation) 
	{	
		int index = 0;

		String values[] = equation.split(" ");

		for (int i = 0; i < values.length-1; i++)
		{
			if (values[i].equals("-"))
			{
				index = i;
				i = values.length;
			}
		}

		if (index <= 0)
		{
			return equation;
		}

			int value = Integer.parseInt(values[index-1]);
			value -= Integer.parseInt(values[index+1]);


		if (values.length-1 > index+2)
		{
			String newEquation = "";

			for (int i = index+2; i < values.length; i++)
			{
				newEquation += " " + values[i];
			}
			return evaluate((String.valueOf(value)) + newEquation);
		}
		else if (index-1 > 0)
		{
			String newEquation = "";

			for (int i = 0; i < index-1; i++)
			{
				newEquation += values[i] + " ";
			}
			return evaluate(newEquation + String.valueOf(value));
		}


		return String.valueOf(value);
	}

	private static String evalAdd(String equation) 
	{
		int index = 0;

		String values[] = equation.split(" ");

		for (int i = 0; i < values.length-1; i++)
		{
			if (values[i].equals("+"))
			{
				index = i;
				i = values.length;
			}
		}
		
		if (index <= 0)
		{
			return equation;
		}

		int value = Integer.parseInt(values[index-1]);
		value += Integer.parseInt(values[index+1]);

		if (values.length-1 > index+2)
		{
			String newEquation = "";

			for (int i = index+2; i < values.length; i++)
			{
				newEquation += " " + values[i];
			}

			return evaluate((String.valueOf(value)) + newEquation);
		}
		else if (index-1 > 0)
		{ 
			String newEquation =  "";

			for (int i = 0; i < index-1; i++)
			{
				newEquation += values[i] + " ";
			}
			return evaluate(newEquation + String.valueOf(value));
		}

		return (String.valueOf(value));
	}

	private static String evalDivide(String equation) {

		int index = 0;

		String values[] = equation.split(" ");

		for (int i = 0; i < values.length-1; i++)
		{
			if (values[i].equals("/"))
			{
				index = i;
				i = values.length;
			}
		}
		
		if (index <= 0)
		{
			return equation;
		}

		int numerator = Integer.parseInt(values[index-1]);
		int denominator = Integer.parseInt(values[index+1]);

		if (values.length-1 > index+2)
		{
			String newEquation = "";

			for (int i = index+2; i < values.length; i++)
			{
				newEquation += " " + values[i];
			}

			return evaluate((String.valueOf(rDivide(numerator, denominator, denominator))) + newEquation);
		}
		else if (index-1 > 0)
		{
			String newEquation = "";

			for (int i = 0; i < index-1; i++)
			{
				newEquation += values[i] + " ";
			}
			return evaluate(newEquation + String.valueOf(rDivide(numerator, denominator, denominator)));
		}

		return String.valueOf(rDivide (numerator, denominator, denominator));

	}


	private static int rDivide(int numerator, int denominator, int currentDenominator) 
	{
		if (currentDenominator == numerator)
			return 1;
		else if (currentDenominator > numerator)
			return 0;


		else
			return 1 + rDivide(numerator, denominator, currentDenominator+denominator);

	}





	private static String evalMuliply(String equation) 
	{
		int index = 0;

		String values[] = equation.split(" ");

		for (int i = 0; i < values.length-1; i++)
		{
			if (values[i].equals("*"))
			{
				index = i;
				i = values.length;
			}
		}

		if (index <= 0)
		{
			return equation;
		}
		
		int value = Integer.parseInt(values[index-1]);
		int count = Integer.parseInt(values[index+1]);

		if (values.length-1 > index+2)
		{
			String newEquation = "";

			for (int i = index+2; i < values.length; i++)
			{
				newEquation += " " + values[i];
			}

			return evaluate((String.valueOf(rMultiply(value, count))) + newEquation);
		}
		else if (index-1 > 0)
		{
			String newEquation = "";

			for (int i = 0; i < index-1; i++)
			{
				newEquation += values[i] + " ";
			}
			return evaluate(newEquation + String.valueOf(rMultiply(value, count)));
		}

		return String.valueOf(rMultiply(value, count));
	}



	private static int rMultiply(int value, int count) {

		if (count > 0)
			return value + rMultiply(value, count-1);
		else
			return 0;
	}





	private static String evalParentheses(String equation)
	{
		int openIndex = -1, closeIndex = -1;

		for (int i = 0; i < equation.length(); i++)
		{
			if (equation.charAt(i) == '(')
			{
				openIndex = i;
			}
			else if (equation.charAt(i) == ')')
			{
				closeIndex = i;
				i = equation.length();
			}
		}


		if (openIndex >= 0)
		{

			// opening parentheses at beginning && closing is not at the end
			if (openIndex == 0 && closeIndex < equation.length()-1)
			{
				String substring = evaluate(equation.substring(openIndex+1, closeIndex));
				String postfix = equation.substring(closeIndex+1);

				return evaluate(substring + postfix);
			}

			// opening parentheses at beginning && closing is at the end
			else if (openIndex == 0 && closeIndex == equation.length()-1)
				return evaluate(equation.substring(openIndex+1, closeIndex));

			// opening parentheses not at beginning && closing not at end
			else if (openIndex > 0 && closeIndex < equation.length()-1)
			{
				String substring = evaluate(equation.substring(openIndex+1, closeIndex));
				String prefix = equation.substring(0, openIndex);
				String postfix = equation.substring(closeIndex+1);

				return evaluate(prefix + substring + postfix);
			}

			// opening parentheses not at beginning && closing is at end
			else if (openIndex > 0 && closeIndex == equation.length()-1)
			{
				String substring = evaluate(equation.substring(openIndex+1, closeIndex));
				String prefix = equation.substring(0, openIndex);

				return evaluate(prefix + substring);
			}
		}

		return equation;

	}

}
