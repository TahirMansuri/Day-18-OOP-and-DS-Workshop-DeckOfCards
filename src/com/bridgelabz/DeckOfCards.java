package com.bridgelabz;

import java.util.Random;

public class DeckOfCards {

    int[][] cards = new int[4][13];

    public static void main(String[] args) {
        //Welcome Message for User
        System.out.println("Welcome to Deck of Cards Problem");

        DeckOfCards player = new DeckOfCards();
        player.allotCards();
        player.print();
    }

    public void allotCards() {
        for(int i = 0; i < 9; i++) {
            allotOneCard();
        }
    }

    public void allotOneCard() {
        Random random = new Random();

        int suit = random.nextInt(4);
        int rank = random.nextInt(13);

        if(cards[suit][rank] != 0) {
            allotOneCard();
        } else {
            cards[suit][rank] = 1;
        }
    }

    void print() {
        for(int suit = 0; suit < 4; suit ++) {
            for(int rank = 0; rank < 13; rank++) {
                if(cards[suit][rank] == 1) {
                    System.out.println( suit + " " + rank );
                }
            }
        }
    }
}
