import java.util.*;

public class DeckOfCards
{

    public static void main(String[] args)
    {
        String[] suits = {"Clubs",   "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
                "Queen", "King", "Ace"};
        ArrayList<String> deck = new ArrayList<>();

        for (int i = 0; i < suits.length; i++)
        {
            String suit = suits[i];
            for (int j = 0; j < ranks.length; j++)
            {
                String rank = ranks[j];
                deck.add(rank + " of " + suit);
            }
        }


        Collections.shuffle(deck, new Random());


        String[][] players = new String[4][9];
        int cardIndex = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                players[i][j] = deck.get(cardIndex);
                cardIndex++;
            }
        }


        for (int i = 0; i < 4; i++)
        {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < 9; j++)
            {
                System.out.println(players[i][j]);
            }
            System.out.println();
        }
    }
}
