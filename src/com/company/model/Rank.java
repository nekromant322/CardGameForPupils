package com.company.model;

public enum Rank {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(2), QUEEN(3), KING(4), ACE(11);

    private final int value;

    Rank(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
