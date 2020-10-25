import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Print {

    private String[] Options;
    private String Turn;

    public void Print(String language) throws FileNotFoundException {
        if (language=="English") {
            String filepath = ".\\PrintStatements\\EnglishOptions.txt";
            String[] Options = loadOptions(filepath);
            filepath = ".\\PrintStatements\\EnglishTurn.txt";
            String Turn = loadTurn(filepath);
        }
        else if (language=="Danish") {

        }


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
