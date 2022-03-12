package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackDealer extends BlackjackHand {
	private Deck deck;
	
	public BlackjackDealer(Deck deck) {
		this.deck = deck;
	}
	
	public Card dealCard() {
		return deck.dealCard();
		
	}
	
	public boolean compareCards(BlackjackPlayer jack) {
		//returns true if dealers cards value are than players cards
		if(jack.getHandValue() < this.getHandValue()) {
			return true;
		}
		return false;
		
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	
	
	

}
