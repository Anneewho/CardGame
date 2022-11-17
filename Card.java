package com.BHendrickson;

// Card class to create a card object with a suit and a rank

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
//        isFaceUp = true;
    }

    // method to get rank points of card
    public int getRank(){
        return rank.getRank();
    }

    // method to print string of card rank
    public String printRank(){
        return rank.printRank(); // get rank as a string (for aces)
    }

    // method to return string of rank and suit of a card
    public String toString(){
        String str = "";
            str += rank.printRank() + " of " + suit.printSuit();
        return str;
    }
}
