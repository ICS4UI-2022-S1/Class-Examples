package GameExample;

import java.awt.Graphics;
import java.awt.Color;

public class Goomba extends Sprite {
    
    public Goomba(int x, int y, int width, int height, int speed, int direction){
        super(x,y,width,height, speed);
        this.setDX(direction);
    }

    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        super.draw(g);
    }
}
