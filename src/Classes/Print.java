package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Print {

    private String[] Options;
    private String Turn;
    private String Language;
    private String[] PlayerNamePrompt;
    private String[] endGame;
    private String AccountError;
    private String Path;
    private String Account;
    private String AskForEnter;
    public Print() {
    }

    public void AskForLanguage() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please choose a language \n");
        System.out.println("1. English \n");
        System.out.println("2. Danish \n");
        int choice = s.nextInt();
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
            Path = ".\\PrintStatements\\English\\";
        }
        else if (Language.equals("Danish")) {
            Path = ".\\PrintStatements\\Danish\\";
        }
        String filepath = Path + "Options.txt";
        Options = loadMultiLine(filepath,11);
        filepath = Path + "Turn.txt";
        Turn = loadSingleLine(filepath);
        filepath = Path + "PlayerNamePrompt.txt";
        PlayerNamePrompt = loadMultiLine(filepath,2);
        filepath = Path + "EndGame.txt";
        endGame = loadMultiLine(filepath,2);
        filepath = Path + "AccountError.txt";
        AccountError = loadSingleLine(filepath);
        filepath = Path + "Account.txt";
        Account = loadSingleLine(filepath);
        filepath = Path + "AskForEnter.txt";
        AskForEnter = loadSingleLine(filepath);
    }

    public String promptNames(int i) {
        Scanner s = new Scanner(System.in);
        System.out.println(PlayerNamePrompt[i]);
        System.out.println();
        return s.nextLine();
    }

    public void PrintField(int FieldNr) {
        System.out.println(Options[FieldNr-2]);
    }

    public String getAccount() {
        return Account;
    }
    public String AskForEnter() {
        return AskForEnter;
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

    //Public to be used for unit testing
    public String[] loadMultiLine(String pathToFile, int lines) throws FileNotFoundException {
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
