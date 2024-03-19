import java.util.*;

class Card
{
    String suit;
    String rank;

    Card(String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString()
    {
        return rank + " of " + suit;
    }
}

class Deck_Of_Cards
{
    List<Card> deck;

    Deck_Of_Cards()
    {
        deck = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck()
    {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits)
        {
            for (String rank : ranks)
            {
                deck.add(new Card(suit, rank));
            }
        }
    }

    private void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    List<Card> dealCards(int numberOfCards)
    {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++)
        {
            hand.add(deck.remove(0));
        }
        return hand;
    }
}

class Player
{
    String name;
    Queue<Card> hand;

    Player(String name)
    {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    void receiveCards(List<Card> cards)
    {
        for (Card card : cards)
        {
            hand.offer(card);
        }
        sortCardsByRank();
    }

    private void sortCardsByRank()
    {
        List<Card> sortedHand = new ArrayList<>(hand);
        sortedHand.sort(Comparator.comparingInt(this::rankValue));
        hand.clear();
        hand.addAll(sortedHand);
    }

    private int rankValue(Card card)
    {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < ranks.length; i++)
        {
            if (card.rank.equals(ranks[i]))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");
        for (Card card : hand)
        {
            sb.append(card).append(", ");
        }
        return sb.toString();
    }
}

public class CardGame
{
    public static void main(String[] args)
    {
        Deck_Of_Cards deck = new Deck_Of_Cards();
        Queue<Player> playersQueue = new LinkedList<>();
        for (int i = 1; i <= 4; i++)
        {
            playersQueue.offer(new Player("Player " + i));
        }

        for (int i = 0; i < 9; i++)
        {
            for (Player player : playersQueue)
            {
                List<Card> cards = deck.dealCards(1);
                player.receiveCards(cards);
            }
        }

        for (Player player : playersQueue)
        {
            System.out.println(player);
        }
    }
}
