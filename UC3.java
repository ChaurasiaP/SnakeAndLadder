package UseCases;

public class UC3 {
    private int playerPos=0;
    private int check;
    private int value;
    private final int NO_PLAY =0;
    private final int SNAKE =1;
    private final int LADDER =2;


    public static void main(String[] args) {
        UC3 get = new UC3();
        System.out.println("Game Begins!");
        System.out.println("Initial Position: "+get.playerPos);

        get.playGame();

    }

    void rollDie(){
        value = (int) Math.floor(Math.random()*10%6)+1;  //typecasted random to int %6 to get output from 0to5, so +1
        System.out.println("Die roll is: "+value);
    }
    int checkOption(){  // random func to get 0, 1 or 2 to decide playing option
        check = (int) Math.floor(Math.random()*10)%3;
        return check;
    }

    void playGame() {
            switch (checkOption()) {    //checking for playing

                case NO_PLAY: // case 0
                    System.out.println("Uh-Ohh! Its a no play. Try Again");
                    System.out.println();
                    break;

                case SNAKE: // case 1
                    rollDie();
                    System.out.println("OOPS!! Snake caught you, move back " + value + " moves");
                    playerPos -= value; // player move back dice roll value times
                    System.out.println("Your new position is: " + playerPos);
                    System.out.println();
                    break;

                case LADDER:    // case 2
                    rollDie();
                    System.out.println("Yayy!! Its a ladder, go ahead " + value + " moves");
                    playerPos += value; // player moves ahead dice roll value times
                    System.out.println();
                    break;
        }
    }
}
