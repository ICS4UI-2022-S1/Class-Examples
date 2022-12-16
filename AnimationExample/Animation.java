import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Animation {
    private BufferedImage[] frames;
    private int frame;
    private boolean playing;
    private int changeAfter;
    private int count;

    public Animation(String sheetName, int numImages, int width, int height, int changeAfter){
        BufferedImage sheet = null;
        try{
            sheet = ImageIO.read(new File(sheetName));
        }catch(Exception e){
            e.printStackTrace();
        }

        frames = new BufferedImage[numImages];
        for(int i = 0; i < frames.length; i++){
            frames[i] = sheet.getSubimage(i*width, 0, width, height);
        }

        this.changeAfter = changeAfter;

        this.frame = 0;
        this.playing = false;
        this.count = 0;
    }

    public void stop(){
        this.playing = false;
    }

    public void start(){
        if(!this.playing){
            this.playing = true;
            this.count = 0;
            this.frame = 0;
        }
    }

    public BufferedImage getFrame(){
        return this.frames[this.frame];
    }

    public void update(){
        this.count++;
        if(this.count >= this.changeAfter){
            this.count = 0;
            this.frame = (this.frame + 1) % this.frames.length;
        }
    }

    public boolean isPlaying(){
        return this.playing;
    }
}
