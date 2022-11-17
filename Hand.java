package com.BHendrickson;

// Hand class to create an array list of cards for a hand or a deck

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    // method to add a card to a hand
    public void add(Card card){
        cards.add(card);
    }

    // method to show the contents of a hand and their points using for each loop
    public String showHand(){
        String str = "";
        for(Card c : cards){
            str += c.toString() + "\n";
        }
            str += "Total points = " + getTotal() + "\n";

        return str;
    }

    // method to return card array list
    public ArrayList<Card> getCards() {
        return cards;
    }

    // method to give a card from the deck to a hand
    public void give(Card card, Hand otherHand){
            cards.remove(card);
            otherHand.add(card);
        }

    // method to return total points of a hand and determine how much aces count for
    // Aces default to 1 point but if total is <= 11, adds 10 more points
    public int getTotal(){
        int totalPts = 0;
        boolean hasAce = false;
        for (int i = 0; i < cards.size(); i ++){
            totalPts += cards.get(i).getRank();
            // check to see if card is an ace
            if (cards.get(i).printRank() == "Ace"){
                hasAce = true;
            }
            // make ace worth 11 if total points <= 11
            if (hasAce && totalPts <= 11) {
                totalPts += 10; // add 10 more to the ace
            }
        }
        return totalPts;
    }
}
