import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Print {

    private String[] Options;
    private String Turn;
    private String Language;

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
            String[] Options = loadOptions(filepath);
            filepath = ".\\PrintStatements\\EnglishTurn.txt";
            String Turn = loadTurn(filepath);
        }
        else if (Language=="Danish") {

        }


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

    static String[] loadOptions(String pathToFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathToFile));
        String[] Options = new String[11];
        for(int i = 0;i<Options.length;i++){
            Options[i] = s.nextLine();
        }
        s.close();
        return Options;
    }

    static String loadTurn(String pathToFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(pathToFile));
        String turn = new String(s.nextLine());
        s.close();
        return turn;
    }
}
