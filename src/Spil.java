import java.util.Random;
import java.util.Scanner;

public class Spil {

    private Spiller player1;
    private Spiller player2;
    private Spiller currentPlayer;
    private FeltListe feltList = new FeltListe();
    private Terning terning = new Terning();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void start() {
        System.out.println("Enter player1 name");
        String player1Name = scanner.nextLine();
        player1 = new Spiller(player1Name);

        System.out.println("Enter player2 name");
        String player2Name = scanner.nextLine();
        player2 = new Spiller(player2Name);

        System.out.println();

        //player1 starts the game
        currentPlayer = player1;

        startGame();
    }
}
