

public class DeckOfCards {
    private int numCardsLeft;
    private Card[] cards = new Card[52];


    public DeckOfCards(){
        this.makeSuit("Hearts");
        this.makeSuit("Spades");
        this.makeSuit("Diamonds");
        this.makeSuit("Clubs");

    }

    private void makeSuit(String name){
        for(int i = 1; i <=13; i++){
            Card c = new Card(i, name);
            cards[this.numCardsLeft] = c;
            this.numCardsLeft++;
        }
    }

    public int getNumCardsLeft(){
        return this.numCardsLeft;
    }

    public Card dealACard(){
        this.numCardsLeft--;
        return this.cards[this.numCardsLeft];
    }

    // Fischer-Yates Shuffle Algorithm
    public void shuffle(){
        for(int i = 0; i < this.numCardsLeft; i++){
            // get the swap spot
            int spot = (int)(Math.random()*(this.numCardsLeft-i)+i);
            // save the Card in one position
            Card temp = this.cards[spot];
            this.cards[spot] = this.cards[i];
            this.cards[i] = temp;
        }
    }

    public void reset(){
        this.numCardsLeft = 52;
        this.shuffle();
        
    }
}
