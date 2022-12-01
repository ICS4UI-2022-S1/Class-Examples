package TDD;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BowlingTest {

    private void rollABunch(BowlingGame g, int howMany, int pins){
        for(int i = 0; i < howMany; i++){
            g.roll(pins);
        }
    }

    @Test
    public void testGutterGame(){
        BowlingGame g = new BowlingGame();
        // knock down 0 pins 20 times
        rollABunch(g, 20, 0);
        int score = g.getScore();
        int expected = 0;
        // assertEquals(expected to see, actually got)
        assertEquals(expected, score );
    }

    @Test
    public void onePointGame(){
        BowlingGame g = new BowlingGame();
        g.roll(1);
        rollABunch(g, 19, 0);
        assertEquals(1, g.getScore());
    }

    @Test
    public void rollASpare(){
        BowlingGame g = new BowlingGame();
        // spare
        g.roll(6);
        g.roll(4);
        g.roll(5);
        // finish the game rolling 0
        rollABunch(g, 17, 0);
        assertEquals(20, g.getScore());
    }

    @Test
    public void rollStrike(){
        BowlingGame g = new BowlingGame();
        g.roll(10);
        g.roll(4);
        g.roll(3);
        rollABunch(g,16,0);
        assertEquals(24, g.getScore());
    }

    @Test
    public void perfectGame(){
        BowlingGame g = new BowlingGame();
        rollABunch(g, 12, 10);
        assertEquals(300, g.getScore());
    }
}
