package com.BHendrickson;

// Enum of card rank with value and string text of rank

public enum Rank {
    ACE(1, "Ace"),
    DEUCE(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "Jack"),
    QUEEN(10, "Queen"),
    KING(10, "King");

    private final int rankValue;
    private final String rankString;

    Rank(int rankValue, String rankString){
        this.rankValue = rankValue;
        this.rankString = rankString;
    }

    // method to return int value of rank
    public int getRank(){
        return rankValue;
    }

    // method to return string of rank
    public String printRank(){
        return rankString;
    }
}
