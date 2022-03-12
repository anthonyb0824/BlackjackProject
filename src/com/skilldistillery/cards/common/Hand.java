package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards = new ArrayList<>();
	
	public Hand() {}
	
	public void  addCard(Card card) {
		getCards().add(card);
	}
	
	public void clear() {
		getCards().clear();
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [cards=" + getCards() + "]";
	}

	public List<Card> getCards() {
		return cards;
	}
	

}
