package com.example.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PlayLottery 
{

  @Test
  public void play_lottery () throws IOException
  {
    PlayLottery play = new PlayLottery();
    play.setupLottery();
  }
  
  public void setupLottery() throws IOException
  {
    LotteryNumberGenerator generator = new LotteryNumberGenerator();
    LotteryNumberPicker picker = new LotteryNumberPicker();
    Set<Integer> generatedLotteryNumbers = generator.generateLotteryNumbers();
    Set<Integer> userLotteryNumbers = picker.promptUserForLotteryNumbers();
    
    System.out.print("Here are the lottery numbers: ");
    for (Integer generatedNumber : generatedLotteryNumbers)
    {
      System.out.print(generatedNumber + " ");
    }
    System.out.println();
    
    Set<Integer> matchedNumbers = playLottery(generatedLotteryNumbers, userLotteryNumbers);
    System.out.println("You matched " + matchedNumbers.size() + " number(s)");
    if (matchedNumbers.size() > 0)
    {
      System.out.print("Your matched numbers were: ");
      for (Integer matchedNumber : matchedNumbers)
      {
        System.out.print(matchedNumber + " ");
      }
    }
  }
  
  
  public Set<Integer> playLottery (Set<Integer> lotteryNumbers, Set<Integer> userNumbers)
  {
    Set<Integer> matchedNumbers = new HashSet<Integer>();
    
    for (Integer lotterynumber: lotteryNumbers)
    {
    	if (userNumbers.contains(lotterynumber))
    		matchedNumbers.add(lotterynumber);
    }
    
    return matchedNumbers;
  }
}
