package GameExample;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
    private int x, y, width, height;

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
    
}
