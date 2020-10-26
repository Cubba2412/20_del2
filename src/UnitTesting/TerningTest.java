package UnitTesting;

import org.junit.jupiter.api.Test;
import Classes.Terning;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TerningTest {
    Terning terning = new Terning();
    @Test
    void diceThrowTest() {
        int val = terning.generateRandomDiceValue();
        assertTrue(0 < val && val <= 6);
    }

    @Test
    void testRandomness() {
        int[] vals = new int[60000];
        for (int i = 0;i<vals.length;i++) {
            vals[i] = terning.generateRandomDiceValue();
        }
        int[] freq = new int[5];
        for (int i = 1;i<freq.length+1;i++) {
            freq[i-1] = Collections.frequency(Arrays.asList(vals), i);
        }
        for (int i = 0;i<freq.length;i++) {
            assertTrue(freq[i] <= 9600 && freq[i] <= 10400);
        }
    }
}