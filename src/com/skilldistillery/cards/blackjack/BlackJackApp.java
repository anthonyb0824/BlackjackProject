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
			if (awnser.equals("yes")) {
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

	public BlackjackPlayer getPlayerName(Scanner input) {
		System.out.println("Welcome to ____ Casino");
		System.out.println("Whats your name?");
		BlackjackPlayer player = new BlackjackPlayer(input.next());
		return player;
	}

	public void finalCompare(BlackjackDealer dealer, BlackjackPlayer player) {
		if (dealer.isBust()) {
			player.playerWin(dealer);
		}
		else if (player.getHandValue() == dealer.getHandValue()) {
			player.playerWin(dealer);
		} else if (player.getHandValue() > dealer.getHandValue()) {
			player.playerWin(dealer);
		} else if (dealer.getHandValue() > player.getHandValue()) {
			player.playerLoss(dealer);
		}

	}

}
