package com.company;
import com.company.model.Card;
import com.company.model.Rank;
import com.company.model.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    private CardPlayer team1;
    private CardPlayer team2;
    private List<Card> cards1 = new ArrayList<>();
    private List<Card> cards2 = new ArrayList<>();
    private int sum1 = 0;
    private int sum2 = 0;
    private int turn = new Random().nextInt() % 2 + 1;

    public Game(CardPlayer team1, CardPlayer team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void play() {

        List<Card> shakedCards = shake(getAllCards());
        for (int i = 0; i < shakedCards.size(); i++) {
            if (i % 2 == 0) {
                cards1.add(shakedCards.get(i));
            } else {
                cards2.add(shakedCards.get(i));
            }
        }
        team1.takeCardsInHand(new ArrayList<>(cards1));
        team2.takeCardsInHand(new ArrayList<>(cards2));
        System.out.println("Игроки получили свои карты");
        System.out.println("Команда " + (turn == 1 ? team1.getTeamName() : team2.getTeamName()) + " начинает");
        for (int i = 0; i < 18; i++) {
            Card cardFromTeam1 = null;
            Card cardFromTeam2 = null;
            if (turn == 1) {
                cardFromTeam1 = team1.turn(cardFromTeam2);
                cardFromTeam2 = team2.turn(cardFromTeam1);
                System.out.println(team1.getTeamName() + " ходит " + cardFromTeam1.toString());
                System.out.println(team2.getTeamName() + " отвечает " + cardFromTeam2.toString());
            } else {
                cardFromTeam2 = team2.turn(cardFromTeam1);
                cardFromTeam1 = team1.turn(cardFromTeam2);
                System.out.println(team2.getTeamName() + " ходит " + cardFromTeam2.toString());
                System.out.println(team1.getTeamName() + " отвечает " + cardFromTeam1.toString());
            }
            if(cards1.contains(cardFromTeam1)) {
                cards1.remove(cardFromTeam1);
            } else {
                throw new RuntimeException("Команда " + team1.getTeamName() +" жульничает");
            }
            if(cards2.contains(cardFromTeam2)) {
                cards2.remove(cardFromTeam2);
            } else {
                throw new RuntimeException("Команда " + team2.getTeamName() +" жульничает");
            }


            if (cardFromTeam1.getValue() > cardFromTeam2.getValue()) {
                sum1 += cardFromTeam1.getValue();
                sum1 += cardFromTeam2.getValue();
                System.out.println("Взятка для " + team1.getTeamName() + " - " + (cardFromTeam1.getValue() + cardFromTeam1.getValue()) + " очков\n");
            }
            if (cardFromTeam1.getValue() < cardFromTeam2.getValue()) {
                sum2 += cardFromTeam1.getValue();
                sum2 += cardFromTeam2.getValue();
                System.out.println("Взятка для " + team2.getTeamName() + " - " + (cardFromTeam1.getValue() + cardFromTeam1.getValue()) + " очков\n");
            }
            turn = turn == 1 ? 2 : 1;

        }
// if(sum1 > sum2) {
// System.err.println("Побеждает команда " + team1.getTeamName() + " с " + sum1 + " очков");
// }
// if(sum2 > sum1) {
// System.err.println("Побеждает команда " + team2.getTeamName() + " с " + sum2 + " очков");
// }
// if(sum2 == sum1) {
// System.err.println("Ничья с " + sum1 + "очков");
// }
        System.out.println(team1.getTeamName() + " " + sum1 + " : " + sum2 + " " +team2.getTeamName());

    }


    public List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card newCard = new Card(suit, rank);
                allCards.add(newCard);
            }

        }
        return allCards;
    }

    public List<Card> shake(List<Card> allCards) {
        Random random = new Random();
        int rndInt = 666 * 666 + random.nextInt(666 * 666);
        for (int i = 0; i < rndInt; i++) {
            Collections.shuffle(allCards);
        }
        System.out.println("Cards are shaked " + rndInt + " times");
        return allCards;
    }
}
