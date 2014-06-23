package com.questions.geeksforgeeks;

public class FormalizeText {
	
	
	public final int MAX_STR_LEN = 1024;
	public final int MAX_TEST_CASES = 5;

	

	
	public final static String[][] rules = { 
						{ "hru", "how are you"},
						{ "ur", "your"},
						{ "u", "you"},
						{ "r", "are"},
						{ "d", "the"},
						{ "2", "to"},
						{ "nt", "not"},
						{ "dis", "this"},
						{ "diff", "difference"},
						{ "are not", "aren't"},
						{ "is not", "isn't"},
						{ "", ""}
					   };
	
	public final static String input[] = {
			"Hru ? wanted 2 inform u that we r nt coming 2 ur place dis Sunday !",
			"these r nt ur pair of socks. they r mine.D diff is hardly noticable.",
			"Hey! This sentence is perfectly fine!  ",
			"SPOT D DIFF.",
			"'We may have all come on DiFF ships, but we r in d same boat now'. Dis sentence is nt correct. Change 'diff' 2 'different'!"
			};

	public final static String verification[] = {
			"How are you ? Wanted to inform you that we aren't coming to your place this Sunday !",
			"These aren't your pair of socks. They are mine.The difference is hardly noticable.",
			"Hey! This sentence is perfectly fine!  ",
			"SPOT the difference.",
			"'We may have all come on difference ships, but we are in the same boat now'. This sentence isn't correct. Change 'difference' to 'different'!"
			};
	
	static String formalize(final String input, final String[][] rules, String output)
	{
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.toLowerCase().charAt(i);
			
			switch (c) {
			
			case 'h':
				if (input.toLowerCase().charAt(i+1) == 'r' && input.toLowerCase().charAt(i+2) == 'u' && input.toLowerCase().charAt(i+3) == ' ')
					{
						output = output+"how are you";
						i += 3;
					}
				break;
				
			case 'u':
				if (input.toLowerCase().charAt(i+1) == ' ')
				{
					output = output+"you";
					i += 1;
				}
				else if (input.toLowerCase().charAt(i+1) == 'r' && input.toLowerCase().charAt(i+2) == ' ')
				{
					output = output+"your";
					i += 2;
				}
				break;
				
			case 'r':
				if (input.toLowerCase().charAt(i+1) == ' ' && input.toLowerCase().charAt(i-1) == ' ' && input.toLowerCase().charAt(i+2) == 'n' && input.toLowerCase().charAt(i+3) == 't' && input.toLowerCase().charAt(i+4) == ' ')
				{
					output = output+"aren't";
					i += 4;
				}
				else if (input.toLowerCase().charAt(i+1) == ' ' && input.toLowerCase().charAt(i-1) == ' ')
				{
					output = output+"are";
					i += 1;
				}
				break;
	
			case 'd':
				if (input.toLowerCase().charAt(i+1) == 'i' && input.toLowerCase().charAt(i+2) == 's' && input.toLowerCase().charAt(i+3) == ' ')
				{
					output = output+"this";
					i += 3;
				}
				else if (input.toLowerCase().charAt(i+1) == ' ' && (input.toLowerCase().charAt(i-1) == ' ' || input.toLowerCase().charAt(i-1) == '.'))
				{
					output = output+"the";
					i += 1;
				}
				else if (input.toLowerCase().charAt(i+1) == 'i' && input.toLowerCase().charAt(i+2) == 'f' && input.toLowerCase().charAt(i+3) == 'f' && (input.toLowerCase().charAt(i+4) == ' ' || input.toLowerCase().charAt(i+4) == '.' || input.toLowerCase().charAt(i+5) == ' '))
				{
					output = output+"difference";
					i += 4;
				}
					break;
			case '2':
				if (input.toLowerCase().charAt(i+1) == ' ')
					{
						output = output+"to";
						i += 1;
					}
				break;
				
			case 'n':
				if (input.toLowerCase().charAt(i+1) == 't' && input.toLowerCase().charAt(i+2) == ' ')
				{
					i += 2;
					output = output+"not";
				}
				break;
				
			case 'i':
				if (input.toLowerCase().charAt(i+1) == 's' && input.toLowerCase().charAt(i+2) == ' '
					&& input.toLowerCase().charAt(i+3) == 'n' && input.toLowerCase().charAt(i+4) == 't' && input.toLowerCase().charAt(i+5) == ' ')
				{
					i += 5;
					output = output+"isn't";
				}
				
				break;
			}
			output = output+input.charAt(i);
		}
		
		return format(output);
		
	}
	
	public static String format (String op)
	{
		String str="";
		for (int i = 0; i < op.length(); i++)
		{
			char c = op.charAt(i);
			
			
			switch (c) 
			{
				case '.':
					if (i < op.length() - 2)
					{
						if (op.toLowerCase().charAt(i+1) == ' ' )
						{
							char c1 = Character.toUpperCase(op.charAt(i + 2));
							i += 3;
							str = str +c+" "+c1 ;
						}
						else
						{
							char c1 = Character.toUpperCase(op.charAt(i + 1));
							i += 2;
							str = str +c+c1 ;
						}
					}
					break;
					
				case '?':
					if (i < op.length() - 2)
					{
						if (op.toLowerCase().charAt(i+1) == ' ' )
						{
							char c1 = Character.toUpperCase(op.charAt(i + 2));
							i += 3;
							str = str +c+" "+c1 ;
						}
						
					}
					break;
	
				default:
					break;
			}
			if (i == 0)
			{
				str = str + Character.toUpperCase(op.charAt(i));
			}
			else	
				str = str+op.charAt(i);
		}
		return str;
	}
	
	public static void main (String args[])
	{
		int i = 0;
		String output_string = "";
		
//		formalize(input[0], rules, output_string);
//		formalize(input[1], rules, output_string);
//		formalize(input[2], rules, output_string);
//		formalize(input[3], rules, output_string);
//		formalize(input[4], rules, output_string);
		
		for (i = 0; i < 5; i++) {
			
			String str = formalize(input[i], rules, output_string);
			if (str.equals(verification[i]))
				System.out.println("pass !");
			else
			{
				System.out.println("fail at "+i);
				break;
			}
		}
		
	}

}
