package UseCases;

public class UC2 {
    private int playerPos;

    public static void main(String[] args) {
        UC2 ucObj = new UC2();

        ucObj.playerPos = ucObj.rollDie();
        System.out.println("Die is rolled and the number is: "+ucObj.playerPos);
    }

    int rollDie(){
        return (int) Math.floor(Math.random()*10%6)+1;  //typecasted random to int %6 to get output from 0to5, so +1;
    }
}
