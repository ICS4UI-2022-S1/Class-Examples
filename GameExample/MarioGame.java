package GameExample;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.Timer;


/**
 *
 * @author 
 */
public class MarioGame extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an appropriate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    Player mario = new Player(20, 450, 40, 75, 5);
    Goomba e1 = new Goomba(350, 450, 25, 25, 2, Goomba.LEFT);
    ArrayList<Block> blocks = new ArrayList<>();

    boolean right = false;
    boolean left = false;
    boolean jump = false;

    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public MarioGame(){
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        

        // Set things up for the game at startup

        setup();


       // Start the game loop
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE

        for(Block b: blocks){
            b.draw(g);
        }

        mario.draw(g);
        e1.draw(g);



        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        // Any of your pre setup before the loop starts should go here
        // create the blocks
        blocks.add(new Block(0, 525, 600, 100));
        blocks.add(new Block(300, 300, 50, 50));
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void loop() {
        // determine player actions
        if(right){
            mario.setDX(Player.RIGHT);
        }else if(left){
            mario.setDX(Player.LEFT);
        }else{
            mario.setDX(0);
        }

        // check for collisions
        // assume mario is falling
        mario.setOnGround(false);
        e1.setOnGround(false);
        // check for collisions
        for(Block b: blocks){
            if(mario.collides(b)){
                if(mario.onTopOfBlock(b)){
                    mario.setOnGround(true);
                }
            }

            // goomba check
            if(e1.collides(b)){
                if(e1.onTopOfBlock(b)){
                    e1.setOnGround(true);
                }
            }
        }


        // update the player
        mario.update();
        e1.update();
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_D){
                right = true;
            }else if(key == KeyEvent.VK_A){
                left = true;
            }else if(key == KeyEvent.VK_SPACE){
                jump = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_D){
                right = false;
            }else if(key == KeyEvent.VK_A){
                left = false;
            }else if(key == KeyEvent.VK_SPACE){
                jump = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        MarioGame game = new MarioGame();
    }
}


