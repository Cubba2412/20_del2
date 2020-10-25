import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Print {

    private String[] Options;
    private String Turn;
    private String Language;
    private String[] PlayerNamePrompt;

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
        if (Language=="English") {
            String filepath = ".\\PrintStatements\\EnglishOptions.txt";
            Options = loadMultiLine(filepath,11);
            filepath = ".\\PrintStatements\\EnglishTurn.txt";
            Turn = loadSingleLine(filepath);
            filepath = ".\\PrintStatements\\EnglishPlayerNamePrompt.txt";
            PlayerNamePrompt = loadMultiLine(filepath,2);
        }
        else if (Language=="Danish") {

        }


    }

    public String promptNames(int i) {
        Scanner s = new Scanner(System.in);
        System.out.println(PlayerNamePrompt[i]);
        System.out.println();
        String playerName = s.nextLine();
        return playerName;
    }
    public String getLanguage() {
        return Language;
    }

    public void PrintField(int FieldNr) {
        System.out.println(Options[FieldNr]);
    }

    public String printTurn() {
        return Turn;
    }

    static String[] loadMultiLine(String pathToFile, int length) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathToFile));
        String[] st = new String[length];
        for(int i = 0;i<st.length;i++){
            st[i] = s.nextLine();
        }
        s.close();
        return st;
    }

    static String loadSingleLine(String pathToFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathToFile));
        String st = new String(s.nextLine());
        s.close();
        return st;
    }
}
