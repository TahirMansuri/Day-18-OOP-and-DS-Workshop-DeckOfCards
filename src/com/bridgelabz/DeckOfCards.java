package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {

    static int[][] cards = new int[4][13];

    static String[] ranksArr= {"2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING","ACE"};
    static String[] suitArr = {"CLUBS","DIAMONDS","HEARTS","SPADES"};
    static Map<Integer,String> rankMap = new HashMap<>();
    static Map<Integer,String> suitMap = new HashMap<>();

    public static void main(String[] args) {
        //Welcome Message for User
        System.out.println("Welcome to Deck of Cards Problem");
        Scanner sc = new Scanner(System.in);
        int playerCount;
        System.out.println("Enter the Number of Players : ");
        playerCount = sc.nextInt();
        setRanksSuitsMap();
        if(playerCount > 4 || playerCount < 2) {
            System.out.println("Please Enter the Minimum 2 or Maximum 4 Players only.");
        } else {
            for (int i = 1; i <= playerCount; i++) {
                allotCards(i);
                System.out.println("Player "+ i +"'s CARDS : ");
                print(i);
            }
        }
    }

    public static void setRanksSuitsMap() {
        for(int i = 0; i <= 12; i++) {
            rankMap.put(i,ranksArr[i]);
        }
        for(int i = 0; i <= 3; i++) {
            suitMap.put(i,suitArr[i]);
        }
    }

    public static void allotCards(int playerNo) {
        for(int i = 0; i < 9; i++) {
            allotOneCard(playerNo);
        }
    }

    public static void allotOneCard(int playerNo) {
        Random random = new Random();

        int suit = random.nextInt(4);
        int rank = random.nextInt(13);

        if(cards[suit][rank] != 0) {
            allotOneCard(playerNo);
        } else {
            cards[suit][rank] = playerNo;
        }
    }

    static void print(int playerNo) {
        for(int suit = 0; suit < 4; suit ++) {
            for(int rank = 0; rank < 13; rank++) {
                if(cards[suit][rank] == playerNo) {
                    System.out.print( suitMap.get(suit) + " " + rankMap.get(rank) +"\t");
                }
            }
        }
        System.out.println("\n");
    }
}
