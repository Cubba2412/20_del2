import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Print {

    private String[] Options;
    private String Turn;
    private String Language;
    private String[] PlayerNamePrompt;
    private String[] FVPWord;
    private String ExtraTurn;
    private String[] endGame;
    private String AccountError;
    public Print() {
    }

    public void AskForLanguage(Scanner scanner) throws FileNotFoundException {
        System.out.println("Please choose a language \n");
        System.out.println("1. English \n");
        String s;
        System.out.println("2. Danish \n");
        int choice = scanner.nextInt();
        if(choice==1) {
            Language = "English";
        }
        else {
            Language = "Danish";
        }

        setPrints();
    }

    public void setPrints() throws FileNotFoundException {
        if (Language.equals("English")) {
            String filepath = ".\\PrintStatements\\EnglishOptions.txt";
            Options = loadMultiLine(filepath,11);
            filepath = ".\\PrintStatements\\EnglishTurn.txt";
            Turn = loadSingleLine(filepath);
            filepath = ".\\PrintStatements\\EnglishPlayerNamePrompt.txt";
            PlayerNamePrompt = loadMultiLine(filepath,2);
            filepath = ".\\PrintStatements\\EnglishFVPWord.txt";
            FVPWord = loadMultiLine(filepath,3);
            filepath = ".\\PrintStatements\\EnglishExtraTurn.txt";
            ExtraTurn = loadSingleLine(filepath);
            filepath = ".\\PrintStatements\\EnglishEndGame.txt";
            endGame = loadMultiLine(filepath,2);
            filepath = ".\\PrintStatements\\EnglishAccountError.txt";
            AccountError = loadSingleLine(filepath);
        }
        else if (Language.equals("Danish")) {

        }


    }

    public String promptNames(int i) {
        Scanner s = new Scanner(System.in);
        System.out.println(PlayerNamePrompt[i]);
        System.out.println();
        return s.nextLine();
    }
    public String getLanguage() {
        return Language;
    }

    public void PrintField(int FieldNr) {
        System.out.println(Options[FieldNr]);
    }
    public String getLWord() {
        return FVPWord[0];
    }
    public String getVWord() {
        return FVPWord[1];
    }
    public String getPWord() {
        return FVPWord[2];
    }
    public void ExtraTurn() {
        System.out.println(ExtraTurn);
    }
    public void AccountError() {
        System.out.println(AccountError);
    }
    public void newRound() {
        System.out.println("--------------------------------");
        System.out.println();
    }
    public void endGame(String playerName) {
        newRound();
        System.out.println(playerName + endGame[0]);
        System.out.println(endGame[1]);
    }

    public String printTurn() {
        return Turn;
    }

    static String[] loadMultiLine(String pathToFile, int lines) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathToFile));
        String[] st = new String[lines];
        for(int i = 0;i<lines;i++){
            st[i] = s.nextLine();
        }
        s.close();
        return st;
    }

    static String loadSingleLine(String pathToFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathToFile));
        String st = s.nextLine();
        s.close();
        return st;
    }
}
