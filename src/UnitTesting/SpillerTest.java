package UnitTesting;
import Classes.Spiller;
import Classes.Konto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpillerTest {

    @Test
    void getKontoTest() {
        Spiller player = new Spiller("Steve");
        Konto Account = player.getKonto();
        int Money = Account.getPengeBeholdning();
        assertEquals(1000,Money);
    }
}