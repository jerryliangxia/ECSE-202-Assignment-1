import acm.program.ConsoleProgram;

//ID 260917329 | Jerry Xia
//example in assignment PDF was used throughout writing this program for assistance
public class baseConv extends ConsoleProgram
{

	public int StringtoBase10(String ourString, int base) //1st method. Converts string entered by user to a decimal (base 10).
	{
		int numBase10 = 0; 									//Initializing the integer numBase10 to 0. numBase10 will
															//represent the decimal value that will be returned at the end
															//of the method.
		
		for(int i =0; i < ourString.length(); i++)			//Setting up a loop here (with a for statement) so
		{													//that it processes every character from the user's string input
			
			char current = ourString.charAt(i);				//Defining the variable char as current, and using the
															//charAt() method to get the character from the string.
			
			int value = 0;									//initializing integer 'value' which will be used later in
															//the program; in particular, setting characters to integers
															//(can be seen below in the if statements)

			if (base > 10)									//I used two if statements; if the base is more than 10 then the
															//characters from a to f will be used (as these characters exceed
															//the range [0,9] to compute the decimal value.
			{
				if(current == 'a')					//I used several if statements to change the character to an integer in
				{									//base 10. These range from 10 to 15, for a to f respectively.
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
				if(current == 'f')					//Now that each element of the string 'a' through 'f' is set to a 
				{									//an integer value, we set up the following if statements below.
					value = 15;
				}
				
		if(current >= 'a')	//Setting up the if statement with the character 'a'. which is now assigned an integer value.
			{
				int value1 = (current - 'a' + 10)*(int) Math.pow(base, (ourString.length()-i-1));
				numBase10 += value1;}
		
		/*In the above code, I set a new value 'value1' that will be added to the total 'numBase10', which essentially
		 * converts the string of characters to decimal. In the above code, each character is
		 * now converted to an integer by subtracting 'a' (as the ASCII value
		 * of a is actually 49, subtracting 'a' means to initialize it to 0). Adding 10 will give the integer it's value
		 * in decimal, such that a = 10, b = 11, c = 12, etc. As the for loop continues, the total
		 * numBase10 will finish (the variable i will equal ourString.length()) and the string will now be in base 10/
		 * decimal form.
		 */

		if(current < 'a')				//this code applies for any character that is in the range of [0,9].
			{								//it follows similar logic to the if statement above but does not require the 
										//(-10) as it is not in the range of [a,f].
			
				int value1 = (current - '0')*(int) Math.pow(base, (ourString.length()-i-1));
				numBase10 += value1;
			}
		}

		if (2 <= base && base <= 10)					//This following code applies for the bases between 2 and 10.
			{
				int value1 = (current - '0')*(int) Math.pow(base, (ourString.length()-i-1));
				numBase10 += value1;
			}

		}
			return numBase10;		//this method must return an integer. This integer is the decimal number we obtained
									//from the string that was initially entered from the user.
}
	
	public String Base10toNewBase(int numBase10, int targetBase) //2nd method. Converts from decimal to the target base
																 //that was prompted by the user.
	{
		String newNum = "";							//Set the string newNum, which will be the decimal number we obtained from
													//the 1st method, to an initial condition of "".
		
		while(numBase10 != 0)				//While loop that performs operations with the integer in decimal form. When the
											//loop reaches 0 the loop ends.
		{
			char digit = '0';		//initialize char digit to '0', which will be [0,9] and [a,f]. char is used in this loop
									//to form the string newNum, which will be our original input in the target base.
			
			int remainder = numBase10 % targetBase;
			numBase10 /= targetBase;
			
	/*Above, we take the modular of numBase10 and the targetBase to get the integer remainder, which we convert
	 *to the character in the range [0.9] and [a,f] that will form the basis for our string newNum. (Seen below in 
	 *if statements)
	 *
	 *numBase10 is then divided by targetBase, both of which are integers, to produce numBase10, which is less
	 *than the previous iteration. Let's review the code below now, to see what happens with the remainder.
	 *
	 *The remainder, if between 0 and 9, is inserted into a statement that casts to type char with the addition operator +. 
	 *Meanwhile if the remainder is greater than or equal to 10, the digit undergoes a similar process to that in method 1.
	 *Basically, it is converted to a character, with 10 = 'a', 11 = 'b', etc. until f = '15'.
	 */
			
			if (0 <= remainder && remainder <=9)
			{
				digit = (char) (remainder + '0');
			}
			else if (remainder >= 10)
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
			newNum = newNum + digit;		//with each iteration, a char is added on forming the final string newNum.
		}
		
		/*However, unfortunately, this string is backwards. So in order to reverse this we use the following for loop
		 * below. 
		 */
		
		String newNum2 = "";			//initializing String newNum2, which will be our new string that we will print
										//out at the end of the program.
		
		for(int i = newNum.length()-1; i >= 0; i--) 	//in this case, instead of newNum.length() we write
														//newNum.length()-1 because the loop will start with i = 0.
														//(as these are the initial conditions for i)
			
	/* The integer i will increment by -1 each time and thus, will give the last character of the string and print it out first.
	 * This will continue until the entire string is processed through the for loop.
	 */
		{
			newNum2 = newNum2 + newNum.charAt(i);	//The new string is printed out, now in the correct order.
		}
		return newNum2;								//returns string newNum2 to method 2, which can now be called by
													//the main method.
	}

	public void run() //main method
	{		
			println("Base conversion program");		//Identifies program.
			println("");							//Adds space (just for aesthetic)
			while (true)
			{
				String input = readLine("Enter a number (Base 2-16): ");		//reads input as a string.

				if(input.equals(""))											//exits if the user enters in a blank.
				{
					println("");
					println("Program terminated.");			 //if this is the case, the program states that it is terminated.
					break;
				}
				
				int base = readInt("Enter the corresponding base as an integer: "); 		//reads input as an integer.
				
				if(base < 2 || base > 16)						//tests to ensure that the integer is between base 2 and 16.
				{
					println("Error: must be between 2 and 16.");
					println("");
					println("Program terminated"); 				//terminates program if the above comment isn't the case.
					break;
				}
				
				int numBase10 = StringtoBase10(input, base);		//reads input as an integer, and takes in the base as well,
																	//and refers to the 1st method.
				
				println("The decimal equivalent of your input is "+numBase10);		//states the number in base 10/decimal.
				
				/*the below code prompts the user for a new base, referred to in the code as targetBase. It then commences
				 * another test, similar to the one above, to see if it fits the criteria of the program (by seeing if it's
				 * between base 2 and 16) 
				 */

				int targetBase = readInt("Enter the target base for conversion (Base 2-16): ");
				if(targetBase < 2 || targetBase > 16)
				{
					println("Error: must be between 2 and 16.");
					println("");
					println("Program terminated");		//again, exits program if the base is not [2, 16]
					break;
				}
				
				String newNum = Base10toNewBase(numBase10, targetBase);
				println(""+input+" Base-"+base+" ---> "+newNum+" Base-"+targetBase);
				println("");
				
			/* this last bit of code prints out the original input, the base it was in, and states the output in the
			 * target base. End of program.			 * 
			 */
			}
		}

	

	
}