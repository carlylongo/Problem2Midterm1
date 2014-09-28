import java.util.*;

public class Deck
{
    // instance variables - 
    private ArrayList<Card> myDeck = new ArrayList<Card>();

    public Deck()
    {
        int currentRank = 1;
        int currentSuit = 0;
        for (int i=1; i<52; i++)
        {
            currentRank = i % 13;
            if (currentRank == 0)
            {
                currentRank = 13;
            }
            if ((i / 13) == 1)
            {
                currentSuit = 1;
            }
            else if ((i / 13) == 2)
            {
                currentSuit = 2;
            }
            else if ((i / 13) == 3)
            {
                currentSuit = 3;
            }
            
            myDeck.add(new Card(currentRank, currentSuit));
        }
        
        shuffleArray();             //randomize deck - 2 different methods
        long seed = System.nanoTime();
        Collections.shuffle(myDeck, new Random(seed));
    }
    
    public void shuffleArray()
    {
        Random rnd = new Random();
        int index = 0;
        Card tempCard = null;
        for (int i = 0; i < myDeck.size(); i++)
        {
            index = rnd.nextInt(i + 1);
            // Simple swap
            tempCard = myDeck.get(index);
            myDeck.set(index, myDeck.get(i));
            myDeck.set(i, tempCard);
        }
    }
    
    public Card drawCard()
    {
        return myDeck.remove(0);
    }
    
    public int cardsLeft()
    {
        return myDeck.size();
    }
}