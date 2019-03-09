package com.example.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LotteryNumberPicker {

	
	public Set<Integer> promptUserForLotteryNumbers() throws IOException 
	{
		Scanner in = new Scanner(System.in);
		Set<Integer> userInputNumbers;
		try 
		{
			userInputNumbers = new HashSet<Integer>();

			for (int i = 0; i < 6; i++) 
			{
				System.out.print("Please input a lottery number: ");
				userInputNumbers.add(in.nextInt());
			}
		} 
		finally 
		{
			in.close();
		}
		return userInputNumbers;
	}
}
