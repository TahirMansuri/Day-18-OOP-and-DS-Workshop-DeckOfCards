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
        player.playGame();
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

    public String getRank(int rankNo) {
        switch(rankNo) {
            case 0:
                return "2";
            case 1:
                return "3";
            case 2:
                return "4";
            case 3:
                return "5";
            case 4:
                return "6";
            case 5:
                return "7";
            case 6:
                return "8";
            case 7:
                return "9";
            case 8:
                return "10";
            case 9:
                return "JACK";
            case 10:
                return "QUEEN";
            case 11:
                return "KING";
            case 12:
                return "ACE";
            default:
                return "";
        }
    }
    public String getSuit(int suitNo) {
        switch (suitNo) {
            case 0:
                return "CLUBS";
            case 1:
                return "DIAMONDS";
            case 2:
                return "HEARTS";
            case 3:
                return "SPADES";
            default:
                return "";
        }
    }
}
class Player extends DeckOfCards{
    Scanner sc = new Scanner(System.in);
    int playerCount;
    Player[] players;
    public void addPlayers() {
        System.out.println("Enter the Number of Players : ");
        playerCount = sc.nextInt();
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

    public void playGame() {
        for(int i = 0; i < playerCount; i++) {
            players[i].allotCards();
            System.out.println("Player "+ (i+1) +"'s CARDS : ");
            players[i].print();
        }
    }
}