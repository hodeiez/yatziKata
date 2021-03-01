package com.king.kata.yatzy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

	private YatzyScorer yatzyScorer;

	@BeforeEach
	public void setUp() {
		yatzyScorer = new YatzyScorer();
	}

	@Test
	public void chanceScoresCorrectly() {
		int score = yatzyScorer.calculateScore(Category.CHANCE, new YatzyRoll(5, 2, 1, 4, 6));
		assertEquals(18, score);
	}
	@Test
	public void SumAll(){
		YatzyRoll roll=new YatzyRoll(1,2,3,4,5);
		assertEquals(15,yatzyScorer.calculateScore(Category.CHANCE,roll));
	}
	@Test
	public void getYatzyScore(){
		YatzyRoll roll=new YatzyRoll(1,1,1,1,1);
		assertEquals(50,yatzyScorer.calculateScore(Category.YATZI,roll));
	}@Test
	public void getOnesScore(){
		YatzyRoll roll=new YatzyRoll(1,1,1,1,2);
		assertEquals(4,yatzyScorer.calculateScore(Category.ONE,roll));
	}@Test
	public void getTwosScore(){
		YatzyRoll roll=new YatzyRoll(2,2,2,2,1);
		assertEquals(8,yatzyScorer.calculateScore(Category.TWOS,roll));
	}@Test
	public void getThreesScore(){
		YatzyRoll roll=new YatzyRoll(3,3,3,3,1);
		assertEquals(12,yatzyScorer.calculateScore(Category.THREES,roll));
	}@Test
	public void getFoursScore(){
		YatzyRoll roll=new YatzyRoll(4,4,4,4,1);
		assertEquals(16,yatzyScorer.calculateScore(Category.FOURS,roll));
	}@Test
	public void getFivesScore(){
		YatzyRoll roll=new YatzyRoll(5,5,5,5,1);
		assertEquals(20,yatzyScorer.calculateScore(Category.FIVES,roll));
	}@Test
	public void getSixesScore(){
		YatzyRoll roll=new YatzyRoll(6,6,6,6,1);
		assertEquals(24,yatzyScorer.calculateScore(Category.SIXES,roll));
	}

	@Test
	public void getByPair(){
		YatzyRoll roll=new YatzyRoll(1,3,3,5,5);
		assertEquals(10,yatzyScorer.calculateScore(Category.PAIR,roll));
	}
	@Test
	public void getTwoPairs(){
		YatzyRoll roll=new YatzyRoll(3,3,4,5,5);
		assertEquals(16,yatzyScorer.calculateScore(Category.TWOPAIRS,roll));
	}
}
