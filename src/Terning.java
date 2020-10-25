import java.util.Random;

public class Terning {

    private Random random = new Random();

    private int generateRandomDiceValue(){
        int diceMinimumValue = 1;
        int diceMaximumValue = 6;
        return diceMinimumValue + random.nextInt((diceMaximumValue - diceMinimumValue) + 1);
    }

    public int kast()
    {
        int sum = generateRandomDiceValue() + generateRandomDiceValue();
        return sum;
    }
}
