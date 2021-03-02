package com.king.kata.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class YatzyScorer {
	public int calculateScore(Category category, YatzyRoll roll) {
		return switch(category){

			case CHANCE ->sumAll(roll);
			case YATZI -> 50;
			case ONE->getByNumber(Category.ONE,roll);
			case TWOS ->getByNumber(Category.TWOS,roll);
			case THREES ->getByNumber(Category.THREES,roll);
			case FOURS -> getByNumber(Category.FOURS,roll);
			case FIVES -> getByNumber(Category.FIVES,roll);
			case SIXES -> getByNumber(Category.SIXES,roll);
			case PAIR ->getByPair(roll);
			case TWOPAIRS -> getByTwoPairs(roll);
			case THREEOFKIND -> getThreeOfKind(roll);
		};
	}
	public int sumAll(YatzyRoll roll) {

		return Arrays.stream(roll.getDice()).sum();
	}

	public int yatzy() {
		return Category.YATZI.getValue();
	}

	public int getByNumber(Category number,YatzyRoll roll){
		return Arrays.stream(roll.getDice()).filter(i->i==number.getValue()).sum();
	}

	public int getByPair(YatzyRoll roll) {
		return Arrays.stream(roll.getDice())
				.filter(i->i==Arrays.stream(roll.getDice())
						.max().orElseThrow()).sum();
	}
	public int getByTwoPairs(YatzyRoll roll){

		List<Integer> rollToList=Arrays.stream(roll.getDice()).boxed().collect(Collectors.toList());

		List<Integer> cut=rollToList.stream().sorted(Comparator.reverseOrder()).skip(2).collect(Collectors.toList());

		return getByPair(roll)
				+ IntStream.range(1,cut.size())
				.filter(i-> cut.get(i - 1).equals(cut.get(i)))
				.map(i->cut.get(i)*2)
				.reduce(0,Integer::sum);
	}
	public int getThreeOfKind(YatzyRoll roll){
		List<Integer> sorted= Arrays.stream(roll.getDice()).sorted().boxed().collect(Collectors.toList());
		return IntStream.range(1,sorted.size()-1)
				.filter(i-> sorted.get(i - 1) == sorted.get(i) && sorted.get(i)==sorted.get(i+1))
				.map(i-> sorted.get(i)*3)
				.reduce(0,Integer::sum);

	}

}
