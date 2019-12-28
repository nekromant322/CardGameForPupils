package com.company;

import com.company.model.Card;

import java.util.List;

public interface CardPlayer {

    void takeCardsInHand(List<Card> hand);
    Card turn(Card enemyCard);
    String getTeamName();
}
