import acm.program.ConsoleProgram;

public class baseConversion extends ConsoleProgram
{

	public int StringtoBase10(String ourString, int base)
	{
		int numBase10 = 0;
		for(int i =0; i < ourString.length(); i++)
		{
			char current = ourString.charAt(i);

			int value = 0;

			if (base > 10)
			{
				if(current == 'a')
				{
					value = 10;
				}
				if(current == 'b')
				{
					value = 11;
				}
				if(current == 'c')
				{
					value = 12;
				}
				if(current == 'd')
				{
					value = 13;
				}
				if(current == 'e')
				{
					value = 14;
				}
				if(current == 'f')
				{
					value = 15;
				}
				
		if(current >= 'a') 
			{
				int value1 = (current - 'a' + 10)*(int) Math.pow(base, (ourString.length()-i-1));
				numBase10 = numBase10 + value1;}
		
		if(current < 'a') 
			{
				int value1 = (current - '0')*(int) Math.pow(base, (ourString.length()-i-1));
				numBase10 = numBase10 + value1;}
			}

		if (base <= 10) 
			{
				int value1 = (current - '0')*(int) Math.pow(base, (ourString.length()-i-1));
				numBase10 = numBase10 + value1;
			}

		}
			return numBase10;

}
	
	public String Base10toNewBase(int numBase10, int targetBase)
	{
		String newNum = "";
		
		while(numBase10 != 0)
		{
			char digit = '0';
			int remainder = numBase10 % targetBase;
			numBase10 = numBase10 / targetBase;
			
			if (0 <= remainder && remainder <=9)
			{
				digit = (char) (remainder + '0');
			}
			else if (remainder > 10)
			{
				if (remainder == 10)
				{
					digit = 'a';
				}
				if (remainder == 11)
				{
					digit = 'b';
				}
				if (remainder == 12)
				{
					digit = 'c';
				}
				if (remainder == 13)
				{
					digit = 'd';
				}if (remainder == 14)
				{
					digit = 'e';
				}
				if (remainder == 15)
				{
					digit = 'f';
				}
				
			}
			newNum = newNum + digit;
		}
		String newNum2 = "";
		for(int i = newNum.length()-1; i >= 0; i--)
		{
			newNum2 = newNum2 + newNum.charAt(i);
		}
		return newNum2;
	}

	public void run()
	{

		{
			println("Base conversion program");
			println("");
			while (true)
			{
				String input = readLine("Enter a number (Base 2-16): ");

				if(input.equals(""))
				{
					println("");
					println("Program terminated.");
					break;
				}
				
				int base = readInt("Enter in the corresponding base as an integer: ");
				
				if(base < 2 || base > 16)
				{
					println("Error: must be between 2 and 16.");
					println("");
					println("Program terminated");
					break;
				}
				
				
				if(base >= 2 && base <= 16)
				{
					char chDigit = '0';
					for(int i = 0; i < input.length(); i++)
					{
						if(Character.isDigit(chDigit) && chDigit - '0' >= base)
						{
							println("Cannot have " +chDigit+ " in base " +base+ ".");
							break;
						}
						else if(Character.isLetter(chDigit) && chDigit - 'a' + 10 >= base)
						{
							println("Cannot have " +chDigit+ " in base " +base+ ".");
							break;
						}
					}
					//if current char = 
					
				}
				
				int numBase10 = StringtoBase10(input, base);
				println("The decimal equivalent of your input is "+numBase10);
				
				
				int targetBase = readInt("Enter in a new base: ");
				if(targetBase < 2 || targetBase > 16)
				{
					println("Error: must be between 2 and 16.");
					println("");
					println("Program terminated");
					break;
				}
				
				String newNum = Base10toNewBase(numBase10, targetBase);
				println("Your new number is "+newNum);
			}
		}

	}

	
}
