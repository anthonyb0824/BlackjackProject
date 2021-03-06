package com.skilldistillery.cards.common;

import java.util.Objects;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit name, Rank rank) {
		this.suit = name;
		this.rank = rank;
	}
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}



	@Override
	public String toString() {
		String output = this.rank + " of " + this.suit;
		return output;
	}

	public int getValue() {
		return rank.getValue();

	}
}
