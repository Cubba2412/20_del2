package UnitTesting;
import Classes.Print;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    Print myPrint = new Print();
    @Test
    void loadMultiLineTest() throws FileNotFoundException {
        //Check input multiline print statement files for correct lengths
        String[] Path = new String[] {".\\PrintStatements\\English\\",".\\PrintStatements\\Danish\\"};
        for(int i=0;i<2;i++) {
            String filepath = Path[i] + "Options.txt";
            String[] Options = myPrint.loadMultiLine(filepath, 11);
            int n = Options.length;
            assertEquals(n, 11);
            filepath = Path[i] + "PlayerNamePrompt.txt";
            String[] PlayerNamePrompt = myPrint.loadMultiLine(filepath, 2);
            n = PlayerNamePrompt.length;
            assertEquals(n, 2);
            filepath = Path[i] + "EndGame.txt";
            String[] endGame = myPrint.loadMultiLine(filepath, 2);
            n = endGame.length;
            assertEquals(n, 2);
        }
    }
}