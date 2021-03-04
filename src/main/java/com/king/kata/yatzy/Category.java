package com.king.kata.yatzy;

public enum Category {
	CHANCE(0),
	YATZI(50),
	ONE(1),
	TWOS(2),
	THREES(3),
	FOURS(4),
	FIVES(5),
	SIXES(6),
	PAIR(7),
	TWOPAIRS(8),
	THREEOFKIND(9),
	FOUROFKIND(10),
	SMALLSTRAIGHT(11),
	LARGESTRAIGHT(12),
	FULLHOUSE(13);
	private final int id;
	Category(int id) { this.id = id; }
	public int getValue() { return id; }
}
