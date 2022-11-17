package com.BHendrickson;

// Blackjack card game that displays players cards first, ask for user input to
// hit or stay, then shows dealers cards who must take a card if total is <= 16
// then points are checked to determine game winner

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // create, populate and shuffle a deck
        Deck deck = new Deck();
        deck.populate();
        deck.shuffle();

        // create playing hands
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        // deal 2 cards to playerHand then show player cards
        deck.deal(playerHand, 2);
        System.out.println("\nPlayer's cards: \n" + playerHand.showHand());

        // deal 2 cards to dealerHand
        deck.deal(dealerHand, 2);

        // check if either hand was dealt 21
        // if player was, player wins.
        // if player wasn't but dealer was, show dealer's cards, and dealer wins
        if (playerHand.getTotal() == 21){
            System.out.println("Player wins!");
            System.exit(0);
        } else if (dealerHand.getTotal() == 21){
            System.out.println("\nDealer's cards:  \n" + dealerHand.showHand());
            System.out.println("Dealer wins!");
            System.exit(0);

        } // ask if player wants to hit or stay
        // if hitting results in score of 21, player wins
        // if goes over 21, player busts, game over
        while (playerHand.getTotal() < 21) {
            System.out.println("Enter 1 to hit or 2 to stay");
            int response = input.nextInt();
            if (response == 1) {
                deck.deal(playerHand, 1);
                System.out.println("\nPlayer takes a card\n");
                System.out.println("Player's cards: \n" + playerHand.showHand());
                if (playerHand.getTotal() == 21){
                    System.out.println("Player wins!");
                    System.exit(0);
                } else if (playerHand.getTotal() > 21){
                    System.out.println("Player busts");
                    System.exit(0);
                }
            } if (response == 2){
                System.out.println("\nPlayer stays");
                break;
            }
        }

        // show dealerHand's cards
        System.out.println("\nDealer's cards:  \n" + dealerHand.showHand());

        // if dealer's cards are <= 16, dealer takes a card
        // game ends if dealer gets 21 or busts
        while (dealerHand.getTotal() <= 16) {
            deck.deal(dealerHand, 1);
            System.out.println("Dealer takes a card");
            System.out.println("\nDealer's cards:  \n" + dealerHand.showHand());
            if (dealerHand.getTotal() == 21){
                System.out.println("Dealer wins!");
                System.exit(0);
            } else if (dealerHand.getTotal() > 21){
                System.out.println("Dealer busts, player wins!");
                System.exit(0);
            }
        } // see whose hand has the most points or if tied, then no winner
        if (playerHand.getTotal() > dealerHand.getTotal()){
            System.out.println("Player wins!");
        } else if (playerHand.getTotal() == dealerHand.getTotal()){
            System.out.println("Push. No winners");
        } else {
            System.out.println("Dealer wins!");
        }

        input.close(); // close scanner
    }

}
