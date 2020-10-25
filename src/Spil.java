import java.io.FileNotFoundException;
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
        Print print = new Print();
        try {
            print.AskForLanguage(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String player1Name = print.promptNames(0);
        player1 = new Spiller(player1Name);
        String player2Name = print.promptNames(1);
        player2 = new Spiller(player2Name);

        System.out.println();

        //player1 starts the game
        currentPlayer = player1;

        startGame(print);
    }

    private void startGame(Print print) {
        int winningPoints = 3000;
        boolean gameIsRunning = true;
        while (gameIsRunning) {

            String PlayerName = currentPlayer.getNavn();
            System.out.println(PlayerName + print.printTurn());
            String waitForDiceThrow = scanner.nextLine();

            int feltKey = terning.kast();

            FeltListKeyValue keyValue = feltList.getVærdi(feltKey);
            int value = keyValue.getValue();
            print.PrintField(feltKey);

            Konto konto = currentPlayer.getKonto();
            boolean Success = konto.updatePengeBeholdning(value);
            if (!Success) {
                print.AccountError();
            }

            System.out.println(PlayerName + print.getAccount() + konto.getPengeBeholdning());

            if (konto.getPengeBeholdning() >= winningPoints) {
                print.endGame(PlayerName);
                gameIsRunning = false;
                return; //exit the method
            }
            if (keyValue.giverEkstraTur()) {
                print.ExtraTurn();
            }
            else{
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
            }
            print.newRound();
        }
    }
}


