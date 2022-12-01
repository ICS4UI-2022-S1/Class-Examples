package TDD;

public class BowlingGame {
    private int[] pinsKnockedDown;
    private int rollNumber;

    public BowlingGame() {
        this.pinsKnockedDown = new int[24];
        this.rollNumber = 0;
    }

    private boolean isSpare(int i) {
        int score = this.pinsKnockedDown[i] + this.pinsKnockedDown[i + 1];
        if (score == 10) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isStrike(int i){
        if(this.pinsKnockedDown[i] == 10){
            return true;
        }else{
            return false;
        }
    }

    public int getScore() {
        int score = 0;
        int frame = 0;
        for (int i = 0; i < 20; i += 2) {
            score = score + this.pinsKnockedDown[i] + this.pinsKnockedDown[i + 1];
            if(isStrike(i) && i <= 19){
                if(isStrike(i+2)){
                    score = score + this.pinsKnockedDown[i + 2] + this.pinsKnockedDown[i+4];
                }else{
                    score = score + this.pinsKnockedDown[i + 2] + this.pinsKnockedDown[i+3];
                }
                
            }else if (isSpare(i) && i <= 19) {
                score = score + this.pinsKnockedDown[i + 2];
            }
        }
        return score;
    }

    public void roll(int pins) {
        // rolled a strike
        if (pins == 10) {
            this.pinsKnockedDown[this.rollNumber] = pins;
            this.rollNumber++;
            this.pinsKnockedDown[this.rollNumber] = 0;
            this.rollNumber++;
        } else {
            this.pinsKnockedDown[this.rollNumber] = pins;
            this.rollNumber++;
        }

    }
}
