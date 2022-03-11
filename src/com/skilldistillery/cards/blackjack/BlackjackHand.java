package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand{
	
	public BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isBlackjack() {
		//logic to see if current hand is a blackjack
		return false;
		
	}
	
	public boolean isBust() {
		//logic to see if hand total is over 21
		return false;
		
	}
	

}
