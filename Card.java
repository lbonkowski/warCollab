package war;

public class Card {
    private String suit;
    private int number;

    public Card (String s, int n)  {
        suit = s;
        number = n;
    }

    public Card() {
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + " of " + suit;
    }
}//end card
