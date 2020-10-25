import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintOptions {

    static void PrintOptions(String[] Options) {

    }

    static void PrintField(int FieldNr) {

    }

    static String[] loadOptions(String pathToFile) throws FileNotFoundException {
        String filename = pathToFile;
        Scanner s = new Scanner(new File(pathToFile));
        String[] Options = new String[11];
        for(int i = 0;i<Options.length;i++){
            Options[i] = s.nextLine();
        }
        s.close();
        return Options;
    }
}
