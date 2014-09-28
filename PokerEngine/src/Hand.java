public class Hand
{
    private Card[] myHand;
    private int[] cardRanks;
    private int handRank;
    private int bestCard;

    /**
     * Constructor for objects of class Hand
     */
    public Hand(Deck myDeck)
    {   
        cardRanks = new int[6];
        myHand = new Card[5];
        for (int x = 0; x < 5; x++)
        {
            myHand[x] = myDeck.drawCard();
        }
        
    }
    
    public void evaluateHand()
    {
        
        //new code
        int[] ranksOfHand = new int[14];

        for (int x=0; x<=13; x++)
        {
            ranksOfHand[x]=0;
        }

        for (int x=0; x<=4; x++)
        {
            ranksOfHand[myHand[x].getRank()]++;
            //increment rank array at the index of each card's rank
        }
        
        int sameCards = 1;
        //we know there will be at least one card of any rank
        int groupRank = 0;
        for (int x=13; x>=1; x--) //loop going from 13 to 1
        {
            if (ranksOfHand[x] > sameCards) //If more cards of rank x than sameCards 
            {
                sameCards=ranksOfHand[x];    //set sameCards to that number of cards
                groupRank=x;           //and record the rank of the cards 
            }
        }

        int sameCards2 = 1;
        int largeGroupRank = 1;
        int smallGroupRank = 1;

        for (int x = 13; x >= 1; x--)
        {
            if (ranksOfHand[x] > sameCards) 
            {
                if (sameCards != 1)
                //if sameCards was not the default value
                {
                    sameCards2 = sameCards;
                    smallGroupRank = largeGroupRank;
                }
         
                sameCards = ranksOfHand[x] - 1;
                largeGroupRank = x;
         
            } 
            if (ranksOfHand[x] > sameCards2)
            {
                sameCards2 = ranksOfHand[x] - 1;
                smallGroupRank = x;
            }
        }
        
        boolean haveFlush = true; //assume there is a flush
        for (int x = 0; x < 4; x++) 
        {
            if (myHand[x].getSuit() != myHand[x+1].getSuit())
            {
                haveFlush = false;
            }
        }
        
        int straightHighCard = 0;
        boolean haveStraight = false;  //assume no straight  
        for (int x = 1; x <= 9; x++) 
        {
            if (ranksOfHand[x] == 1 && ranksOfHand[x+1] == 1 && ranksOfHand[x+2] == 1 && 
            ranksOfHand[x+3] == 1 && ranksOfHand[x+4] == 1)
            {
                haveStraight = true;
                straightHighCard = x+4; //4 above bottom value
                break;
            }
        }

        if (ranksOfHand[10] == 1 && ranksOfHand[11] == 1 && ranksOfHand[12] == 1 && 
        ranksOfHand[13] == 1 && ranksOfHand[1] == 1) //ace high
        {
            haveStraight = true;
            straightHighCard = 14; //higher than king
        }
        
        
        int orderedRanks[] = new int[5];
        int index = 0;


        if (ranksOfHand[1] == 1) //if ace, run this before because ace is highest card
        {
            //record an ace as 14 instead of one, as its the highest card
            orderedRanks[index] = 14;
            index++; //increment position
        }

        for (int x=13; x>=2; x--)
        {
            if (ranksOfHand[x]==1)
            //we have already written code to handle the case
            //of their being two cards of the same rank
            {
                orderedRanks[index] = x; 
                index++;
            }
        }
        
        
        //start hand evaluation
        if ( sameCards == 1 )
        {    //if we have no pair...
            cardRanks[0] = 1;          //this is the lowest type of hand, so it gets the lowest value
            cardRanks[1] = orderedRanks[0];  //the first determining factor is the highest card,
            cardRanks[2] = orderedRanks[1];  //then the next highest card,
            cardRanks[3] = orderedRanks[2];  //and so on
            cardRanks[4] = orderedRanks[3];
            cardRanks[5] = orderedRanks[4];
        }
        else if (sameCards == 2 && sameCards2 == 1) //if 1 pair
        {
            cardRanks[0] = 2;                //pair ranked higher than high card
            cardRanks[1] = smallGroupRank;   //rank of pair
            cardRanks[2] = orderedRanks[0];  //next highest cards.
            cardRanks[3] = orderedRanks[1];
            cardRanks[4] = orderedRanks[2];
        }
        else if (sameCards == 2 && sameCards2 == 2) //two pair
        {
            cardRanks[0] = 3;
            //rank of greater pair
            cardRanks[1] = largeGroupRank > smallGroupRank ? largeGroupRank : smallGroupRank;
            //rank of smaller pair
            cardRanks[2] = largeGroupRank < smallGroupRank ? largeGroupRank : smallGroupRank;
            cardRanks[3] = orderedRanks[0];  //extra card
        }

        else if (sameCards == 3 && sameCards2 != 2)
        //three of a kind (not full house)
        {
            cardRanks[0] = 4;
            cardRanks[1] = largeGroupRank;
            cardRanks[2] = orderedRanks[0];
            cardRanks[3] = orderedRanks[1];
        }
        else if (sameCards == 3 && sameCards2 == 2)  //full house
        {
            cardRanks[0] = 7;
            cardRanks[1] = largeGroupRank;
            cardRanks[2] = smallGroupRank;
        }

        else if (sameCards == 4)  //four of a kind
        {
            cardRanks[0] = 8;
            cardRanks[1] = largeGroupRank;
            cardRanks[2] = orderedRanks[0];
        }

        
        if (haveStraight)
        {
            cardRanks[0] = 5;
            cardRanks[1] = largeGroupRank;
        }
        else if (haveFlush)   
        {
            cardRanks[0] = 6;
            cardRanks[1] = orderedRanks[0]; //tie determined by ranks of cards
            cardRanks[2] = orderedRanks[1];
            cardRanks[3] = orderedRanks[2];
            cardRanks[4] = orderedRanks[3];
            cardRanks[5] = orderedRanks[4];
        }
        else if (haveStraight && haveFlush)  //straight flush
        {
            cardRanks[0] = 9;
            cardRanks[1] = 1;
        }
        
        handRank = cardRanks[0];
        bestCard = cardRanks[1];
    }
    
    void displayAll()
    {
        for (int x=0; x<5; x++)
            System.out.println(Card.rankAsString(myHand[x].getRank()) + " , " + Card.returnString(myHand[x].getSuit()));
    }
    
    int compareTo(Hand that)
    {
        for (int x=0; x<6; x++) //cycle through values
        {
            if (this.cardRanks[x]>that.cardRanks[x])
                return 1;
            else if (this.cardRanks[x] < that.cardRanks[x])
                return -1;
        }
        return 0; //if hands are equal
    }
    
    void display()
    {
        String s;
        switch( cardRanks[0] )
        {
            case 1:
                s = "high card";
                break;
            case 2:
                s = "pair of " + Card.rankAsString(cardRanks[1]) + "\'s";
                break;
            case 3:
                s = "two pair " + Card.rankAsString(cardRanks[1]) + " " + 
                    Card.rankAsString(cardRanks[2]);
                break;
            case 4:
                s = "three of a kind " + Card.rankAsString(cardRanks[1]) + "\'s";
                break;
            case 5:
                s = Card.rankAsString(cardRanks[1]) + " high straight";
                break;
            case 6:
                s = "flush";
                break;
            case 7:
                s = "full house " + Card.rankAsString(cardRanks[1]) + 
                    " over " + Card.rankAsString(cardRanks[2]);
                break;
            case 8:
                s = "four of a kind " + Card.rankAsString(cardRanks[1]);
                break;
            case 9:
                s = "straight flush " + Card.rankAsString(cardRanks[1]) + " high";
                break;
            default:
                s = "error in Hand.display: cardRanks[0] contains invalid value";
        }
        s = "                " + s;
        // moves the output over a little in the console 
        //so its easier to see when viewing the output
        System.out.println(s);
    }
    
    public int getHandRank()
    {
        return handRank;
    }
    
    public int getBestCard()
    {
        return bestCard;
    }
}