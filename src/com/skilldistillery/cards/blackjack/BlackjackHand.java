package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		// logic to see if current hand is a blackjack
		for (Card card : getCards()) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public boolean isBlackjack() {
		int handValue = 0;
		// logic to see if current hand is a blackjack
		for (Card card : getCards()) {
			handValue += card.getValue();
		}
		if (handValue == 21) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isBust() {
		// logic to see if hand total is over 21
		int handValue = 0;
		for (Card card : getCards()) {
			handValue += card.getValue();
		}
		if (handValue > 21) {
			return true;
		} else {
			return false;
		}
	}

}
