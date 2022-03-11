package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	private String suit;
	
	private Suit(String suit){
		this.suit = suit;
	}
	
	
	@Override
	public String toString() {
		return suit;
		
	}
}
