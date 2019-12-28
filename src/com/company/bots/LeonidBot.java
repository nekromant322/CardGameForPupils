package com.company.bots;


import com.company.CardPlayer;
import com.company.model.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeonidBot implements CardPlayer {
    ArrayList<Card> deck = new ArrayList<Card>();
    int i = 0;

    //boolean Carta = false;
    @Override
    public void takeCardsInHand(List<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            deck.add(hand.get(i));
        }
        Collections.sort(deck);
    }

    @Override
    public Card turn(Card enemyCard) {
        if(enemyCard == null){
            Card MyCard = deck.get(0);
            deck.remove(MyCard);
            return MyCard;
        } else {
            for (int j = 0; j < deck.size(); j++) {
                Card MyCard = deck.get(i);
                if (enemyCard.getValue() > MyCard.getValue()) {
                    deck.remove(MyCard);
                    return MyCard;
                }
            }
            Card MyCard = deck.get(0);
            deck.remove(MyCard);
            return MyCard;
        }
    }

    @Override
    public String getTeamName() {
        return "LOL";
    }
}


