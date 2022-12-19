import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private int dx;

    private Animation idle;
    private Animation run;

    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = 0;
        this.speed = 3;

        this.idle = new Animation("AnimationExample/images/Idle.png", 11, 32, 32, 4);
        this.run = new Animation("AnimationExample/images/Run.png", 12, 32, 32, 4);
    }

    public void draw(Graphics g){
        if(idle.isPlaying()){
            g.drawImage(idle.getFrame(), this.x, this.y, 32, 32, null);
        }else{
            g.drawImage(run.getFrame(), this.x, this.y, 32, 32, null);
        }
        
    }

    public void update(){
        this.x = this.x + dx;

        if(this.idle.isPlaying()){
            this.idle.update();
        }else if(this.run.isPlaying()){
            this.run.update();
        }

    }

    public void moveLeft(){
        this.dx = -1;
        this.idle.stop();
        this.run.start();
    }

    public void moveRight(){
        this.dx = 1;
        this.idle.stop();
        this.run.start();
    }

    public void stop(){
        this.dx = 0;
        this.idle.start();
        this.run.stop();
    }
}
