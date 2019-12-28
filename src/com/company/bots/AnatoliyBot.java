package com.company.bots;

import com.company.CardPlayer;
import com.company.model.Card;

import java.util.List;


public class AnatoliyBot implements CardPlayer {

    private List<Card> myCards;
    private int count = 0;

    @Override
    public void takeCardsInHand(List<Card> hand) {
        myCards = hand;
    }

    @Override
    public Card turn(Card enemyCard) {
        if(enemyCard == null) {

        } else {

        }
        Card cardToPlayWith = myCards.get(count);
        count++;
        return cardToPlayWith;
    }

    @Override
    public String getTeamName() {
        return "AnatoliyBot";
    }
}
