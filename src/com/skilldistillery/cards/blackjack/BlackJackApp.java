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
			boolean goodInput = false;
			while (!goodInput) {
				System.out.println("Do you want to play again?");
				System.out.println("(Yes or No)");
				String awnser = input.next().toLowerCase();
				switch (awnser) {
				case "yes":
					player.clear();
					dealer.clear();
					goodInput = true;
					break;
				case "no":
					wantToPlayAgain = false;
					goodInput = true;
					break;
				default:
					System.err.println("Invalid choice");
					break;
				}
			}
		} while (wantToPlayAgain);
		input.close();

	}

	private void run(Scanner input, BlackjackDealer dealer, BlackjackPlayer player) {

		// Set up give the player and dealer two cards.
		setUp(dealer, player);

		// check dealer and player for 21
		if (player.getHandValue() == 21 || dealer.getHandValue() == 21) {
			if (player.isBlackjack() && dealer.isBlackjack()) {
				player.playerWin(dealer);
				return;
			} else if (player.isBlackjack()) {
				player.playerWin(dealer);
				return;
			} else if (dealer.isBlackjack()) {
				player.playerLoss(dealer);
				return;
			}
		} else {
			int playerHit = player.playerHit(dealer, input);
			if (playerHit == -1) {
				return;
			}
		}
		dealer.dealerHit(dealer);

		finalCompare(dealer, player);
	}

	private void setUp(BlackjackDealer dealer, BlackjackPlayer player) {
		dealer.shuffle();
		player.addCard(dealer.dealCard());
		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
	}

	public BlackjackPlayer getPlayerName(Scanner input) {
		System.out.println("Welcome to Lucky Casino");
		System.out.println("Whats your name?");
		BlackjackPlayer player = new BlackjackPlayer(input.next());
		return player;
	}

	public void finalCompare(BlackjackDealer dealer, BlackjackPlayer player) {
		if (dealer.isBust()) {
			player.playerWin(dealer);
		} else if (player.getHandValue() == dealer.getHandValue()) {
			player.playerWin(dealer);
		} else if (player.getHandValue() > dealer.getHandValue()) {
			player.playerWin(dealer);
		} else if (dealer.getHandValue() > player.getHandValue()) {
			player.playerLoss(dealer);
		}

	}

}
