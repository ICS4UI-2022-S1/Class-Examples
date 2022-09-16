
public class CardTest {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        Card c1 = deck.dealACard();
        c1.flip();
        System.out.println(c1);
    }
}
