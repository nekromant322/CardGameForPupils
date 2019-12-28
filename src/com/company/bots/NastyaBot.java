package com.company.bots;

import com.company.CardPlayer;
import com.company.model.Card;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NastyaBot implements CardPlayer {
    private List<Card> myCards;
    private int myScore = 0;
    private int enemyScore = 0;
    private boolean a = false;
    private int pos;

    @Override
    public void takeCardsInHand(List<Card> hand) {
        myCards = hand;
        Collections.sort(myCards);

    }

    @Override
    public Card turn(Card enemyCard) {
        Collections.sort(myCards);
        if (enemyCard == null) {
            Card removeNullCard = myCards.get(0);
            myCards.remove(0);
            return removeNullCard;

        } else {

            for (int i = 0; i < myCards.size(); i++) {
                if (myCards.get(i).getValue() > enemyCard.getValue()) {
                    a = false;
                    pos = i;
                    break;


                } else {
                    a = true;

                }
            }
            Card removeCard = myCards.get(pos);
            myCards.remove(pos);
            if (a == true) {
                return myCards.get(0);
            } else {
                return removeCard;
            }
        }
    }

    @Override
    public String getTeamName() {
        return "lohi";
    }

}

