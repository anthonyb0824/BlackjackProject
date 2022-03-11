package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> deck = new ArrayList<>(52);

	public Deck() {
		deck = crateDeak();
	}

	private List<Card> crateDeak() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		 Card cardRemoved = deck.remove(0);
		return cardRemoved;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}
}
