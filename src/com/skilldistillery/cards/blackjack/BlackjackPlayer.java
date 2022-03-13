package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackPlayer extends BlackjackHand {
	private String name;

	public BlackjackPlayer(String name) {
		this.name = name;
	}

	public void playerLoss(BlackjackDealer dealer) {
		System.out.println("You lose");
		System.out.println("The Dealer had: " + dealer.toString()+"Total: "+dealer.getHandValue());
		System.out.println("You had:" + this.toString()+"Total:"+this.getHandValue());
	}

	public void playerWin(BlackjackDealer dealer) {
		System.out.println("You win!");
		System.out.println("The Dealer had: " + dealer.toString() + " Total: " + dealer.getHandValue());
		System.out.println("You had: " + this.toString() + " Total: " + this.getHandValue());

	}

	public int playerHit(BlackjackDealer dealer, Scanner input) {
		boolean playerCanHit = true;
		while (playerCanHit) {
			System.out.println("You have: " + this.toString() + " Total: " + this.getHandValue());
			System.out.println("Do you want to hit or stay?");
			System.out.println("(Hit or Stay)");
			String hitorStay = input.next().toLowerCase();

			switch (hitorStay) {
			case "hit":
				this.addCard(dealer.dealCard());
				break;

			case "stay":
				playerCanHit = false;
				return 0;

			}
			if (this.isBust()) {
				this.playerLoss(dealer);
				playerCanHit = false;
				return -1;
			}
		}
		return 0;

	}
}
