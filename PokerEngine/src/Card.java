public class Card
{
    private int rank;
    private int suit;
    private static String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    private static String[] ranks  = {"", "Ace", "2", "3", "4", "5", "6", "7", "8", 
                                        "9", "10", "Jack", "Queen", "King"};
    
    public Card(int myRank, int mySuit)
    {
        rank = myRank;
        suit = mySuit;
    }
    
    public static String rankAsString(int myRank) 
    {
        return ranks[myRank];
    }
    
    public static String returnString(int mySuit)
    {
        return suits[mySuit];
    }
    
    public int getRank()
    {
        return rank;
    }
    
    public int getSuit()
    {
        return suit;
    }
}