package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {

    int[][] cards = new int[4][13];

    public static void main(String[] args) {
        //Welcome Message for User
        System.out.println("Welcome to Deck of Cards Problem");

        Player player = new Player();
        player.addPlayers();
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
class Player {
    Scanner sc = new Scanner(System.in);
    Player[] players;
    public void addPlayers() {
        System.out.println("Enter the Number of Players : ");
        int playerCount = sc.nextInt();
        if(playerCount > 4 || playerCount < 2) {
            System.out.println("Please Enter the Minimum 2 or Maximum 4 Players only.");
            addPlayers();
        } else {
            players = new Player[playerCount];

            for (int i = 0; i < playerCount; i++) {
                players[i] = new Player();
            }
        }
    }
}