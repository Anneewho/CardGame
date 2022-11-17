package com.BHendrickson;

// Enum of card suits with String text of name of suit

public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String suitText;

    Suit(String suitText){
        this.suitText = suitText;
    }

    // method to return name of suit in string form
    public String printSuit(){
        return suitText;
    }
}
