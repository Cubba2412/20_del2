import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    Print myPrint = new Print();
    @Test
    void loadOptions() throws FileNotFoundException {
        String[] Options = myPrint.loadOptions(".\\PrintStatements\\EnglishOptions.txt");
        int n = Options.length;
        assertEquals(n,11);
    }
}