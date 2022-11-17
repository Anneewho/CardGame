package com.BHendrickson;

// Deck class extends Hand to also be an array list of card objects

import java.util.Random;

public class Deck extends Hand {
    Random rand = new Random(); // Random number generator used to shuffle cards

    // method to populate a deck of cards
    public void populate(){
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                Card card = new Card(rank, suit);
//                card.flipCard();
                this.add(card);
            }
        }
    }
    // method to shuffle card deck swapping a random card in the deck
    // with the last card of a for loop
    public void shuffle(){
        for(int i = getCards().size() - 1; i > 0; i--){
            int pick = rand.nextInt(i);
            Card randCard = getCards().get(pick);
            Card lastCard = getCards().get(i);
            getCards().set(i, randCard);
            getCards().set(pick, lastCard);
        }
    }

    //deal a given amount of cards to a given hand using a for loop
    public void deal(Hand hand, int perHand){
        for (int i = 0; i < perHand; i++){
            this.give(getCards().get(0), hand);
        }
    }

}
