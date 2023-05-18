package UseCases;

public class UC6 {

    private int playerPos = 0;
    private int check;
    private int value;
    private final int NO_PLAY = 0;
    private final int SNAKE = 1;
    private final int LADDER = 2;

    void rollDie() {
        value = (int) Math.floor(Math.random() * 10 % 6) + 1;  //typecasted random to int %6 to get output from 0to5, so +1
        System.out.println("Die roll is: " + value);
    }

    int checkOption() {  // random func to get 0, 1 or 2 to decide playing option
        check = (int) Math.floor(Math.random() * 10) % 3;
        return check;
    }

    void playGame() {
        int dieCount = 0;

        while (playerPos < 100) {      // ensuring it iterate till 100
            switch (checkOption()) {    //checking for playing
                case NO_PLAY:
                    System.out.println("Uh-Ohh! Its a no play. Try Again");
                    System.out.println();
                    break;

                case SNAKE:
                    rollDie();
                    dieCount++;
                    System.out.println("OOPS!! Snake caught you, move back " + value + " moves");
                    if (playerPos > 0 && (playerPos - value) >= 0) {    // ensuring playerPos is always +ve
                        playerPos -= value;
                    } else {        // if it gets -ve it resets position to ZERO
                        playerPos = 0;
                    }
                    System.out.println("Your new position is: " + playerPos);
                    System.out.println();
                    break;

                case LADDER:
                    rollDie();
                    dieCount++;
                    if ((playerPos + value) <= 100) {
                        System.out.println("Yayy!! Its a ladder, go ahead " + value + " moves");
                        playerPos += value;
                        System.out.println("Your new position is: " + playerPos);
                    }
                    if (playerPos == 100) {
                        System.out.println("Congratulations!! You Won");
                    }
                    System.out.println();
                    break;
            }
        }
        System.out.println("Total die counts: " + dieCount);
    }

    public static void main(String[] args) {
        UC6 get = new UC6();
        System.out.println("Game Begins!");
        System.out.println("Initial Position: " + get.playerPos);
        get.playGame();

    }
}
