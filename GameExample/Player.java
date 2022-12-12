package GameExample;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends Sprite{
    
    public Player(int x, int y, int width, int height, int speed){
        super(x, y, width, height, speed);
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        super.draw(g);
    }

}
