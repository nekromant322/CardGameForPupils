package com.company.bots;

import com.company.CardPlayer;
import com.company.model.Card;

import java.util.Collections;
import java.util.List;

public class KirillBot implements CardPlayer {
    List<Card> myCards;


    @Override
    public void takeCardsInHand(List<Card> hand) {
        myCards = hand;
    }

    @Override

    public Card turn(Card enemyCard) {
        Collections.sort(myCards);
        if (enemyCard == null) {
            Card cardToTurn = myCards.get(myCards.size() - 1);
            myCards.remove(cardToTurn);
            return cardToTurn;
        } else {
            int count = 0;
            for (int i = 0; i < myCards.size(); i++) {
                if (myCards.get(i).getValue() > enemyCard.getValue()) {
                    count = i;
                }
            }

            Card cardToTurn = myCards.get(count);
            myCards.remove(cardToTurn);
            return cardToTurn;
        }
    }

    @Override
    public String getTeamName() {
        return "LechimZubi";
    }
}
