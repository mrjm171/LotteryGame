package com.example.web;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotteryNumberGenerator 
{

 
  public Set<Integer> generateLotteryNumbers ()
  {
	   Set<Integer> randomNumbers = new HashSet<Integer>();
	   Random random = new Random();
	   for(int i=0; i<6; i++)
		   while(!randomNumbers.add(random.nextInt(49)+1));
	   return randomNumbers;
  }
}
