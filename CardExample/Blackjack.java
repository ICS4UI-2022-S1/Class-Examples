import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        // game variables
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        Hand player = new Hand();
        Hand dealer = new Hand();

        // start game
        // 2 cards to player
        player.addCard(deck.dealACard());
        player.addCard(deck.dealACard());
        // dealer gets 1 card
        dealer.addCard(deck.dealACard());
        int playerTotal = player.countTotal();
        int dealerTotal = dealer.countTotal();
        
        System.out.println("Dealer Cards:");
        dealer.printCards();
        System.out.println("Dealer Total: " + dealerTotal);
    
        int option = 0;
        Scanner input = new Scanner(System.in);
        while(option != 1 && playerTotal < 21){
            System.out.println("Player Cards:");
            player.printCards();
            System.out.println("Player Total: " + playerTotal);
       
            System.out.println("Do you want to stay(1) or hit(2)?");
            option = input.nextInt();
            // get a new card
            if(option == 2){
                // add a card to the player and update total
                player.addCard(deck.dealACard());
                playerTotal = player.countTotal();
            }
        }
        // print the final player cards
        System.out.println("Player Cards:");
        player.printCards();
        System.out.println("Player Total: " + playerTotal);
       
        // check for bust
        if(playerTotal > 21){
            System.out.println("Player busts. Dealer wins!");
        }else{
            // dealer's turn
            while(dealerTotal < 16){
                // add a card
                dealer.addCard(deck.dealACard());
                // update total
                dealerTotal = dealer.countTotal();
                // printer dealer cards and total
                System.out.println("Dealer Cards:");
                dealer.printCards();
                System.out.println("Dealer Total: " + dealerTotal);
            }
            // determine the winner
            // check for dealer bust
            if(dealerTotal > 21){
                System.out.println("Dealer busts. Player wins!");
            }else if(dealerTotal > playerTotal){
                System.out.println("Dealer wins!");
            }else if(playerTotal > dealerTotal){
                System.out.println("Player wins!");
            }else{
                System.out.println("It's a tie!");
            }

        }
        

    }
}
