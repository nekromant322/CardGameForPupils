package com.company.model;

import java.util.Objects;

public class Card implements Comparable<Card>{
    private Suit suit;
    private Rank rank;


    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return suit.getValue() * rank.getValue();
    }

    @Override
    public int compareTo(Card anotherCard) {
        return this.getValue() - anotherCard.getValue();
    }

    @Override
    public String toString() {
        return rank.name() + " " +suit.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
