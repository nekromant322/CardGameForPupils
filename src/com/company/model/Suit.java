package com.company.model;

public enum Suit {
    DIAMONDS(5), CLUBS(10), HEARTS(15), SPADES(20);

    private final int value;

    Suit(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
