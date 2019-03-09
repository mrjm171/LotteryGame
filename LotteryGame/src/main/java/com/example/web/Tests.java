package com.example.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Tests {

  
  @Test
  public void should_return_a_set_of_6_numbers_with_no_duplicates ()
  {
    LotteryNumberGenerator sut = new LotteryNumberGenerator();
    
    for (int i=0; i<100000; i++) {
    	Set<Integer> lotteryNumbers = sut.generateLotteryNumbers();
    	assertThat(lotteryNumbers.size(), is(6));  	
    }
    
  }
  
  @Test
  public void generated_numbers_must_be_between_1_and_49 ()
  {
    LotteryNumberGenerator sut = new LotteryNumberGenerator();
    
    int lowest=49;
    int highest=1;
    
    for (int i=0; i<100000; i++)
    {
      Set<Integer> lotteryNumbers = sut.generateLotteryNumbers();
      for (Integer num : lotteryNumbers)
      {
        if (num < lowest)
        {
          lowest = num;
        }
        if (num > highest)
        {
          highest = num;
        }
      }
    }
    
    assertThat(highest, is(49));
    assertThat(lowest, is(1));
  }
  
  @Test
  public void should_match_numbers_properly ()
  {
    PlayLottery sut = new PlayLottery();
    Set<Integer> lotteryNumbers = new HashSet<Integer>(6);
    Set<Integer> userNumbers = new HashSet<Integer>(6);
    
    lotteryNumbers.add(1);lotteryNumbers.add(6);lotteryNumbers.add(8);lotteryNumbers.add(24);lotteryNumbers.add(35);lotteryNumbers.add(49);
    userNumbers.add(2);userNumbers.add(4);userNumbers.add(24);userNumbers.add(34);userNumbers.add(35);userNumbers.add(45);
    Set<Integer> matchedNumbers = sut.playLottery(lotteryNumbers, userNumbers);
    
    assertThat(matchedNumbers.size(), is(2));
    assertThat(matchedNumbers.contains(24), is(true));
    assertThat(matchedNumbers.contains(35), is(true));
    
  }
}
