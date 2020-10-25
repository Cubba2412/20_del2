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
        int vinderPengeBeholdningPoints = 3000;
        boolean gameIsRunning = true;
        while (gameIsRunning) {

            String spillerNavn = currentPlayer.getNavn();
            System.out.println(spillerNavn + print.printTurn());
            String waitForDiceThrow = scanner.nextLine();

            int feltKey = terning.kast();

            FeltListKeyValue keyValue = feltList.getVærdi(feltKey);
            int value = keyValue.getValue();
            System.out.println(print.getLWord() + feltKey + print.getVWord() + value);

            Konto konto = currentPlayer.getKonto();
            boolean gennemført = konto.updatePengeBeholdning(value);
            if (!gennemført) {
                System.out.println("Konto'en blev ikke opdateret");
            }

            System.out.println(spillerNavn + print.getPWord() + konto.getPengeBeholdning());

            if (konto.getPengeBeholdning() >= vinderPengeBeholdningPoints) {
                System.out.println(spillerNavn + " has won the game! :)");
                System.out.println("GAME OVER");
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


