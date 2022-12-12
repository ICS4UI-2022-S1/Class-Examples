package GameExample;

import java.awt.Graphics;
import java.awt.Color;

public class Sprite {
    private int height;
    private int width;
    private int x;
    private int y;
    private int speed;
    private boolean onGround;

    private int dx;
    private int dy;

    public static final int GRAVITY = 1;
    public static final int RIGHT = 1;
    public static final int LEFT = -1;

    public Sprite(int x, int y, int width, int height, int speed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.onGround = false;
        this.dx = 0;
        this.dy = 0;
    }

    public void draw(Graphics g){
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void setDX(int value){
        this.dx = value;
    }

    public void update(){
       // move the x value
       this.x = this.x + this.dx*speed;

       if(!onGround){
           this.dy = this.dy + GRAVITY;
           this.y = this.y + this.dy;
       }
    }

    public void setOnGround(boolean value){
        this.onGround = value;
    }

    public boolean onTopOfBlock(Block b){
        // falling and above the block
        if(dy > 0 && this.y < b.getY()){
            return true;
        }else{
            return false;
        }
    }

    public boolean collides(Block b){
        if(this.x < b.getX() + b.getWidth() && 
            this.x + this.width > b.getX() &&
            this.y < b.getY() + b.getHeight() &&
            this.y + this.height > b.getY()){
                return true;
        }else{
            return false;
        }
    }

}
