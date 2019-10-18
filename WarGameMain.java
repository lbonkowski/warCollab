package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import javax.smartcardio.Card;

public class WarGameMain {
    public static Queue<Card> player1 = new LinkedList<Card>();
    public static Queue<Card> player2 = new LinkedList<Card>();

    public static void main(String[] args) {




        while(true) {
            if(player1.isEmpty() || player2.isEmpty()) {
                break;
            }
            Card temp1 = player1.remove();
            Card temp2 = player2.remove();
            System.out.println(temp1);
            System.out.println(temp2);
            if (temp1.getNumber() > temp2.getNumber()) {
                player1.offer(temp1);
                player1.offer(temp2);
                System.out.println("P1 length:" + player1.size());
                System.out.println("P2 length:" + player2.size());
            } else if (temp1.getNumber() < temp2.getNumber()) {
                player2.offer(temp1);
                player2.offer(temp2);
                System.out.println("P1 length:" + player1.size());
                System.out.println("P2 length:" + player2.size());
            } else {
                ArrayList<Card> t1 = new ArrayList<>();
                ArrayList<Card> t2 = new ArrayList<>();
                war(player1, player2, t1, t2);

            }
        }
        if(player2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }

    }//end main

    public static void war(Queue<Card> p1, Queue<Card> p2, ArrayList<Card> temp1, ArrayList<Card> temp2) {
        if(p1.isEmpty() || p2.isEmpty()) {
            return;
        }
        if (draw(p1, temp1)) return;
        if (draw(p2, temp2)) return;
        if (temp1.get(temp1.size()-1).getNumber()>temp2.get(temp2.size()-1).getNumber()) {
            for (int i = 0; i < temp1.size(); i++) {
                p1.offer(temp1.get(i));
                p1.offer(temp2.get(i));
            }
        } else if (temp1.get(temp1.size()-1).getNumber()<temp2.get(temp2.size()-1).getNumber()) {
            for (int i = 0; i < temp2.size(); i++) {
                p2.offer(temp1.get(i));
                p2.offer(temp2.get(i));
            }
        } else {
            war(p1, p2, temp1, temp2);
        }
    }//end war

    private static boolean draw(Queue<Card> p2, ArrayList<Card> temp2) {
        temp2.add(p2.remove());
        if(p2.isEmpty()) {
            return true;
        }
        temp2.add(p2.remove());
        if(p2.isEmpty()) {
            return true;
        }
        temp2.add(p2.remove());
        if(p2.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void shuffleAndDeal() {
        ArrayList<Card> deck = new ArrayList<>();
        deck.add(new Card ("Clubs", 1));
        deck.add(new Card ("Clubs", 2));
        deck.add(new Card ("Clubs", 3));
        deck.add(new Card ("Clubs", 4));
        deck.add(new Card ("Clubs", 5));
        deck.add(new Card ("Clubs", 6));
        deck.add(new Card ("Clubs", 7));
        deck.add(new Card ("Clubs", 8));
        deck.add(new Card ("Clubs", 9));
        deck.add(new Card ("Clubs", 10));
        deck.add(new Card ("Clubs", 11));
        deck.add(new Card ("Clubs", 12));
        deck.add(new Card ("Clubs", 13));

        deck.add(new Card ("Spades", 2));
        deck.add(new Card ("Spades", 1));
        deck.add(new Card ("Spades", 3));
        deck.add(new Card ("Spades", 4));
        deck.add(new Card ("Spades", 6));
        deck.add(new Card ("Spades", 5));
        deck.add(new Card ("Spades", 8));
        deck.add(new Card ("Spades", 7));
        deck.add(new Card ("Spades", 10));
        deck.add(new Card ("Spades", 9));
        deck.add(new Card ("Spades", 12));
        deck.add(new Card ("Spades", 13));
        
        deck.add(new Card ("Hearts", 1));
        deck.add(new Card ("Hearts", 2));
        deck.add(new Card ("Hearts", 3));
        deck.add(new Card ("Hearts", 4));
        deck.add(new Card ("Hearts", 5));
        deck.add(new Card ("Hearts", 6));
        deck.add(new Card ("Hearts", 7));
        deck.add(new Card ("Hearts", 8));
        deck.add(new Card ("Hearts", 9));
        deck.add(new Card ("Hearts", 10));
        deck.add(new Card ("Hearts", 11));
        deck.add(new Card ("Hearts", 12));
        deck.add(new Card ("Hearts", 13));

        deck.add(new Card ("Diamonds", 2));
        deck.add(new Card ("Diamonds", 1));
        deck.add(new Card ("Diamonds", 3));
        deck.add(new Card ("Diamonds", 4));
        deck.add(new Card ("Diamonds", 6));
        deck.add(new Card ("Diamonds", 5));
        deck.add(new Card ("Diamonds", 8));
        deck.add(new Card ("Diamonds", 7));
        deck.add(new Card ("Diamonds", 10));
        deck.add(new Card ("Diamonds", 9));
        deck.add(new Card ("Diamonds", 12));
        deck.add(new Card ("Diamonds", 13));
        Collections.shuffle(deck);
        
        for(int i = 0; i < deck.length; i++) {
        	player1.add(i);
        	i++;
        	player2.add(i);
        }
    }
}//end class
