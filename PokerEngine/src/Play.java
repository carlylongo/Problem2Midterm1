
/**
 * will build a deck, draw a hand(s), evaluate the hands, etc.
 * 
 * @author (Akuma Akuma-Ukpo) 
 * @version (9/22/2014)
 */
public class Play
{
    // instance variables - 
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        Hand ourHands[] = new Hand[5];
        for (int i=0; i<5; i++)
        {            
            ourHands[i] = new Hand(deck);
            ourHands[i].evaluateHand();
            ourHands[i].display(); //show the summary of the hand, e.g. "full house"
            ourHands[i].displayAll(); //look at all the individual cards in the hand         
        }
        
        int bestHand = 0;
        
        for (int i=0; i<5; i++)
        {
            if (ourHands[i].getHandRank() > ourHands[bestHand].getHandRank())
            {
                bestHand = i;
            }
            else if (ourHands[i].getHandRank() == ourHands[bestHand].getHandRank())
            {
                if (ourHands[i].getBestCard() > ourHands[bestHand].getBestCard())
                {
                    bestHand = i;
                }
                else if (ourHands[i].getBestCard() == 1)
                {
                    bestHand = i;
                }
            }
        }
        
        System.out.println("The Best Hand in this Set is:\n");
        ourHands[bestHand].display(); //show the summary of the hand, e.g. "full house"
        ourHands[bestHand].displayAll();
    }
}