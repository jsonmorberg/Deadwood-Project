import java.util.Random;

/** Class that handles rolling of 6 sided die */

public class Dice{

    public static int roll(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

}