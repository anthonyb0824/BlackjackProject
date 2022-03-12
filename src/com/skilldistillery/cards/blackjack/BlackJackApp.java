package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackJackApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BlackJackApp app = new BlackJackApp();
		Deck deck = new Deck();
		BlackjackDealer dealer = new BlackjackDealer(deck);
		BlackjackPlayer player = app.getPlayerName(input);

		boolean wantToPlayAgain = true;
		do {
			app.run(input, dealer, player);
			System.out.println("Do you want to play again?");
			String awnser = input.next();
			if (awnser.equals("no")) {
				wantToPlayAgain = false;
			}
			if(awnser.equals("yes")) {
				player.clear();
				dealer.clear();
			}

		} while (wantToPlayAgain);

	}

	private void run(Scanner input, BlackjackDealer dealer, BlackjackPlayer player) {

		// Set up give the player and dealer two cards.
		dealer.shuffle();
		player.addCard(dealer.dealCard());
		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
		// step 1 done.

		// check dealer and player for 21
		if (player.getHandValue() == 21) {
			if (player.isBlackjack() && dealer.isBlackjack()) {
				System.out.println("You win!");
				System.out.println("The Dealer had: " + dealer.toString());
				System.out.println("You had:" + player.toString());

			}
			if (player.isBlackjack()) {
				System.out.println("You win!");
				System.out.println("The Dealer had: " + dealer.toString());
				System.out.println("You had:" + player.toString());
			}
			if (dealer.isBlackjack()) {
				System.out.println("You lose");
				System.out.println("The Dealer had: " + dealer.toString());
				System.out.println("You had:" + player.toString());
			}
		} else {
			boolean canHit = true;
			while (canHit) {
				System.out.println("You have: " + player.toString());
				System.out.println("Thats: " + player.getHandValue());
				System.out.println("Do you want to hit or stay?");
				System.out.println("(Hit or Stay)");
				String hitorStay = input.next().toLowerCase();

				switch (hitorStay) {
				case "hit":
					player.addCard(dealer.dealCard());
					break;

				case "stay":
					canHit = false;
					break;

				}
				if (player.isBust()) {
					System.out.println("You lose");
					System.out.println("The Dealer had: " + dealer.toString());
					System.out.println("Thats: " + dealer.getHandValue());
					System.out.println("You busted with:" + player.toString());
					System.out.println("Thats: " + player.getHandValue());
					canHit = false;
					return;
				}
			}
			boolean dealerCanHit = true;
			while (dealerCanHit) {
				if (dealer.getHandValue() < 17) {
					dealer.addCard(dealer.dealCard());
				} else {
					dealerCanHit = false;
				}
			}
			// comapare final values and see who wins
			if (player.getHandValue() == dealer.getHandValue()) {

			}
			if (player.getHandValue() > dealer.getHandValue()) {
				System.out.println("You win!");
				System.out.println("The Dealer had: " + dealer.toString());
				System.out.println("You had:" + player.toString());
			}
			if (dealer.getHandValue() > player.getHandValue()) {
				System.out.println("You lose");
				System.out.println("The Dealer had: " + dealer.toString());
				System.out.println("You busted with:" + player.toString());
			}
		}

	}

	public BlackjackPlayer getPlayerName(Scanner input) {
		System.out.println("Welcome to ____ Casino");
		System.out.println("Whats your name?");
		BlackjackPlayer player = new BlackjackPlayer(input.next());
		return player;
	}

}
