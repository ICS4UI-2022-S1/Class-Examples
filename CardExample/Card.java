public class Card {
    // instance variables
    // always private for "security"
    private String suit;
    private int value;
    private boolean faceUp;

    // constructor
    // to initialize all the instance variables
    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
        this.faceUp = false;
    }

    // class methods

    // accessor/getter method -
    // to peek at the value inside an instance variable
    public int getValue(){
        return this.value;
    }

    public String getSuit(){
        return this.suit;
    }

    public boolean isFaceUp(){
        return this.faceUp;
    }

    // mutator/setter method
    // used to change the value of a variable
    public void flip(){
        if(this.faceUp){
            this.faceUp = false;
        } else {
            this.faceUp = true;
        }
    }

    // toString method
    // to print out cards nicely to the screen
    public String toString(){
        if(this.faceUp){
            String rank = "";
            if(this.value == 1){
                rank = "Ace";
            }else if(this.value == 11){
                rank = "Jack";
            }else if(this.value == 12){
                rank = "Queen";
            }else if(this.value == 13){
                rank = "King";
            }else{
                rank = "" + this.value;
            }
        
            return rank + " of " + this.suit;
        }else{
            return "A face down card";
        }
        
    }

}