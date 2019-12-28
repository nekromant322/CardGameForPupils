package com.company.bots;

import com.company.CardPlayer;
import com.company.model.Card;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class RomioBot implements CardPlayer {



    private List<Card> myCards = new ArrayList<>();

    @Override
    public void takeCardsInHand(List<Card> hand) {

        for (int i = 0; i < hand.size(); i++) {
            myCards.add(hand.get(i));
        }

    }

    @Override
    public Card turn(Card enemyCard) {

        if (enemyCard == null) {
            int max = myCards.get(0).getValue();
            int a = 0;
            for (int i = 1; i < myCards.size(); i++) {
                if (max > myCards.get(i).getValue()) {
                    max = myCards.get(i).getValue();
                    a = i;
                }
            }
            Card fin = myCards.get(a);
            myCards.remove(a);
            return fin;
        }

        else {
            int min1 = myCards.get(0).getValue();
            int a1 = 0;
            int count = 0;

            for (int i = 1; i < myCards.size(); i++) {
                if (myCards.get(i).getValue() < min1 && myCards.get(i).getValue() > enemyCard.getValue()) {
                    a1 = i;
                    count++;
                }
            }

            if (min1 < enemyCard.getValue() && count == 0) {
                int min2 = myCards.get(0).getValue();
                int a2 = 0;

                for (int j = 1; j < myCards.size(); j++) {
                    if (min2 < myCards.get(j).getValue()) {
                        min2 = myCards.get(j).getValue();
                        a2 = j;
                    }
                }

                Card fin2 = myCards.get(a2);
                myCards.remove(a2);
                return fin2;
            }

            Card fin1 = myCards.get(a1);
            myCards.remove(a1);
            return fin1;
        }
    }

    @Override
    public String getTeamName() {
        return "ROMIO";
    }
}

